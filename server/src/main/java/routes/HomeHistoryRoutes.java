package routes;

import datatransforobject.HomeHistoryDTO;
import express.Express;
import java.util.List;
import java.util.Optional;
import model.Home;
import model.HomeHistoryLog;
import service.HomeHistoryService;
import service.HomeService;

public class HomeHistoryRoutes {
    private final Express app;
    private final HomeHistoryService homeHistoryService;
    private final HomeService homeService;
    private final Home home;
    private final HomeHistoryLog homeHistoryLog;



    public HomeHistoryRoutes(Express app){
        this.app = app;
        this.homeHistoryService= new HomeHistoryService();
        this.homeService = new HomeService();
        this.home = new Home();
        this.homeHistoryLog = new HomeHistoryLog();
        this.init();
    }



    private void init(){
        app.get("rest/home/:id/history", (req, res) -> {
            String id = req.params("id");
            List<HomeHistoryLog> history = homeHistoryService.getByHomeId(id);
            res.json(history);
        });
    }

}
