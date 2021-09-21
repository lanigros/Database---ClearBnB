package routes;

import datatransforobject.HomeCoreDTO;
import datatransforobject.HomeHistoryDTO;
import express.Express;
import java.util.Optional;
import service.HomeHistoryService;
import service.HomeService;

public class HomeHistoryRoutes {
    private final Express app;
    private final HomeHistoryService homeHistoryService;

    public HomeHistoryRoutes(Express app){
        this.app = app;
        this.homeHistoryService= new HomeHistoryService();
        this.init();
    }

    private void init(){
        app.get("rest/home/:id/history", (req, res) -> {

              String id = req.params("id");
              Optional<HomeHistoryDTO> history = homeHistoryService.getById(id);
              res.json(history.isPresent() ? history.get() : "No history on that specific home");

        });
    }

}
