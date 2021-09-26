package datatransforobject;

import java.sql.Timestamp;
import java.util.List;
import model.Address;
import model.Amenity;
import model.BookingDetail;
import model.HomeImage;

public class HomeCoreWithBooking extends HomeCoreNoHostDTO{
  private List<BookingDetail>bookingDetails;

  public HomeCoreWithBooking(Address address, List<HomeImage> images,
      int pricePerNight, Timestamp startDate, Timestamp endDate,
      Timestamp createdDate, List<Amenity> amenities,
      List<BookingDetail> bookingDetails) {
    super(address, images, pricePerNight, startDate, endDate, createdDate, amenities);
    this.bookingDetails = bookingDetails;
  }

  public List<BookingDetail> getBookingDetails() {
    return bookingDetails;
  }

  public void setBookingDetails(List<BookingDetail> bookingDetails) {
    this.bookingDetails = bookingDetails;
  }
}
