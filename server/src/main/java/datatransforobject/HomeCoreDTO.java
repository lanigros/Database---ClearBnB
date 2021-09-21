package datatransforobject;

import java.sql.Timestamp;
import java.util.List;
import model.Address;
import model.HomeImage;
import model.Host;

public class HomeCoreDTO {

  private int id;
  private Host host;
  private Address address;
  private List<HomeImage> images;
  private int pricePerNight;
  private Timestamp startDate;
  private Timestamp endDate;
  private Timestamp createdDate;


  public HomeCoreDTO(int id, Host host, Address address, List<HomeImage> images, int pricePerNight,
      Timestamp startDate, Timestamp endDate, Timestamp createdDate) {
    this.id = id;
    this.host = host;
    this.address = address;
    this.images = images;
    this.pricePerNight = pricePerNight;
    this.startDate = startDate;
    this.endDate = endDate;
    this.createdDate = createdDate;
  }

  public HomeCoreDTO() {
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Host getHost() {
    return host;
  }

  public void setHost(Host host) {
    this.host = host;
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

  @Override
  public String toString() {
    return "HomeCoreDTO{" + "id=" + id + ", host=" + host + ", address=" + address + ", images="
        + images + ", pricePerNight=" + pricePerNight + ", startDate=" + startDate + ", endDate="
        + endDate + ", createdDate=" + createdDate + '}';
  }
}
