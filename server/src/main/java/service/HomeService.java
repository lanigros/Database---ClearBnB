package service;

import datatransforobject.HomeCoreDTO;
import datatransforobject.HomeHistoryDTO;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.HomeMapper;
import model.Home;
import model.HomeHistoryLog;
import repository.HomeHistoryLogRepository;
import repository.HomeRepository;
import utility.ManagerFactory;

public class HomeService {

  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "Home");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final HomeRepository homeRepository = new HomeRepository(entityManager);
  private final HomeHistoryLogRepository homeHistoryLogRepository =
          new HomeHistoryLogRepository(entityManager);

  public Optional<HomeCoreDTO> getById(String id) {

    Optional<Home> homeDO = homeRepository.findById(id);

    if (homeDO.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(HomeMapper.convertToCore(homeDO.get()));

  }
  public Optional<HomeHistoryDTO> getId(String id) {

        Optional<HomeHistoryLog> homeHistoryDO = homeHistoryLogRepository.findById(id);
        if (homeHistoryDO.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(HomeMapper.convertToCore(homeHistoryDO.get()));

    }

    public List<HomeHistoryLog> getByHomeId(String homeId) {
        List<HomeHistoryLog> homeHistoryHomeId =
                homeHistoryLogRepository.findByHomeId(homeId);
        return homeHistoryHomeId;

    }
}

