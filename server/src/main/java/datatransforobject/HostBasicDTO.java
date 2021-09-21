package datatransforobject;

import java.util.List;
import model.Review;

public class HostBasicDTO {

  private int userID;
  private String fullName;
  private int averageRating;

  public HostBasicDTO() {
  }

  public HostBasicDTO(String fullName, int userId) {

    this.userID = userId;
    this.fullName = fullName;

  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  @Override
  public String toString() {
    return "HostBasicDTO{" + "fullName='" + fullName + '\'' + ", reviews=" + ", averageRating="
        + averageRating + '}';
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String firstName, String lastName) {
    this.fullName = firstName + " " + lastName;
  }

  public int getAverageRating() {
    return averageRating;
  }

  public void setAvgRating(List<Review> reviews) {
    float tempTotal = 0;
    for (Review re : reviews) {
      tempTotal += re.getRating();
    }
    float tempAvg = tempTotal / reviews.size();
    this.averageRating = (int) Math.floor(tempAvg);
    System.out.println("Snitt " + averageRating);
  }
}
