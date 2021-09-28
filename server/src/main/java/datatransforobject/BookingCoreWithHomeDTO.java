package datatransforobject;

import java.sql.Timestamp;
import model.Home;

public class BookingCoreWithHomeDTO extends BookingDetailCoreDTO{
  private int id;
  private HomeCoreDTO home;

  public BookingCoreWithHomeDTO() {
  }

  public BookingCoreWithHomeDTO(int id, int totalPrice, Timestamp startDate,
      Timestamp endDate, HomeCoreDTO home) {
    super(home.getId(), totalPrice, startDate, endDate);
    this.id = id;
    this.home = home;
  }

  public HomeCoreDTO getHome() {
    return home;
  }

  public void setHome(HomeCoreDTO home) {
    this.home = home;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
