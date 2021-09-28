package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.Host;
import model.User;
import repositoryinterface.HostRepositoryInterface;

public class HostRepository implements HostRepositoryInterface {

  EntityManager entityManager;

  public HostRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<Host> findById(String ids) {
    int id = Integer.parseInt(ids);

    Host host = entityManager.find(Host.class, id);
    return host != null ? Optional.of(host) : Optional.empty();
  }

  @Override
  public List<Host> findAll() {
    return null;
  }

  @Override
  public Optional<Host> save(Host host) {
    try {
      entityManager.getTransaction().begin();
      entityManager.merge(host);
      entityManager.getTransaction().commit();
      return Optional.of(host);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  public Optional<Host> findByUserId(int id) {
    try {
      return Optional.of(
          entityManager.createNamedQuery("Host.findByUserId", Host.class).setParameter("userId", id)
                       .getSingleResult());
    } catch (Exception e) {
      return Optional.empty();
    }
  }

}
