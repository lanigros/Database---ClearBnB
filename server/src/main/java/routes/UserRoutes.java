package routes;

import datatransforobject.UserCompleteProfileDTO;
import datatransforobject.UserCoreDTO;
import datatransforobject.UserNameIdDTO;
import datatransforobject.UserProfileDTO;
import express.Express;
import java.util.List;
import java.util.Optional;
import model.Review;
import model.User;
import service.ActiveSessionService;
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
    app.get("rest/user/private", (req, res) -> {
      try {
        String sessionID = req.cookie("sessionID");
        System.out.println(sessionID);
        String userId = String.valueOf(ActiveSessionService.getActiveSessionUserId(sessionID));
        UserCompleteProfileDTO user = userService.getUserCompleteProfile(userId);
        res.json(user);
      }catch (Exception e){
        res.json(500);
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

    app.get("rest/user/profile/:id", (req, res) -> {
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
