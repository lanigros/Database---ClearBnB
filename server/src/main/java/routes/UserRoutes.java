package routes;

import datatransforobject.ReviewBasicDTO;
import datatransforobject.UserCoreDTO;
import datatransforobject.UserNameIdDTO;
import datatransforobject.UserProfileDTO;
import express.Express;
import java.util.List;
import java.util.Optional;
import model.Review;
import model.User;
import service.UserService;

public class UserRoutes {

  private final Express app;
  private final UserService userService;

  public UserRoutes(Express app) {
    this.app = app;
    this.userService = new UserService();
    this.init();
  }

  void init() {
    app.get("rest/user/:id", (req, res) -> {
      try {
        String id = req.params("id");
        Optional<UserCoreDTO> user = userService.getById(id);
        res.status(200).json(user.isPresent() ? user.get() : "No user with that id");
      } catch (Exception e) {
        res.status(500).send(e);
      }
    });
    app.get("rest/users/name", (req, res) -> {
      try {
        List<UserNameIdDTO> users = userService.getAllNames();
        res.json(users);
      } catch (Exception e) {
        res.status(500).json("internal error");
      }
    });
    app.get("rest/user/:id/profile", (req, res) -> {
      try {
        String id = req.params("id");
        UserProfileDTO user = userService.getUserProfile(id);
        res.json(user);
      } catch (Exception e) {
        res.status(500).json("internal error");
      }
    });
    app.get("rest/users", (req, res) -> {
      try {
        List<User> users = userService.getAllWithEverything();
        res.json(users);
      } catch (Exception e) {
        e.printStackTrace();
        res.status(500).json("internal error");
      }
    });
    app.post("rest/reviews/host/:id", (req, res) -> {
      //String sessionID = req.cookie("sessionID");
      String hostID = req.params("id");
      ReviewBasicDTO dto = req.body(ReviewBasicDTO.class);
      Review review = userService.createReview(dto, hostID);
      res.json(review);
    });
  }

}
