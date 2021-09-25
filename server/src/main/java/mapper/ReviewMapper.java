package mapper;

import datatransforobject.ReviewBasicDTO;
import java.util.ArrayList;
import java.util.List;
import model.BookingDetail;
import model.Host;
import model.Review;

public class ReviewMapper {

  public static List<ReviewBasicDTO> convertToBasicDTO(List<Review> reviews) {
    List<ReviewBasicDTO> list = new ArrayList<>();
    reviews.forEach(review -> {
      ReviewBasicDTO dto = new ReviewBasicDTO();
      dto.setComment(review.getComment());
      dto.setRating(review.getRating());
      dto.setCreatorId(review.getCreatorId());
      list.add(dto);
    });
    return list;
  }

  public static Review convertToReview(ReviewBasicDTO dto, int userID, BookingDetail bookingDetail,
      Host host) {
    Review review = new Review();
    review.setComment(dto.getComment());
    review.setRating(dto.getRating());
    review.setBookingDetail(bookingDetail);
    review.setCreatorId(userID);
    review.setHost(host);
    return review;
  }

}
