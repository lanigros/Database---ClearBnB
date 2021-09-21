package mapper;

import datatransforobject.ReviewBasicDTO;
import java.util.ArrayList;
import java.util.List;
import model.Review;

public class ReviewMapper {

  public static List<ReviewBasicDTO> convertToBasicDTO(List<Review> reviews) {
    List<ReviewBasicDTO> list = new ArrayList<>();
    reviews.forEach(review -> {
    ReviewBasicDTO dto = new ReviewBasicDTO();
    dto.setId(review.getId());
    dto.setComment(review.getComment());
    dto.setRating(review.getRating());
    dto.setCreated(review.getCreated());
    dto.setCreatorId(review.getCreatorId());
    list.add(dto);
    });

    return list;
  }

}
