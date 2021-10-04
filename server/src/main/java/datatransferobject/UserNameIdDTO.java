package datatransferobject;

public class UserNameIdDTO {

  private String fullName;
  private int id;

  public UserNameIdDTO(String fullName, int id) {
    this.fullName = fullName;
    this.id = id;
  }

  public UserNameIdDTO() {

  }

  @Override
  public String toString() {
    return "UserNameIdDTO{" + "fullName='" + fullName + '\'' + ", id=" + id + '}';
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String firstName, String lastName) {
    this.fullName = firstName + " " + lastName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
