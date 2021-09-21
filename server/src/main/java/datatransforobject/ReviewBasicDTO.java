package datatransforobject;

import java.sql.Timestamp;

public class ReviewBasicDTO {

  private int id;
  private int rating;
  private String comment;
  private Timestamp created;

  private int creatorId;

  public ReviewBasicDTO() {
  }

  public ReviewBasicDTO(int id, int rating, String comment, Timestamp created, int creatorId) {
    this.id = id;
    this.rating = rating;
    this.comment = comment;
    this.created = created;

    this.creatorId = creatorId;
  }

  @Override
  public String toString() {
    return "ReviewBasicDTO{" + "id=" + id + ", rating=" + rating + ", comment='" + comment + '\''
        + ", created=" + created + ", creatorId=" + creatorId + '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Timestamp getCreated() {
    return created;
  }

  public void setCreated(Timestamp created) {
    this.created = created;
  }


  public int getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(int creatorId) {
    this.creatorId = creatorId;
  }
}
