package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.Host;
import model.Renter;
import repositoryinterface.RenterRepositoryInterface;

public class RenterRepository implements RenterRepositoryInterface {

  EntityManager entityManager;

  public RenterRepository(EntityManager entityManager){
    this.entityManager = entityManager;
  }

  @Override
  public Optional<Renter> findById(String id) {
    return Optional.empty();
  }

  @Override
  public List<Renter> findAll() {
    return null;
  }

  @Override
  public Optional<Renter> save(Renter renter) {
    return Optional.empty();
  }

  public Optional<Renter> findByUserId(int userId) {
    try {
      return Optional.of(entityManager.createNamedQuery("Renter.findByUserId", Renter.class)
          .setParameter("userId", userId).getSingleResult());

    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
