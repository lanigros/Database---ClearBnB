package repository;

import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import model.ActiveSession;
import repositoryinterface.ActiveSessionRepositoryInterface;

public class ActiveSessionRepository implements ActiveSessionRepositoryInterface {

  private final EntityManager entityManager;

  public ActiveSessionRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public ActiveSession insertActiveSession(int userId, String sessionId) {
    entityManager.getTransaction().begin();
    ActiveSession activeSession = entityManager.merge(new ActiveSession(userId, sessionId));
    entityManager.getTransaction().commit();
    return activeSession;
  }

  @Override
  public void deleteActiveSessionById(String sessionId) {
    entityManager.getTransaction().begin();
    entityManager.createNamedQuery(
            "ActiveSession.deleteBySessionId")
        .setParameter("sessionId", sessionId).executeUpdate();
    entityManager.getTransaction().commit();
  }

  @Override
  public void deleteActiveSessionByUserId(int userId) {
    entityManager.getTransaction().begin();
    entityManager.createNamedQuery(
            "ActiveSession.deleteByUserId")
        .setParameter("userId", userId).executeUpdate();
    entityManager.getTransaction().commit();
  }

  @Override
  public Map<String, Integer> getAllActiveSessions() {
    Map<String, Integer> sessions = entityManager.createNamedQuery(
            "ActiveSession.getAllActiveSessions", ActiveSession.class
        ).getResultStream()
        .collect(Collectors.toMap(
            activeSession -> activeSession.getId(),
            activeSession -> activeSession.getUserId()
        ));
    return sessions;
  }

}
