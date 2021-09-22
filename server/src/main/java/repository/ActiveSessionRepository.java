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
  public ActiveSession insertActiveSession(int userId) {
    entityManager.getTransaction().begin();
    ActiveSession activeSession = entityManager.merge(new ActiveSession(userId));
    entityManager.getTransaction().commit();
    return activeSession;
  }

  @Override
  public ActiveSession getActiveSession(int userId) {
    return entityManager.createNamedQuery(
            "ActiveSession.getActiveSession", ActiveSession.class)
        .setParameter("userId", userId).getSingleResult();
  }

  @Override
  public void deleteActiveSessionById(int sessionId) {
    entityManager.getTransaction().begin();
    entityManager.createNamedQuery(
            "ActiveSession.deleteBySessionId")
        .setParameter("sessionId", sessionId).executeUpdate();
    entityManager.getTransaction().commit();
  }

  @Override
  public Map<Integer, Integer> getAllActiveSessions() {
    Map<Integer, Integer> sessions = entityManager.createNamedQuery(
            "ActiveSession.getAllActiveSessions", ActiveSession.class
        ).getResultStream()
        .collect(Collectors.toMap(
            activeSession -> activeSession.getUserId(),
            activeSession -> activeSession.getId()
        ));
    return sessions;
  }

}
