package repository;

import javax.persistence.EntityManager;

public class HostRepository {

  EntityManager entityManager;

  public HostRepository(EntityManager entityManager){
    this.entityManager = entityManager;
  }

}
