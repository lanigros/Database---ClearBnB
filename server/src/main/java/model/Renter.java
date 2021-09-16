package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Renter")

public class Renter {

  @Id
  @GeneratedValue
  private int id;
  @OneToOne
  @JsonBackReference
  private User user;

  public Renter() {
  }

  @Override
  public String toString() {
    return "Renter " + "id=" + id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
