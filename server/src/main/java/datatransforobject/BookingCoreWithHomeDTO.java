package datatransforobject;

import java.sql.Timestamp;
import model.Home;

public class BookingCoreWithHomeDTO extends BookingDetailCoreDTO{
  private Home home;

  public BookingCoreWithHomeDTO() {
  }

  public BookingCoreWithHomeDTO(int homeId, int totalPrice, Timestamp startDate,
      Timestamp endDate, Home home) {
    super(homeId, totalPrice, startDate, endDate);
    this.home = home;
  }

  public Home getHome() {
    return home;
  }

  public void setHome(Home home) {
    this.home = home;
  }
}
