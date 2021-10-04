package mapper;

import datatransferobject.ReviewBasicDTO;
import java.sql.Timestamp;
import java.time.Instant;
import model.BookingDetail;
import model.Review;
import model.User;

public class ReviewMapper {

  public static Review convertToReview(ReviewBasicDTO dto, User user, BookingDetail bookingDetail) {
    Review review = new Review();
    review.setComment(dto.getComment());
    review.setRating(dto.getRating());
    review.setBookingDetail(bookingDetail);
    review.setCreator(user);
    review.setCreated(new Timestamp(Instant.now().toEpochMilli()));
    return review;
  }

}
