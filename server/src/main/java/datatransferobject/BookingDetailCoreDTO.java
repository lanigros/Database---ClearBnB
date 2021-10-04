package datatransferobject;

import java.sql.Timestamp;

public class BookingDetailCoreDTO {

  private int homeId;
  private int totalPrice;
  private Timestamp startDate;
  private Timestamp endDate;

  public BookingDetailCoreDTO() {
  }

  public BookingDetailCoreDTO(int homeId, int totalPrice, Timestamp startDate,
      Timestamp endDate) {
    this.homeId = homeId;
    this.totalPrice = totalPrice;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public int getHomeId() {
    return homeId;
  }

  public void setHomeId(int homeId) {
    this.homeId = homeId;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }

  public Timestamp getEndDate() {
    return endDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "BookingDetailCoreDTO{" +
        "homeId=" + homeId +
        ", totalPrice=" + totalPrice +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        '}';
  }
}
