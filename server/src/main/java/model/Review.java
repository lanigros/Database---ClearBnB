package model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.eclipse.jetty.server.Authentication.User;

@Entity
@Table(name = "review")
@NamedQueries({
    @NamedQuery(name = "Review.findById", query = "SELECT r FROM Review r WHERE r.id = :id"),
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r")})
public class Review {

  @Id
  @GeneratedValue
  private int rating;
  private String comment;
  @Column(name = "created_date")
  private Timestamp created;
  @Column(name = "is_deleted")
  private boolean isDeleted;
  @OneToOne
  @JoinColumn(name = "booking_id")
  private BookingId bookingId;
  @OneToOne
  @JoinColumn(name = "creator_id")
  private User creator;


  public Review(int rating, String comment, Timestamp created, boolean isDeleted,
      BookingId bookingId, User creator) {
    this.rating = rating;
    this.comment = comment;
    this.created = created;
    this.isDeleted = isDeleted;
    this.bookingId = bookingId;
    this.creator = creator;
  }

  @Override
  public String toString() {
    return "Review{" + "rating=" + rating + ", comment='" + comment + '\'' + ", created=" + created
        + ", isDeleted=" + isDeleted + ", bookingId=" + bookingId + ", creator=" + creator + '}';
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

  public BookingId getBookingId() {
    return bookingId;
  }

  public void setBookingId(BookingId bookingId) {
    this.bookingId = bookingId;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }
}
