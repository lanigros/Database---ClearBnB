package datatransforobject;

import java.sql.Timestamp;
import java.util.List;

public class HomeAddressDTO {

  private String city;
  private String street;
  private String zipCode;
  private String country;
  private int pricePerNight;
  private Timestamp startDate;
  private Timestamp endDate;
  private List<String> amenities;

  public HomeAddressDTO() {
  }

  public HomeAddressDTO(String city, String street, String zipCode, String country,
      int pricePerNight, Timestamp startDate, Timestamp endDate, List<String> amenities) {
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
    this.country = country;
    this.pricePerNight = pricePerNight;
    this.startDate = startDate;
    this.endDate = endDate;
    this.amenities = amenities;
  }

  @Override
  public String toString() {
    return "HomeAddressDTO{" + "city='" + city + '\'' + ", street='" + street + '\'' + ", zipCode='"
        + zipCode + '\'' + ", country='" + country + '\'' + ", pricePerNight=" + pricePerNight
        + ", startDate=" + startDate + ", endDate=" + endDate + ", amenities=" + amenities + '}';
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

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
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

  public List<String> getAmenities() {
    return amenities;
  }

  public void setAmenities(List<String> amenities) {
    this.amenities = amenities;
  }
}
