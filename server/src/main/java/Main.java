import express.Express;
import routes.FunctionRoutes;
import routes.HomeHistoryRoutes;
import routes.HomeRoutes;
import routes.UserRoutes;

public class Main {

    public static void main(String[] args) {
        Express app = new Express();
        new UserRoutes(app);
        new FunctionRoutes(app);
        new HomeRoutes(app);
        new HomeHistoryRoutes(app);
        app.listen(4000);
    }

}
