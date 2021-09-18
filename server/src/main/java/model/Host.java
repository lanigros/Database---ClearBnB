package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "host")
public class Host {

  @Id
  @GeneratedValue
  private int id;
  @OneToOne
  @JsonBackReference
  private User user;
  @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
  private List<Home> homes = new ArrayList<>();
  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "host_review",
      joinColumns = @JoinColumn(name = "host_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "review_id", referencedColumnName = "id")
  )
  private List<Review> reviews = new ArrayList<>();

  public Host() {
  }

  public Host(int id, User user, List<Home> homes, List<Review> reviews) {
    this.id = id;
    this.user = user;
    this.homes = homes;
    this.reviews = reviews;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public List<Home> getHomes() {
    return homes;
  }

  public void setHomes(List<Home> homes) {
    this.homes = homes;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Host" + "id=" + id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
