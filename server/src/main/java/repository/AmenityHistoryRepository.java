package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.AmenityHistory;
import repositoryinterface.AmenityHistoryRepositoryInterface;

public class AmenityHistoryRepository implements AmenityHistoryRepositoryInterface {

  EntityManager entityManager;

  public AmenityHistoryRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<AmenityHistory> findById(String ids) {
    int id = Integer.parseInt(ids);
    AmenityHistory amenityHistory = entityManager.find(AmenityHistory.class, id);
    return amenityHistory != null ? Optional.of(amenityHistory) : Optional.empty();
  }

  public List<AmenityHistory> findByHomeHistoryId(String homeHistoryId) {
    List<AmenityHistory> amenityHistory = entityManager.createNamedQuery(
                                                           "AmenityHistory" + ".findByHomeHistoryId", AmenityHistory.class)
                                                       .setParameter("id", homeHistoryId)
                                                       .getResultList();
    return amenityHistory;
  }

}
