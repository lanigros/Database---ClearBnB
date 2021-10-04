package datatransferobject;

public class ReviewBasicDTO {

  private int bookingDetailId;
  private int rating;
  private String comment;

  public ReviewBasicDTO(int bookingDetailId, int rating, String comment) {
    this.bookingDetailId = bookingDetailId;
    this.rating = rating;
    this.comment = comment;
  }

  public ReviewBasicDTO() {
  }

  public int getBookingDetailId() {
    return bookingDetailId;
  }

  public void setBookingDetail(int bookingDetailId) {
    this.bookingDetailId = bookingDetailId;
  }

  @Override
  public String toString() {
    return "ReviewBasicDTO{" + ", rating=" + rating + ", comment='" + comment
        + ", bookingDetailId='" + bookingDetailId + "}";
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}
