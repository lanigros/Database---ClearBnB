package repository;

import javax.persistence.EntityManager;

public class RenterRepository {

  EntityManager entityManager;

  public RenterRepository(EntityManager entityManager){
    this.entityManager = entityManager;
  }

}
