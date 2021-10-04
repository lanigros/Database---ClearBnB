package datatransferobject;

import java.sql.Timestamp;
import java.util.List;
import model.Address;
import model.AmenityHistory;
import model.HomeImageHistory;

public class HomeHistoryDTO {

  private int id;
  private Address address;
  private List<HomeImageHistory> images;
  private int pricePerNight;
  private Timestamp startDate;
  private Timestamp endDate;
  private Timestamp createdDate;
  private List<AmenityHistory> amenities;

  public HomeHistoryDTO(int id, Address address, List<HomeImageHistory> images, int pricePerNight,
      Timestamp startDate, Timestamp endDate, Timestamp createdDate) {
    this.id = id;
    this.address = address;
    this.images = images;
    this.pricePerNight = pricePerNight;
    this.startDate = startDate;
    this.endDate = endDate;
    this.createdDate = createdDate;
  }

  public HomeHistoryDTO() {
  }

  @Override
  public String toString() {
    return "HomeHistoryDTO{" + "id=" + id + ", address=" + address + ", images=" + images
        + ", pricePerNight=" + pricePerNight + ", startDate=" + startDate + ", endDate=" + endDate
        + ", createdDate=" + createdDate + '}';
  }

  ;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<HomeImageHistory> getImages() {
    return images;
  }

  public void setImages(List<HomeImageHistory> images) {
    this.images = images;
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

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public List<AmenityHistory> getAmenities() {
    return amenities;
  }

  public void setAmenities(List<AmenityHistory> amenities) {
    this.amenities = amenities;
  }

}
