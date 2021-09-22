package routes;

import datatransforobject.HomeCoreDTO;
import express.Express;
import java.util.List;
import java.util.Optional;
import model.HomeHistoryLog;

import service.HomeService;

public class HomeRoutes {

  private final Express app;
  private final HomeService homeService;



  public HomeRoutes(Express app){
    this.app = app;
    this.homeService = new HomeService();
    this.init();
  }

  private void init(){
    app.get("rest/home/:id", (req, res) -> {
      try{
        String id = req.params("id");
        Optional<HomeCoreDTO> home = homeService.getById(id);
        res.json(home.isPresent() ? home.get() : "No home with that id");
      }catch (Exception e){
        res.status(500).send("Internal error");
      }
    });
      app.get("rest/home/:id/history", (req, res) -> {
          String id = req.params("id");
          List<HomeHistoryLog> history = homeService.getByHomeId(id);
          res.json(history);
  });



}
}
