package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import model.Amenity.AmenityEnum;
import utility.AmenityEnumConverter;

@Entity
@Table(name = "amenity_enum_history_log")
public class AmenityHistory {

    @Id
    @GeneratedValue
    private int id;

    @JsonBackReference(value = "home-history-amenities")
    @ManyToOne
    @JoinColumn(name = "home_history_log_id")
    private HomeHistoryLog homeHistoryLog;

    @Column(name = "amenity")
    @Convert(converter = AmenityEnumConverter.class)
    private AmenityEnum amenityEnum;

    public AmenityHistory(int id, HomeHistoryLog homeHistoryLog, AmenityEnum amenityEnum) {
        this.id = id;
        this.homeHistoryLog = homeHistoryLog;
        this.amenityEnum = amenityEnum;
    }

    public AmenityHistory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HomeHistoryLog getHomeHistoryLog() {
        return homeHistoryLog;
    }

    public void setHomeHistoryLogId(HomeHistoryLog homeHistoryLog) {
        this.homeHistoryLog = homeHistoryLog;
    }

    public AmenityEnum getAmenityEnum() {
        return amenityEnum;
    }

    public void setAmenityEnum(AmenityEnum amenityEnum) {
        this.amenityEnum = amenityEnum;
    }

    @Override
    public String toString() {
        return "AmenityHistory{" + "id=" + id + ", amenityEnum=" + amenityEnum + '}';
    }

}


