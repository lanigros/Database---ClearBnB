package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "active_session")
@Transactional
@NamedQueries({
    @NamedQuery(name = "ActiveSession.getActiveSession", query = "SELECT a FROM ActiveSession a WHERE a.userId = :userId"),
    @NamedQuery(name = "ActiveSession.deleteBySessionId", query = "DELETE ActiveSession a WHERE a.id = :sessionId"),
    @NamedQuery(name = "ActiveSession.getAllActiveSessions", query = "SELECT a FROM ActiveSession a")
})

public class ActiveSession {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "user_id")
  private int userId;

  public ActiveSession() {
  }

  public ActiveSession(int userId) {
    this.userId = userId;
  }

  public int getId() {
    return id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
