package model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Filter(name = "dateFilter", condition = "start_date <= :start_date and end_date >= :end_date")
@Filter(name = "priceFilter", condition = "pricePerNight <= :pricePerNight")
@Filter(name = "countryFilter", condition = "country = :country")
@NamedQueries({
    @NamedQuery(name = "HomeView.TEST", query = "SELECT h FROM HomeView h")})
public class HomeView {

  @Id
  @GeneratedValue
  private int id;
  private String country;
  private String city;
  private String street;
  private int pricePerNight;

  private Timestamp startDate;
  private Timestamp endDate;


  public HomeView() {
  }

  @Override
  public String toString() {
    return "HomeView{" + "id=" + id + ", country='" + country + '\'' + ", city='" + city + '\''
        + ", street='" + street + '\'' + ", pricePerNight=" + pricePerNight + ", startDate="
        + startDate + ", endDate=" + endDate + '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
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

  public Timestamp getEndDate() {
    return endDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }
}
