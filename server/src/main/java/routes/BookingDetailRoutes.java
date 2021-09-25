package routes;

import datatransforobject.BookingDetailCoreDTO;
import express.Express;
import java.util.Optional;
import model.BookingDetail;
import service.BookingDetailService;
import service.HomeService;

public class BookingDetailRoutes {
  private final Express app;



  public BookingDetailRoutes(Express app) {
    this.app = app;

    this.init();
  }

  public void init(){
    app.post("/rest/booking-details", (req, res) -> {

    });

  }
}
