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
    public Optional<AmenityHistory> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<AmenityHistory> findAll() {
        return null;
    }

}
