package mapper;

import datatransforobject.BookingCoreWithHomeDTO;
import datatransforobject.BookingDetailCoreDTO;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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

  public static List<BookingCoreWithHomeDTO> convertToBookingCoreHomeDTO(List<BookingDetail> bookingDetails){
    List<BookingCoreWithHomeDTO>bookingHomeDTOs = new ArrayList<>();
    for(BookingDetail bookingDetail : bookingDetails){
      BookingCoreWithHomeDTO bookingCoreWithHomeDTO = new BookingCoreWithHomeDTO();
      bookingCoreWithHomeDTO.setHome(bookingDetail.getHome());
      bookingCoreWithHomeDTO.setEndDate(bookingDetail.getEndDate());
      bookingCoreWithHomeDTO.setStartDate(bookingDetail.getStartDate());
      bookingCoreWithHomeDTO.setTotalPrice(bookingDetail.getTotalPrice());
      bookingHomeDTOs.add(bookingCoreWithHomeDTO);
    }
   return bookingHomeDTOs;
  }

}
