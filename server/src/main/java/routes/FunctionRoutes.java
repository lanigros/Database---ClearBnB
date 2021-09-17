package routes;

import express.Express;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.User;
import repository.UserRepository;
import utility.Utility;

public class FunctionRoutes {

  private final Express app;
  private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
      "User");
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
        
        res.status(201).json(resUser.get());
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).json(Map.of("error", "internal error"));
      }
    });
  }
}
