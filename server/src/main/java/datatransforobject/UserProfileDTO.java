package datatransforobject;

import java.util.List;
import model.Review;

public class UserProfileDTO {

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private int avgRatingHost;
  private int avgRatingRenter;
  private List<Review> hostReview;
  private List<Review> renterReview;
  private List<HomeCoreNoHostDTO> homes;

  public UserProfileDTO() {

  }

  @Override
  public String toString() {
    return "UserProfileDTO{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='"
        + lastName + '\'' + ", email='" + email + '\'' + ", avgRatingHost=" + avgRatingHost
        + ", avgRatingRenter=" + avgRatingRenter + ", homes=" + homes + '}';
  }

  public List<Review> getHostReview() {
    return hostReview;
  }

  public void setHostReview(List<Review> hostReview) {
    this.hostReview = hostReview;
  }

  public List<Review> getRenterReview() {
    return renterReview;
  }

  public void setRenterReview(List<Review> renterReview) {
    this.renterReview = renterReview;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAvgRatingHost() {
    return avgRatingHost;
  }

  public void setAvgRatingHost(int avgRatingHost) {
    this.avgRatingHost = avgRatingHost;
  }

  public void setAvgRatingHostFromList(List<Review> reviews) {

    float tempTotal = 0;
    for (Review re : reviews) {
      tempTotal += re.getRating();
    }
    float tempAvg = tempTotal / reviews.size();
    this.avgRatingHost = (int) Math.floor(tempAvg);

  }

  public int getAvgRatingRenter() {
    return avgRatingRenter;
  }

  public void setAvgRatingRenter(int avgRatingRenter) {
    this.avgRatingRenter = avgRatingRenter;
  }

  public void setAvgRatingRenterFromList(List<Review> reviews) {
    float tempTotal = 0;
    for (Review re : reviews) {
      tempTotal += re.getRating();
    }
    float tempAvg = tempTotal / reviews.size();
    this.avgRatingRenter = (int) Math.floor(tempAvg);
  }

  public List<HomeCoreNoHostDTO> getHomes() {
    return homes;
  }

  public void setHomes(List<HomeCoreNoHostDTO> homes) {
    this.homes = homes;
  }
}


