package routes;

import datatransforobject.HomeCoreDTO;
import express.Express;
import java.util.List;
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

    app.get("rest/homes", (req, res) -> {
      try {
        List<Home> homes = homeService.getAllWithEverything();
        res.json(homes);
      } catch (Exception e) {
        System.out.println(e);
        res.status(500).json("internal error");
      }
    });


  }
}
