package datatransforobject;

import java.sql.Timestamp;
import java.util.List;
import model.Address;
import model.Amenity;
import model.HomeImage;

public class HomeCoreNoHostDTO {

  private int id;
  private Address address;
  private List<HomeImage> images;
  private int pricePerNight;
  private Timestamp startDate;
  private Timestamp endDate;
  private Timestamp createdDate;
  private List<Amenity> amenities;

  public HomeCoreNoHostDTO() {
  }

  public HomeCoreNoHostDTO(int id, Address address, List<HomeImage> images, int pricePerNight,
      Timestamp startDate, Timestamp endDate, Timestamp createdDate,
      List<Amenity> amenities) {
    this.id = id;
    this.address = address;
    this.images = images;
    this.pricePerNight = pricePerNight;
    this.startDate = startDate;
    this.endDate = endDate;
    this.createdDate = createdDate;
    this.amenities = amenities;
  }

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

  public List<HomeImage> getImages() {
    return images;
  }

  public void setImages(List<HomeImage> images) {
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

  public List<Amenity> getAmenities() {
    return amenities;
  }

  public void setAmenities(List<Amenity> amenities) {
    this.amenities = amenities;
  }
}


