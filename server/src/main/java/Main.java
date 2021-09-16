import express.Express;
import routes.UserRoutes;

public class Main {

  public static void main(String[] args) {

    Express app = new Express();
    new UserRoutes(app);

    app.listen(4000);

  }

}
