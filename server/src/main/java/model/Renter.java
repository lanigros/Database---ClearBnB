package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Renter")
@NamedQueries({
    @NamedQuery(name = "Renter.findByUserId", query = "SELECT r FROM Renter r WHERE r.user = (SELECT u FROM User u WHERE u.id=:userId)")
})

public class Renter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @OneToOne(cascade = CascadeType.MERGE)
  @JsonBackReference(value = "user-renter")
  private User user;
  @JsonManagedReference(value = "renter-booking-details")
  @OneToMany(mappedBy = "renter")
  private List<BookingDetail> bookingDetails = new ArrayList<>();
  @OneToMany(cascade = CascadeType.MERGE)
  @JoinTable(
      name = "renter_review",
      joinColumns = @JoinColumn(name = "renter_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "review_id", referencedColumnName = "id")
  )
  @Where(clause = "is_deleted = 0")
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
