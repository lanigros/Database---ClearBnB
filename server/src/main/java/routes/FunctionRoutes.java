package routes;

import express.Express;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.User;
import repository.UserRepository;
import utility.ManagerFactory;
import utility.Utility;

public class FunctionRoutes {

  private final Express app;
  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory("User");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final UserRepository userRepository = new UserRepository(entityManager);

  public FunctionRoutes(Express app) {
    this.app = app;
    init();
  }

  private void init() {
    app.post("/api/register", (req, res) -> {
      try {
        User user = req.body(User.class);
        User exist = userRepository.findByEmail(user.getEmail());

        if (exist != null) {
          res.status(500).json(Map.of("error", "email already exist"));
          return;
        }
        //hashing password
        String hashedPassword = Utility.hash(user.getPassword());
        user.setPassword(hashedPassword);
        Optional<User> resUser = userRepository.save(user);
        req.session("current-user", user);
        res.status(201).json(resUser.get());
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).json(Map.of("error", "internal error"));
      }
    });

    app.post("api/login", (req, res) -> {

      try {
        User userCred = req.body(User.class);
        User exist = userRepository.findByEmail(userCred.getEmail());

        if (exist == null) {
          res.status(500).json(Map.of("error", "Check credentials"));
          return;
        }

        if (Utility.match(userCred.getPassword(), exist.getPassword())) {
          req.session("current-user", exist);
          res.json(exist);
        } else {
          res.json(Map.of("error", "Check credentials"));
        }
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).json(Map.of("error", "internal error"));
      }
    });

    //check current user
    app.get("/api/whoami", (req, res) -> {
      res.json(req.session("current-user"));
    });
  }
}
