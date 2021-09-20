package routes;

import express.Express;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.User;
import repository.UserRepository;
import utility.ManagerFactory;

public class UserRoutes {

  private final Express app;

  //this should probably be a singelton instance somewhere else
  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory("User");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final UserRepository userRepository = new UserRepository(entityManager);

  public UserRoutes(Express app) {
    this.app = app;
    this.init();

  }

  void init() {
    app.get("rest/users/:id", (req, res) -> {
      try {
        String id = req.params("id");
        Optional<User> user = userRepository.findById(id);
        res.status(200).json(user.isPresent() ? user.get() : "No user with that id");
      } catch (Exception e) {
        res.status(500).send(e);
      }
    });
    app.get("rest/users", (req, res) -> {
      List<User> users = null;
      try {
        users = userRepository.findAll();
        res.status(200).json(users);
      } catch (Exception e) {
        res.status(500).send(e);
      }
    });

  }
}
