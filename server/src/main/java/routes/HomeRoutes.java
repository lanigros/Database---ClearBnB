package routes;

import datatransforobject.HomeCoreDTO;
import express.Express;
import java.util.Optional;
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
  }



}
