package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.HomeHistoryLog;
import repositoryinterface.HomeHistoryLogRepositoryInterface;

public class HomeHistoryLogRepository implements HomeHistoryLogRepositoryInterface {

  private final EntityManager entityManager;

  public HomeHistoryLogRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<HomeHistoryLog> findById(String ids) {
    int id = Integer.parseInt(ids);
    HomeHistoryLog homeHistoryLog = entityManager.find(HomeHistoryLog.class, id);
    return homeHistoryLog != null ? Optional.of(homeHistoryLog) : Optional.empty();
  }

  @Override
  public List<HomeHistoryLog> findByHomeId(String homeId) {
    List<HomeHistoryLog> homeHistoryLog = entityManager.createNamedQuery(
        "HomeHistoryLog.findByHomeId", HomeHistoryLog.class).setParameter("id", homeId)
        .getResultList();
    return homeHistoryLog;
  }

  @Override
  public Optional<HomeHistoryLog> save(HomeHistoryLog home) {
    try {
      entityManager.getTransaction().begin();
      entityManager.merge(home);
      entityManager.getTransaction().commit();
      return Optional.of(home);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

}
