import express.Express;
import routes.FunctionRoutes;
import routes.HomeRoutes;
import routes.UserRoutes;
import socket.Socket;

public class Main {

    public static void main(String[] args) {
        Express app = new Express();
        new UserRoutes(app);
        new FunctionRoutes(app);
        new HomeRoutes(app);
        new Socket(app);
        app.listen(4000);
    }

}
