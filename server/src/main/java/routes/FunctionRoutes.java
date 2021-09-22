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
  private final ActiveSessionRepository activeSessionRepository = new ActiveSessionRepository(entityManager);

  public FunctionRoutes(Express app) {
    this.app = app;
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
        req.session("current-user", user.getId());
        //To send a json
        res.status(201).json(Map.of("id", newUser.get().getId()));
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).json(Map.of("error", "internal error"));
      }
    });

    app.delete("/api/logout", (req, res) -> {
      try{
        UserCoreDTO userCoreDTO = req.body(UserCoreDTO.class);
        activeSessionRepository.deleteActiveSessionByUserId(userCoreDTO.getId());
        req.session("current-user-id", null);
        res.json("Ok");
      }catch(Exception e){
        res.status(500);
      }
    });

    app.post("/api/login", (req, res) -> {

      try {
        UserLoginDTO userCred = req.body(UserLoginDTO.class);
        UserCoreDTO exist = userRepository.login(userCred.getEmail());
        System.out.println(exist.getId() + exist.getFirstName() + exist.getLastName() + exist.getPassword());

        if (exist == null) {
          res.status(500).send("Error, check credentials");
          return;
        }

        if (Utility.match(userCred.getPassword(), exist.getPassword())) {
          exist.setPassword("***");
          req.session("current-user-id", exist.getId());
          activeSessionRepository.deleteActiveSessionByUserId(exist.getId());
          activeSessionRepository.insertActiveSession(exist.getId());
          res.json(exist);
        } else {
          res.status(500).send("Error, check credentials");
        }
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).send("Internal error");
      }
    });

    //check current user
    app.get("/api/whoami", (req, res) -> {
      try {
        ActiveSession activeSession = activeSessionRepository.getActiveSession(
            req.session("current-user-id"));
        System.out.println((int)req.session("current-user-id"));
        Optional<User> user = userRepository.findById(String.valueOf(activeSession.getUserId()));
        UserCoreDTO userCoreDTO = user.get().convertToUserCoreDTO();
        userCoreDTO.setPassword("***");
        res.json(userCoreDTO);
      }catch(Exception e){
        res.status(500);
      }

    });

  }
}
