package model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Home")
@NamedQueries({@NamedQuery(name = "Home.findById", query = "SELECT h FROM Home h WHERE h.id = " + ":id"), @NamedQuery(name = "Home.findAll", query = "SELECT h FROM Home h")})
public class Home {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "host_id")//MANY homes to ONE host
    private Host host;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "img_url")
    private String imgUrl;

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

    public Home(Host host, Address address, String imgUrl, int pricePerNight, Timestamp startDate,
            Timestamp endDate) {
        this.host = host;
        this.address = address;
        this.imgUrl = imgUrl;
        this.pricePerNight = pricePerNight;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Home() {
    }

    @Override
    public String toString() {
        return "Home{" + "id=" + id + ", host=" + host + ", addressId=" + address + ", imgUrl='" + imgUrl + '\'' + ", pricePerNight=" + pricePerNight + ", startDate='" + startDate + '\'' + ", endDate='" + endDate + '\'' + ", updatedDate='" + updatedDate + '\'' + ", createdDate='" + createdDate + '\'' + '}';
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
