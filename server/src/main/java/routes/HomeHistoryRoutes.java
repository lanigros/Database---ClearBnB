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
    }

    }


