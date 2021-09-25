package datatransforobject;

public class ReviewBasicDTO {

  private int bookingDetail;
  private int rating;
  private String comment;
  private int creatorId;

  public ReviewBasicDTO(int bookingDetail, int rating, String comment, int creatorId) {
    this.bookingDetail = bookingDetail;
    this.rating = rating;
    this.comment = comment;
    this.creatorId = creatorId;
  }

  public ReviewBasicDTO() {
  }

  public int getbookingDetail() {
    return bookingDetail;
  }

  public void setbookingDetail(int bookingDetail) {
    this.bookingDetail = bookingDetail;
  }

  @Override
  public String toString() {
    return "ReviewBasicDTO{" + ", rating=" + rating + ", comment='" + comment + '\'' + ", creatorId=" + creatorId + '}';
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

  public int getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(int creatorId) {
    this.creatorId = creatorId;
  }

}
