package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Renter")

public class Renter {

  @Id
  @GeneratedValue
  private int id;
  @OneToOne
  @JsonBackReference(value = "user-renter")
  private User user;
  @JsonManagedReference(value = "renter-booking-details")
  @OneToMany(mappedBy = "renter")
  private List<BookingDetail> bookingDetails = new ArrayList<>();
  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "renter_review", joinColumns = @JoinColumn(name = "renter_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "review_id", referencedColumnName = "id"))
  private List<Review> reviews = new ArrayList<>();

  public Renter() {
  }

  public Renter(int id, User user, List<Review> reviews, List<BookingDetail> bookingDetails) {
    this.id = id;
    this.user = user;
    this.reviews = reviews;
    this.bookingDetails = bookingDetails;
  }


  @Override
  public String toString() {
    return "Renter{" + "id=" + id + "}";
  }

  public int getId() {
    return id;
  }

  public List<BookingDetail> getBookingDetails() {
    return bookingDetails;
  }

  public void setBookingDetails(List<BookingDetail> bookingDetails) {
    this.bookingDetails = bookingDetails;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


}
