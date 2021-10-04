package mapper;

import datatransferobject.BookingCoreWithHomeDTO;
import datatransferobject.BookingDetailCoreDTO;
import datatransferobject.BookingDetailWithRenterDTO;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import model.BookingDetail;
import model.Home;
import model.Renter;

public class BookingDetailMapper {

  public static BookingDetail convertToBookingDetail(BookingDetailCoreDTO dto, Renter renter,
      Home home) {
    return new BookingDetail(
        home,
        dto.getTotalPrice(),
        dto.getStartDate(),
        dto.getEndDate(),
        new Timestamp(Instant.now().toEpochMilli()),
        renter
    );
  }

  public static List<BookingCoreWithHomeDTO> convertToBookingCoreHomeDTO(
      List<BookingDetail> bookingDetails) {
    List<BookingCoreWithHomeDTO> bookingHomeDTOs = new ArrayList<>();
    for (BookingDetail bookingDetail : bookingDetails) {
      BookingCoreWithHomeDTO bookingCoreWithHomeDTO = new BookingCoreWithHomeDTO(
          bookingDetail.getId(),
          bookingDetail.getTotalPrice(),
          bookingDetail.getStartDate(),
          bookingDetail.getEndDate(),
          HomeMapper.convertToCore(bookingDetail.getHome()
          ));
      bookingHomeDTOs.add(bookingCoreWithHomeDTO);
    }
    return bookingHomeDTOs;
  }

  public static List<BookingDetailWithRenterDTO> convertToBookingWithRenterDTO(
      List<BookingDetail> bookingDetails) {
    List<BookingDetailWithRenterDTO> bookingRenterDTOs = new ArrayList<>();
    for (BookingDetail bookingDetail : bookingDetails) {
      BookingDetailWithRenterDTO bookingCoreWithRenterDTO = new BookingDetailWithRenterDTO(
          bookingDetail.getHome().getId(),
          bookingDetail.getTotalPrice(),
          bookingDetail.getStartDate(),
          bookingDetail.getEndDate(),
          bookingDetail.getRenter().getUser().getId(),
          bookingDetail.getId()
      );
      bookingRenterDTOs.add(bookingCoreWithRenterDTO);
    }
    return bookingRenterDTOs;
  }

}
