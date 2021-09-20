package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User {

  @Id
  private int id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  private String email;
  private String password;

  @OneToOne(mappedBy = "user")
  @JsonManagedReference(value = "user-host")
  @JsonProperty(access = Access.READ_ONLY)
  private Host hostProfile;

  @OneToOne(mappedBy = "user")
  @JsonManagedReference(value = "user-renter")
  @JsonProperty(access = Access.READ_ONLY)
  private Renter renterProfile;

  public User() {
  }

  public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  @JsonProperty
  public Host getHostProfile() {
    return hostProfile;
  }

  @JsonIgnore
  public void setHostProfile(Host hostProfile) {
    this.hostProfile = hostProfile;
  }

  @JsonProperty
  public Renter getRenterProfile() {
    return renterProfile;
  }

  @JsonIgnore
  public void setRenterProfile(Renter renterProfile) {
    this.renterProfile = renterProfile;
  }
}
