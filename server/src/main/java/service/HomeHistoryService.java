package service;

import datatransforobject.HomeCoreDTO;
import datatransforobject.HomeHistoryDTO;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.HomeHistoryLogMapper;
import mapper.HomeMapper;
import model.Home;
import model.HomeHistoryLog;
import repository.HomeHistoryLogRepository;
import repository.HomeRepository;
import utility.ManagerFactory;

public class HomeHistoryService {

    private final EntityManagerFactory entityManagerFactory =
            ManagerFactory.getEntityManagerFactory("Home_History_log");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final HomeHistoryLogRepository homeHistoryLogRepository =
            new HomeHistoryLogRepository(entityManager);

    public Optional<HomeHistoryDTO> getById(String id) {
         Optional<HomeHistoryLog> homeHistoryDO = homeHistoryLogRepository.findById(id);
        if (homeHistoryDO.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(HomeHistoryLogMapper.convertToCore(homeHistoryDO.get()));

    }
}
