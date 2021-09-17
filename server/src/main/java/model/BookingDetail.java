package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking_detail")
@NamedQueries({
    @NamedQuery(name = "BookingDetail.findById", query = "SELECT b FROM BookingDetail b WHERE b.id = :id"),
    @NamedQuery(name = "BookingDetail.findAll", query = "SELECT b FROM BookingDetail b")
})
public class BookingDetail {

  @Id
  @GeneratedValue
  private int id;
  @OneToOne
  private Renter renter;
  @ManyToOne
  private Home home;
  @Column(name = "total_price")
  private int totalPrice;
  @Column(name = "start_date")
  private Timestamp startDate;
  @Column(name = "end_date")
  private Timestamp endDate;
  @Column(name = "created_date")
  private Timestamp createdDate;
  @OneToMany
  private List<Review> reviews = new ArrayList<>();

  public BookingDetail() {

  }

  public BookingDetail(Home home, int totalPrice, Timestamp startDate,
      Timestamp endDate, Timestamp createdDate, List<Review> reviews, Renter renter) {
    this.home = home;
    this.totalPrice = totalPrice;
    this.startDate = startDate;
    this.endDate = endDate;
    this.createdDate = createdDate;
    this.reviews = reviews;
    this.renter = renter;
  }

  @Override
  public String toString() {
    return "BookingDetail{" + "id=" + id + ", home=" + home + ", totalPrice=" + totalPrice +
        ", startDate=" + startDate + ", endDate=" + endDate + ", createdDate=" + createdDate +
        "reviews=" + reviews + "}";
  }

  public Home getHome() {
    return home;
  }

  public void setHome(Home home) {
    this.home = home;
  }

  public Renter getRenter() {
    return renter;
  }

  public void setRenter(Renter renter) {
    this.renter = renter;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }

  public Timestamp getEndDate() {
    return endDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }
}
