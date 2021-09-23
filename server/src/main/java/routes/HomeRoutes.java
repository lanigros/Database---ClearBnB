package routes;

import datatransforobject.HomeAddressDTO;
import datatransforobject.HomeCoreDTO;
import express.Express;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import model.Home;
import model.HomeHistoryLog;
import service.HomeService;

public class HomeRoutes {

  private final Express app;
  private final HomeService homeService;


  public HomeRoutes(Express app) {
    this.app = app;
    this.homeService = new HomeService();
    this.init();
  }

  private void init() {
    app.get("rest/home/:id", (req, res) -> {
      try {
        String id = req.params("id");
        Optional<HomeCoreDTO> home = homeService.getById(id);
        res.json(home.isPresent() ? home.get() : "No home with that id");
      } catch (Exception e) {
        res.status(500).send("Internal error");
      }
    });

    app.get("rest/home/:id/history", (req, res) -> {
      String id = req.params("id");
      List<HomeHistoryLog> history = homeService.getByHomeId(id);
      res.json(history);
    });

    /* Filer by price or by date.
     ** price=?
     ** start_date=d/M/yyyy
     ** end_date = d/M/yyyy
     */
    app.get("rest/homes", (req, res) -> {
      try {
        Map<String, List<String>> filters = req.query();
        List<Home> homes = homeService.getAll(filters);
        res.json(homes);
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).json("internal error");
      }
    });

    app.post("rest/home", (req, res) -> {
      String sessionID = req.cookie("sessionID");
      HomeAddressDTO dto = req.body(HomeAddressDTO.class);
      Optional<Home> home = homeService.createHome(sessionID, dto);
      res.json(home.get());

    });


  }
}

