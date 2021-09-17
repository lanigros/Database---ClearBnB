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

  public User findByEmail(String email) {
    try {
      User user = entityManager.createNamedQuery("User.findByEmail", User.class)
          .setParameter("email", email).getSingleResult();
      System.out.println(user);
      return user;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }

  }

  public List<User> findAll() {
    return entityManager.createQuery("from User").getResultList();
  }


  public Optional<User> save(User user) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(user);
      entityManager.getTransaction().commit();
      return Optional.of(user);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }
}
