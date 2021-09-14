import express.Express;

public class Main {

  public static void main(String[] args) {
    Express app = new Express();

    app.get("/", (req, res) -> {
      res.send("Hello World");
    });

    app.listen(4000); // Start server on port 4000
  }

}
