package model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Home_History_log")
public class HomeHistoryLog {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne //MANY historylogs to ONE house
    private Home homeId;

    @Column(name = "price_per_night")
    private int pricePerNight;
    @Column(name = "start_date")
    private Timestamp startDate;
    @Column(name = "end_date")
    private Timestamp endDate;
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "img_url")
    private String imgUrl;

    public HomeHistoryLog(int id, Home homeId, int pricePerNight, Timestamp startDate,
            Timestamp endDate, String imgUrl) {
        this.id = id;
        this.homeId = homeId;
        this.pricePerNight = pricePerNight;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imgUrl = imgUrl;
    }

    public HomeHistoryLog() {
    }

    @Override
    public String toString() {
        return "HomeHistoryLog{" + "id=" + id + ", homeId=" + homeId + ", pricePerNight=" + pricePerNight + ", startDate=" + startDate + ", endDate=" + endDate + ", createdDate=" + createdDate + ", imgUrl='" + imgUrl + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Home getHomeId() {
        return homeId;
    }

    public void setHomeId(Home homeId) {
        this.homeId = homeId;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
