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

@Entity
@Table(name = "booking_detail")
@NamedQueries({
    @NamedQuery(name = "BookingDetail.findById", query = "SELECT b FROM BookingDetail b WHERE b.id = :id"),
    @NamedQuery(name = "BookingDetail.findAll", query = "SELECT b FROM BookingDetail b"),
    @NamedQuery(name="BookingDetail.checkIfAvailable", query="SELECT b FROM BookingDetail b"
        + " WHERE ((:startDate BETWEEN b.startDate AND b.endDate) AND (:startDate != b.endDate))"
        + " OR ((:endDate != b.startDate) AND (:endDate BETWEEN b.startDate AND b.endDate))"
        + " OR ((b.startDate != :endDate) AND (b.startDate BETWEEN :startDate AND :endDate))"
        + " OR ((b.endDate != :startDate) AND (b.endDate BETWEEN :startDate AND :endDate))"
        + " AND b.home = :home")
})
public class BookingDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @JsonBackReference(value = "renter-booking-details")
  @ManyToOne
  private Renter renter;
  @ManyToOne
  @JsonBackReference(value = "home-booking-details")
  private Home home;
  @Column(name = "total_price")
  private int totalPrice;
  @Column(name = "start_date")
  private Timestamp startDate;
  @Column(name = "end_date")
  private Timestamp endDate;
  @Column(name = "created_date")
  private Timestamp createdDate;

  public BookingDetail() {

  }

  public BookingDetail(Home home, int totalPrice, Timestamp startDate, Timestamp endDate,
      Timestamp createdDate, Renter renter) {
    this.home = home;
    this.totalPrice = totalPrice;
    this.startDate = startDate;
    this.endDate = endDate;
    this.createdDate = createdDate;
    this.renter = renter;

  }

  @Override
  public String toString() {
    return "BookingDetail{" + "id=" + id + ",totalPrice=" + totalPrice + ", startDate=" + startDate
        + ", endDate=" + endDate + ", createdDate=" + createdDate + "}";
  }

  public int getId() {
    return id;
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

}
