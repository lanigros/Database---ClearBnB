package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "amenity_enum")
public class Amenity {

    public enum AMENITY_ENUM {
        WIFI, KITCHEN, PARKING, BATH
    }

    @Id
    @GeneratedValue
    private int id;
    @JsonBackReference(value = "home-amenity")
    @ManyToOne()
    @JoinColumn(name = "home_id")
    private Home home;

    @Column(name = "amenity")
    @Enumerated(EnumType.STRING)
    private AMENITY_ENUM AMENITY;

    public Amenity(int id, Home home, AMENITY_ENUM AMENITY) {
        this.id = id;
        this.home = home;
        this.AMENITY = AMENITY;
    }

    public Amenity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public AMENITY_ENUM getAmenity() {
        return AMENITY;
    }

    public void setAmenity(AMENITY_ENUM AMENITY) {
        this.AMENITY = AMENITY;
    }

    @Override
    public String toString() {
        return "Amenity{" + "id=" + id + ", amenity='" + AMENITY + '\'' + '}';
    }

}
