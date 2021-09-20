package repository;

import javax.persistence.EntityManager;

public class AmenityRepository {

    EntityManager entityManager;

    public AmenityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
