package repository;

import datatransforobject.UserCoreDTO;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.User;
import repositoryinterface.UserRepositoryInterface;


public class UserRepository implements UserRepositoryInterface {

  private final EntityManager entityManager;

  public UserRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<User> findById(String ids) {
    int id = Integer.parseInt(ids);

    User user = entityManager.find(User.class, id);
    return user != null ? Optional.of(user) : Optional.empty();
  }

  @Override
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

  @Override
  public List<User> findAll() {
    return entityManager.createQuery("from User", User.class).getResultList();
  }

  @Override
  public Optional<User> save(User user) {
    try {
      entityManager.getTransaction().begin();
      User savedUser = entityManager.merge(user);
      entityManager.getTransaction().commit();
      return Optional.of(savedUser);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  public UserCoreDTO login(String email) {
    try {
      User user = entityManager.createNamedQuery("User.findByEmail", User.class)
          .setParameter("email", email).getSingleResult();

      return user.convertToUserCoreDTO();
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }

  }
}
