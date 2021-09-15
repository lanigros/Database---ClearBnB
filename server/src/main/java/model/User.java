package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")})
public class User {

  @Id
  @GeneratedValue
  private Integer id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  private String email;
//  @OneToOne(mappedBy = "user_id")
//  private Host hostProfile;
//  @OneToOne(mappedBy = "user_id")
//  private Renter renterProfile;

  public User() {
  }

  public User(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
        + '\'' + ", email='" + email + '\'' + ", password='" + '\'';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
