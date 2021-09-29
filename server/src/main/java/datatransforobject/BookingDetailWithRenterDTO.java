package datatransforobject;

import java.sql.Timestamp;

public class BookingDetailWithRenterDTO extends BookingDetailCoreDTO{
  private int renterUserId;
  private int id;

  public BookingDetailWithRenterDTO(int homeId, int totalPrice, Timestamp startDate,
      Timestamp endDate, int renterId, int id) {
    super(homeId, totalPrice, startDate, endDate);
    this.renterUserId = renterId;
    this.id = id;
  }

  @Override
  public String toString() {
    return "BookingDetailWithRenterDTO{" +
        "renterUserId=" + renterUserId +
        '}';
  }

  public int getRenterUserId() {
    return renterUserId;
  }

  public void setRenterUserId(int renterUserId) {
    this.renterUserId = renterUserId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
