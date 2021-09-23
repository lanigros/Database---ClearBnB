package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.Home;
import repositoryinterface.HomeRepositoryInterface;

public class HomeRepository implements HomeRepositoryInterface {

  private final EntityManager entityManager;

  public HomeRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<Home> findById(String ids) {
    int id = Integer.parseInt(ids);
    Home home = entityManager.find(Home.class, id);
    return home != null ? Optional.of(home) : Optional.empty();
  }

  @Override
  public List<Home> findAll() {
    return entityManager.createQuery("from Home").getResultList();
  }

  @Override
  public Optional<Home> save(Home home) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(home);
      entityManager.getTransaction().commit();
      return Optional.of(home);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }
}
