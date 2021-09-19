package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "image")
@NamedQueries({
    @NamedQuery(name = "HomeImage.findById", query = "SELECT h FROM HomeImage h WHERE h.id = :id"),
    @NamedQuery(name = "HomeImage.findAll", query = "SELECT h FROM HomeImage h")
})
public class HomeImage {

  @Id
  @GeneratedValue
  private int id;
  @Column(name = "image_url")
  private String imageUrl;
  @JsonBackReference
  @ManyToOne
  private Home home;

  public HomeImage() {

  }

  public HomeImage(int id, String imageUrl, Home home) {
    this.id = id;
    this.imageUrl = imageUrl;
    this.home = home;
  }

  @Override
  public String toString() {
    return "HomeImage{" +
        "id=" + id +
        ", imageUrl='" + imageUrl +
        '}';
  }

  public int getId() {
    return id;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Home getHome() {
    return home;
  }

  public void setHome(Home home) {
    this.home = home;
  }
}
