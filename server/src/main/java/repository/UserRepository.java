package repository;

import datatransferobject.UserCoreDTO;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.User;
import org.hibernate.Filter;
import org.hibernate.Session;
import repositoryinterface.UserRepositoryInterface;


public class UserRepository implements UserRepositoryInterface {

  private final EntityManager entityManager;

  public UserRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
    Session session = entityManager.unwrap(Session.class);
    Filter filter = session.enableFilter("reviewFilter");
    filter.setParameter("isDeleted", false);
  }

  @Override
  public Optional<User> findById(String ids) {
    int id = Integer.parseInt(ids);

    User user = entityManager.find(User.class, id);
    return user != null ? Optional.of(user) : Optional.empty();
  }

  public Optional<User> findByEmail(String email) {
    try {
      return Optional.of(entityManager.createNamedQuery("User.findByEmail", User.class)
          .setParameter("email", email).getSingleResult());
    } catch (Exception e) {
      return Optional.empty();
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
