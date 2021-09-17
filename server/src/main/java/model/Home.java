package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Home")
@NamedQueries({
    @NamedQuery(name = "Home.findById", query = "SELECT h FROM Home WHERE h.id = :id"),
    @NamedQuery(name = "Home.findAll", query = "SELECT h FROM Home")
})

public class Home {

  @Id
  @GeneratedValue
  private int id;
  @Column(name = "host_id")
  @ManyToOne //MANY homes to ONE host
  private int hostId;
  @JsonManagedReference
  @Column(name = "address_id")
  @OneToOne(mappedBy = "home_id") //ONE address to ONE home
  private Address address;
  @Column(name = "price_per_night")
  private int pricePerNight;
  @Column(name = "start_date")
  private Timestamp startDate;
  @Column(name = "end_date")
  private Timestamp endDate;
  @Column(name = "updated_date")
  private Timestamp updatedDate;
  @Column(name = "created_date")
  private Timestamp createdDate;
  @OneToMany
  private List<BookingDetail> bookingDetails = new ArrayList<>();

  public Home(int hostId, Address address, int pricePerNight,
      Timestamp startDate, Timestamp endDate, List<BookingDetail> bookingDetails) {
    this.hostId = hostId;
    this.address = address;
    this.pricePerNight = pricePerNight;
    this.startDate = startDate;
    this.endDate = endDate;
    this.bookingDetails = bookingDetails;
  }

  public Home() {
  }

  @Override
  public String toString() {
    return "Home{" + "id=" + id + ", hostId=" + hostId + ", address=" + address + '\'' + ", "
        + "pricePerNight=" + pricePerNight + ", startDate='" + startDate + '\''
        + ", endDate='" + endDate + '\'' + ", updatedDate='" + updatedDate + '\''
        + ", createdDate='" + createdDate + '\'' + '}';
  }

  public int getHostId() {
    return hostId;
  }

  public void setHostId(int hostId) {
    this.hostId = hostId;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void setAddressId(Address address) {
    this.address = address;
  }

  public int getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(int pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;

  }

  public List<BookingDetail> getBookingDetails() {
    return bookingDetails;
  }

  public void setBookingDetails(List<BookingDetail> bookingDetails) {
    this.bookingDetails = bookingDetails;
  }

  public Timestamp getEndDate() {
    return endDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }

  public Timestamp getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Timestamp updatedDate) {
    this.updatedDate = updatedDate;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

}
