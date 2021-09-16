package model;

import javax.persistence.*;

@Entity
@Table(name="Home")
@NamedQueries({
        @NamedQuery(name = "Home.findById", query="SELECT h FROM Home WHERE h.id = :id"),
        @NamedQuery(name = "Home.findAll", query="SELECT h FROM Home")
})

public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "host_id")
    @ManyToOne //MANY homes to ONE host
    private int hostId;

    @Column(name = "address_id")
    @OneToOne(mappedBy = "") //ONE address to ONE home
    private int addressId;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "price_per_night")
    private int pricePerNight;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "updated_date")
    private String updatedDate;

    @Column(name = "created_date")
    private String createdDate;

    public Home(){
    }

    @Override
    public String toString() {
        return "Home{" + "id=" + id + ", hostId=" + hostId + ", addressId=" + addressId + ", imgUrl='" + imgUrl + '\'' + ", pricePerNight=" + pricePerNight + ", startDate='" + startDate + '\'' + ", endDate='" + endDate + '\'' + ", updatedDate='" + updatedDate + '\'' + ", createdDate='" + createdDate + '\'' + '}';
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }



}
