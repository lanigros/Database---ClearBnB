package repository;

import javax.persistence.EntityManager;
import model.ActiveSession;
import repositoryinterface.ActiveSessionRepositoryInterface;

public class ActiveSessionRepository implements ActiveSessionRepositoryInterface {
  private final EntityManager entityManager;

  public ActiveSessionRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public int insertActiveSession(int userId){
    entityManager.getTransaction().begin();
    entityManager.persist(new ActiveSession(userId));
    entityManager.getTransaction().commit();
    return userId;
  }

  @Override
  public ActiveSession getActiveSession(int userId){
    return entityManager.createNamedQuery(
        "ActiveSession.getActiveSession", ActiveSession.class)
        .setParameter("userId", userId).getSingleResult();
  }

  @Override
  public void deleteActiveSessionByUserId(int userId){
    entityManager.getTransaction().begin();
    entityManager.createNamedQuery(
        "ActiveSession.deleteByUserId")
        .setParameter("userId", userId).executeUpdate();
    entityManager.getTransaction().commit();
  }

}
