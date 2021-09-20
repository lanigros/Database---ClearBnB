package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.HomeImage;
import repositoryinterface.HomeImageRepositoryInterface;

public class HomeImageRepository implements HomeImageRepositoryInterface {

  EntityManager entityManager;

  public HomeImageRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }
  @Override
  public Optional<HomeImage> findById(String id) {
    int idi = Integer.parseInt(id);

    HomeImage homeImage = entityManager.find(HomeImage.class, id);
    return homeImage != null ? Optional.of(homeImage) : Optional.empty();
  }

  @Override
  public Optional<HomeImage> save(HomeImage homeImage) {
    return Optional.empty();
  }

  @Override
  public List<HomeImage> findAll() {
    return entityManager.createQuery("from HomeImage").getResultList();
  }

}
