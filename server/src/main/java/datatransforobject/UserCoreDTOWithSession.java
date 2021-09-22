package datatransforobject;

public class UserCoreDTOWithSession extends UserCoreDTO {

  private int sessionId;

  public UserCoreDTOWithSession(int id, String firstName, String lastName, String email,
      String password, int sessionId) {
    super(id, firstName, lastName, email, password);
    this.sessionId = sessionId;
  }

  public int getSessionId() {
    return sessionId;
  }

  public void setSessionId(int sessionId) {
    this.sessionId = sessionId;
  }

  public void hidePassword() {
    this.setPassword("***");
  }

}
