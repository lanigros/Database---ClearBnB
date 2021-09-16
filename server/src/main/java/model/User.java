package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User {

  @Id
  @GeneratedValue
  private Integer id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  private String email;
  private String password;
  @JsonManagedReference
  @OneToOne(mappedBy = "user")
  @JsonManagedReference
  private Host hostProfile;
  @JsonManagedReference
  @OneToOne(mappedBy = "user")
  @JsonManagedReference
  private Renter renterProfile;

  public User() {
  }

  public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
        + ", email='" + email + '\'' + ", password='" + password + '\'';
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Host getHostProfile() {
    return hostProfile;
  }

  public void setHostProfile(Host hostProfile) {
    this.hostProfile = hostProfile;
  }

  public Renter getRenterProfile() {
    return renterProfile;
  }

  public void setRenterProfile(Renter renterProfile) {
    this.renterProfile = renterProfile;
  }
}
