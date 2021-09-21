package service;

import datatransforobject.HomeCoreDTO;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.HomeMapper;
import model.Home;
import repository.HomeRepository;
import utility.ManagerFactory;

public class HomeService {

  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "Home");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final HomeRepository homeRepository = new HomeRepository(entityManager);

  public Optional<HomeCoreDTO> getById(String id) {

    Optional<Home> homeDO = homeRepository.findById(id);

    if (homeDO.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(HomeMapper.convertToCore(homeDO.get()));

  }
}

