package datatransferobject;

import java.sql.Timestamp;
import java.util.List;
import model.Address;
import model.Amenity;
import model.HomeImage;

public class HomeCoreWithBooking extends HomeCoreNoHostDTO {

  private List<BookingDetailWithRenterDTO> bookingDetails;

  public HomeCoreWithBooking(int id, Address address, List<HomeImage> images,
      int pricePerNight, Timestamp startDate, Timestamp endDate,
      Timestamp createdDate, List<Amenity> amenities,
      List<BookingDetailWithRenterDTO> bookingDetails) {
    super(id, address, images, pricePerNight, startDate, endDate, createdDate, amenities);
    this.bookingDetails = bookingDetails;
  }

  @Override
  public String toString() {
    return "HomeCoreWithBooking{" +
        "bookingDetails=" + bookingDetails +
        '}';
  }

  public List<BookingDetailWithRenterDTO> getBookingDetails() {
    return bookingDetails;
  }

  public void setBookingDetails(List<BookingDetailWithRenterDTO> bookingDetails) {
    this.bookingDetails = bookingDetails;
  }
}
