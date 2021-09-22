package routes;

import datatransforobject.HomeCoreDTO;
import express.Express;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import model.Home;
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

// Filer by price or by date.
// price=?
// start_date=d/M/yyyy
// end_date = d/M/yyyy
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


  }
}
