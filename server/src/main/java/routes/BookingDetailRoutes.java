package routes;

import datatransforobject.BookingDetailCoreDTO;
import express.Express;
import java.util.Optional;
import model.BookingDetail;
import service.BookingDetailService;
import service.HomeService;

public class BookingDetailRoutes {
  private final Express app;
  private final BookingDetailService bookingDetailService;


  public BookingDetailRoutes(Express app) {
    this.app = app;
    this.bookingDetailService = new BookingDetailService();
    this.init();
  }

  public void init(){
    app.post("/rest/booking-details", (req, res) -> {
      String sessionID = req.cookie("sessionID");
      BookingDetailCoreDTO bookingDetailCoreDTO = req.body(BookingDetailCoreDTO.class);
      Optional<BookingDetail>bookingDetail = bookingDetailService.createHome(sessionID, bookingDetailCoreDTO);
    });

  }
}
