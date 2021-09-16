package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.User;


public class UserRepository {

  private final EntityManager entityManager;


  public UserRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Optional<User> findById(int id) {
    User user = entityManager.find(User.class, id);
    return user != null ? Optional.of(user) : Optional.empty();
  }

  public List<User> findAll() {
    return entityManager.createQuery("from User").getResultList();
  }
}
