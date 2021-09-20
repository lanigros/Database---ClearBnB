package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.HomeImage;

public class HomeImageRepository {

  EntityManager entityManager;

  public HomeImageRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Optional<HomeImage> findById(String wantedId) {
    int id = Integer.parseInt(wantedId);

    HomeImage homeImage = entityManager.find(HomeImage.class, id);
    return homeImage != null ? Optional.of(homeImage) : Optional.empty();
  }

  public List<HomeImage> findAll() {
    return entityManager.createQuery("from HomeImage").getResultList();
  }

}
