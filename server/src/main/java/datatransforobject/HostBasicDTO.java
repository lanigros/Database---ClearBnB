package datatransforobject;

import java.util.List;
import model.Review;

public class HostBasicDTO {

  private int userID;
  private String fullName;
  private List<Review> reviews;
  private int averageRating;

  public HostBasicDTO() {
  }

  public HostBasicDTO(String fullName, List<Review> reviews, int averageRating) {
    this.fullName = fullName;
    this.reviews = reviews;
    this.averageRating = averageRating;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  @Override
  public String toString() {
    return "HostBasicDTO{" + "fullName='" + fullName + '\'' + ", reviews=" + reviews
        + ", averageRating=" + averageRating + '}';
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String firstName, String lastName) {
    this.fullName = firstName + " " + lastName;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
    float tempTotal = 0;
    for (Review re : reviews) {
      tempTotal += re.getRating();
    }
    float tempAvg = tempTotal / reviews.size();
    this.averageRating = (int) Math.floor(tempAvg);
  }
}
