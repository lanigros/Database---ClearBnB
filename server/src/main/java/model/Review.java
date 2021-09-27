package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//import org.eclipse.jetty.server.Authentication.User;

@Entity
@Table(name = "review")
@NamedQueries({
    @NamedQuery(name = "Review.findById", query = "SELECT r FROM Review r WHERE r.id = :id"),
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r")})
public class Review {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int rating;
  private String comment;
  @Column(name = "created_date")
  private Timestamp created;
  @Column(name = "is_deleted")
  private boolean isDeleted;
  @ManyToOne
  @JoinColumn(name = "booking_id")
  private BookingDetail bookingDetail;
  @Column(name = "creator_id", insertable = false, updatable = false)
  private int creatorId;
  @ManyToOne
  @JsonBackReference(value = "user-review")
  @JoinColumn(name = "creator_id")
  private User creator;

  public Review() {
  }

  public Review(int rating, String comment, Timestamp created, boolean isDeleted,
      BookingDetail bookingDetail, int creatorId) {
    this.rating = rating;
    this.comment = comment;
    this.created = created;
    this.isDeleted = isDeleted;
    this.bookingDetail = bookingDetail;
    this.creatorId = creatorId;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }

  public int getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(int creatorId) {
    this.creatorId = creatorId;
  }

  @Override
  public String toString() {
    return "Review{" + "rating=" + rating + ", comment='" + comment + '\'' + ", created=" + created
        + ", isDeleted=" + isDeleted + +'}';
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

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean deleted) {
    isDeleted = deleted;
  }

  public BookingDetail getBookingDetail() {
    return bookingDetail;
  }

  public void setBookingDetail(BookingDetail bookingDetail) {
    this.bookingDetail = bookingDetail;
  }

  public int getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(int creatorId) {
    this.creatorId = creatorId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
