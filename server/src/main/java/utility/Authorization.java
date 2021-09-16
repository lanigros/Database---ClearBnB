//package utility;
//
//import express.Express;
//import java.util.Map;
//import model.User;
//
//public class Authorization {
//  private Express app;
//
//  public Authorization(Express app){
//    this.app=app;
//    initAuthorization();
//  }
//
//  private void initAuthorization() {
//
//    app.post("/api/registerUser", (req, res) -> {   //Create user
//      User user = req.body(User.class);
//
//      User exist = collection("User").findOne("email==" + user.getEmail());
//      if (exist != null) {
//        res.json(Map.of("error", "Username already exist")); // Console variabel bara?
//        return;
//      }
//
//      String hashedPassword = HashPassword.hash(user.getPassword());
//      user.setPassword(hashedPassword);
//      collection("User").save(user);
//
//      req.session("current-user", user);
//      res.json(user);
//    });
//
//
//    app.post("/api/login", (req, res) -> {
//      User user = req.body(User.class);
//      User userInCollection = collection("User").findOne("email==" +user.getEmail());
//
//      if(userInCollection == null){
//        res.json(Map.of("error", "Control login details")); //Console Variable
//        return;
//      }
//
//      if(HashPassword.match(user.getPassword(), userInCollection.getPassword())){
//        req.session("current-user", userInCollection);
//
//        res.json(userInCollection);
//      }
//      else{
//        res.json(Map.of("error", "Control login details"));
//      }
//
//    });
//
//    app.get("/api/whoami", (req, res)-> {   //Control logged in user
//
//      res.json(req.session("current-user"));
//    });
//
//    app.get("/api/logout",(req,res)->{
//      req.session("current-user", null);
//
//      res.json(Map.of("ok", "Logged out"));
//    });
//  }
//}
//
//}
