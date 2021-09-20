package routes;

import Service.UserService;
import datatransforobject.UserCoreDTO;
import express.Express;
import java.util.List;
import java.util.Optional;
import model.User;

public class UserRoutes {

  private final Express app;
  private final UserService userService;

  public UserRoutes(Express app) {
    this.app = app;
    this.userService = new UserService();
    this.init();
  }

  void init() {
    app.get("rest/users/:id", (req, res) -> {
      try {
        String id = req.params("id");
        Optional<UserCoreDTO> user = userService.getById(id);
        res.status(200).json(user.isPresent() ? user.get() : "No user with that id");
      } catch (Exception e) {
        res.status(500).send(e);
      }
    });
    app.get("rest/users", (req, res) -> {
      try {
        List<User> users = userService.getAllWithEverything();
        res.json(users);
      } catch (Exception e) {
        res.status(500).json("internal error");
      }
    });

  }
}
