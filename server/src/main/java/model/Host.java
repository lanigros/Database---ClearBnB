package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "host")
public class Host {

  @Id
  @GeneratedValue
  private int id;
  @OneToOne
  private User user_id;

  public Host() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Host{" + "id=" + id + ", user_id=" + user_id + '}';
  }

  public User getUser_id() {
    return user_id;
  }

  public void setUser_id(User user_id) {
    this.user_id = user_id;
  }
}
