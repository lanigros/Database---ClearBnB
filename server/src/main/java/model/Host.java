package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "host")
@NamedQueries({
    @NamedQuery(name = "Host.findByUserId", query = "SELECT h FROM Host h WHERE h.user = (SELECT u FROM User u WHERE u.id=:userId)")})
public class Host {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @OneToOne(cascade = CascadeType.MERGE)
  @JsonBackReference(value = "user-host")
  private User user;
  @OneToMany(mappedBy = "host", cascade = CascadeType.MERGE)
  private List<Home> homes = new ArrayList<>();
  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "host_review",
      joinColumns = @JoinColumn(name = "host_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "review_id", referencedColumnName = "id")
  )
  @Where(clause = "is_deleted = 0")
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
