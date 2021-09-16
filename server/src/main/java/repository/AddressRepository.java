package repository;

import javax.persistence.EntityManager;

public class AddressRepository {

  EntityManager entityManager;

  public AddressRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

}