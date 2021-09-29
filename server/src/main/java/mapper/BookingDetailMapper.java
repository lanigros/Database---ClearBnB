package mapper;

import datatransforobject.BookingCoreWithHomeDTO;
import datatransforobject.BookingDetailCoreDTO;
import datatransforobject.BookingDetailWithRenterDTO;
import datatransforobject.HomeCoreDTO;
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

  public static List<BookingDetailWithRenterDTO> convertToBookingWithRenterDTO(List<BookingDetail> bookingDetails){
    List<BookingDetailWithRenterDTO>bookingRenterDTOs = new ArrayList<>();
    for(BookingDetail bookingDetail : bookingDetails){
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
