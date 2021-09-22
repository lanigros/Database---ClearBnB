package routes;

import datatransforobject.UserCoreDTO;
import datatransforobject.UserLoginDTO;
import express.Express;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.ActiveSession;
import model.User;
import repository.ActiveSessionRepository;
import repository.UserRepository;
import utility.ManagerFactory;
import utility.Utility;

public class FunctionRoutes {

  private final Express app;
  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "User");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final UserRepository userRepository = new UserRepository(entityManager);
  private final ActiveSessionRepository activeSessionRepository = new ActiveSessionRepository(
      entityManager);
  private Map<String, Integer> sessions;


  public FunctionRoutes(Express app) {
    this.app = app;
    sessions = activeSessionRepository.getAllActiveSessions();
    init();
  }

  private void init() {
    app.post("/api/register", (req, res) -> {
      try {
        UserCoreDTO user = req.body(UserCoreDTO.class);
        User exist = userRepository.findByEmail(user.getEmail());
        if (exist != null) {
          res.status(500).json(Map.of("error", "email already exist"));
          return;
        }
        //hashing password
        String hashedPassword = Utility.hash(user.getPassword());
        user.setPassword(hashedPassword);
        Optional<User> newUser = userRepository.save(user.convertToUser());
        //To send a json
        res.status(201).json(Map.of("id", newUser.get().getId()));
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).json(Map.of("error", "internal error"));
      }
    });

    app.delete("/api/logout", (req, res) -> {
      try {
        String sessionId = req.cookie("sessionID");
        activeSessionRepository.deleteActiveSessionById(sessionId);
        sessions.remove(sessionId);
        res.json("OK");
      } catch (Exception e) {
        res.status(500);
      }
    });

    app.post("/api/login", (req, res) -> {

      try {
        UserLoginDTO userCred = req.body(UserLoginDTO.class);
        UserCoreDTO exist = userRepository.login(userCred.getEmail());

        if (exist == null) {
          res.status(500).send("Error, check credentials");
          return;
        }

        if (Utility.match(userCred.getPassword(), exist.getPassword())) {
          exist.setPassword("***");
          int userId = exist.getId();

          if (sessions.containsValue(userId)) {
            activeSessionRepository.deleteActiveSessionByUserId(userId);
          }
          ActiveSession activeSession = activeSessionRepository.insertActiveSession(
              userId, Utility.createRandomAlphanumeric()
          );
          sessions.put(activeSession.getId(), activeSession.getUserId());
          res.json(exist)
              .cookie(
                  Utility.generateCookie("userName", exist.getFirstName())
              )
              .cookie(
                  Utility.generateCookie("sessionID", activeSession.getId())
              );
        } else {
          res.status(500).send("Error, check credentials");
        }
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).send("Internal error");
      }
    });

    //check current user
    app.get("/api/whoami", (req, res) ->

    {
      try {
        String sessionId = req.cookie("sessionID");
        String userId = String.valueOf(sessions.get(sessionId));
        Optional<User> user = userRepository.findById(userId);
        UserCoreDTO userCoreDTO = user.get()
            .convertToUserCoreDTO();
        userCoreDTO.setPassword("***");
        res.json(userCoreDTO)
            .cookie(
                Utility.generateCookie("userName", userCoreDTO.getFirstName())
            )
            .cookie(
                Utility.generateCookie("sessionID", sessionId)
            );
      } catch (Exception e) {
        res.status(500);
      }
    });

  }
}
