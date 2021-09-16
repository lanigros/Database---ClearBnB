package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue
  private int id;
  private String city;
  private String street;
  private String country;
  @Column(name = "zip_code")
  private String zipCode;
  @OneToMany
  private Home home;

  public Address() {
  }

  public Address(String city, String street, String zipCode, String country) {
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
    this.country = country;
  }

  @Override
  public String toString() {
    return "Address{" +
        "id=" + id +
        ", city='" + city + '\'' +
        ", street='" + street + '\'' +
        ", country='" + country + '\'' +
        ", zipCode='" + zipCode + '\'' +
        '}';
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
}
