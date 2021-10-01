package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String city;
  private String street;
  private String country;
  @Column(name = "zip_code")
  private String zipCode;
  @JsonBackReference(value = "homes-address")
  @OneToOne(mappedBy = "address", cascade = CascadeType.MERGE)
  private Home homes;

  public Address() {
  }

  public Address(int id, String city, String street, String country, String zipCode, Home homes) {
    this.id = id;
    this.city = city;
    this.street = street;
    this.country = country;
    this.zipCode = zipCode;
    this.homes = homes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public Home getHomes() {
    return homes;
  }

  public void setHomes(Home homes) {
    this.homes = homes;
  }

  @Override
  public String toString() {
    return "Address{" + "id=" + id + ", city='" + city + '\'' + ", street='" + street + '\''
        + ", country='" + country + '\'' + ", zipCode='" + zipCode + '\'' + '}';
  }
}
