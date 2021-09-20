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
    public Optional<HomeHistoryLog> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<HomeHistoryLog> findAll() {
        return null;
    }

    @Override
    public Optional<HomeHistoryLog> save(HomeHistoryLog homeHistoryLog) {
        return Optional.empty();
    }
}
