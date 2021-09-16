package repository;

import javax.persistence.EntityManager;

public class HomeHistoryLogRepository {

    private final EntityManager entityManager;

    public HomeHistoryLogRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
