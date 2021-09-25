package routes;

import datatransforobject.BookingDetailCoreDTO;
import datatransforobject.UserCoreDTO;
import datatransforobject.UserLoginDTO;
import express.Express;
import java.io.EOFException;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.BookingDetailMapper;
import mapper.UserMapper;
import model.ActiveSession;
import model.BookingDetail;
import model.Home;
import model.Renter;
import model.User;
import repository.ActiveSessionRepository;
import repository.UserRepository;
import service.ActiveSessionService;
import service.BookingDetailService;
import service.UserService;
import service.WalletService;
import utility.ManagerFactory;
import utility.Utility;

public class FunctionRoutes {

  private final Express app;
  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "User");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final UserRepository userRepository = new UserRepository(entityManager);
  private final UserService userService;
  private final ActiveSessionService activeSessionService;
  private final BookingDetailService bookingDetailService;

  public FunctionRoutes(Express app) {
    this.app = app;
    this.userService = new UserService();
    this.activeSessionService = new ActiveSessionService();
    this.bookingDetailService = new BookingDetailService();
    init();
  }

  private void init() {
    app.post("/api/register", (req, res) -> {
      try {
        UserCoreDTO user = req.body(UserCoreDTO.class);
        Optional<UserCoreDTO> createdUserCoreDTO = userService.registerUser(user);
        if(createdUserCoreDTO.isEmpty()){
          res.status(409).send("User already exists");
          return;
        }
        String activeSessionId = activeSessionService.createActiveSession(createdUserCoreDTO.get());
        res.json(createdUserCoreDTO.get())
            .cookie(Utility.generateCookie("userName", createdUserCoreDTO.get().getFirstName()))
            .cookie(Utility.generateCookie("sessionID", activeSessionId));
      } catch (Exception e) {
        e.printStackTrace();
        res.status(500).json(Map.of("error", "internal error"));
      }
    });

    app.delete("/api/logout", (req, res) -> {
      try {
        String sessionId = req.cookie("sessionID");
        activeSessionService.removeActiveSession(sessionId);
        res.json("OK")
            .cookie(Utility.generateCookie("userName", "none", 0))
            .cookie(Utility.generateCookie("sessionID", "none", 0)
        );
      } catch (Exception e) {
        res.status(500);
      }
    });

    app.post("/api/login", (req, res) -> {
      try {
        UserLoginDTO userCred = req.body(UserLoginDTO.class);
        UserCoreDTO userCoreDTO = userService.checkUserCredentials(userCred);
        if(userCoreDTO == null){
          res.status(401).send("Bad credentials");
          return;
        }
        String activeSessionId = activeSessionService.createActiveSession(userCoreDTO);
          res.json(userCoreDTO)
              .cookie(
                  Utility.generateCookie("userName", userCoreDTO.getFirstName())
              )
              .cookie(
                  Utility.generateCookie("sessionID", activeSessionId)
              );
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).send("Internal error");
      }
    });

    //check current user
    app.get("/api/whoami", (req, res) -> {
      try {
        String sessionId = req.cookie("sessionID");
        String userId = String.valueOf(ActiveSessionService.getActiveSessionUserId(sessionId));
        UserCoreDTO userCoreDTO = userService.findByIdAndReturnUserCoreDTO(userId);
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

    app.post("api/payment", (req, res) -> {
      /*try {*/
        //Get validation
        String sessionId = req.cookie("sessionID");
        //Get bookingDetailCoreDTO
        BookingDetailCoreDTO bookingDetailCoreDTO = req.body(BookingDetailCoreDTO.class);
        // Get the home linked to bookingDetail
       Optional<BookingDetail> bookingDetailOptional =
           bookingDetailService.createBooking(sessionId, bookingDetailCoreDTO);
       if(bookingDetailOptional.isPresent()){
         res.json(bookingDetailOptional.get());
       }else {
         res.status(402);
       }
      /*}catch(Exception e){
        res.status(500);
      }*/
    });
  }
}
