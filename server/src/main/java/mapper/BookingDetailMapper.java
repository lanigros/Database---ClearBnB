package mapper;

import datatransforobject.BookingDetailCoreDTO;
import java.sql.Timestamp;
import java.time.Instant;
import model.BookingDetail;
import model.Home;
import model.Renter;

public class BookingDetailMapper {

  public static BookingDetail convertToBookingDetail(BookingDetailCoreDTO bookingDetailCoreDTO, Renter renter, Home home){
    BookingDetail bookingDetail = new BookingDetail();
    bookingDetail.setCreatedDate(new Timestamp(Instant.now().toEpochMilli()));
    bookingDetail.setStartDate(bookingDetailCoreDTO.getStartDate());
    bookingDetail.setEndDate(bookingDetailCoreDTO.getEndDate());
    bookingDetail.setRenter(renter);
    bookingDetail.setTotalPrice(bookingDetailCoreDTO.getTotalPrice());
    bookingDetail.setHome(home);
    return bookingDetail;
  }

}
