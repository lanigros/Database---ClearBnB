//package model;
//
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "amenity_enum")
//public class Amenity {
//
//    public enum amenity {
//        wifi, kitchen, parking, bath
//    }
//    @Id
//    @GeneratedValue
//    private int id;
//    @ManyToOne()
//    private Home home;
//    @Enumerated(EnumType.STRING)
//    private String amenity;
//
//    public Amenity(int id, Home home, String amenity) {
//        this.id = id;
//        this.home = home;
//        this.amenity = amenity;
//    }
//
//    public Amenity() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Home getHome() {
//        return home;
//    }
//
//    public void setHome(Home home) {
//        this.home = home;
//    }
//
//    public String getAmenity() {
//        return amenity;
//    }
//
//    public void setAmenity(String amenity) {
//        this.amenity = amenity;
//    }
//
//    @Override
//    public String toString() {
//        return "Amenity{" + "id=" + id + ", home=" + home + ", amenity='" + amenity + '\'' + '}';
//    }
//
//}
