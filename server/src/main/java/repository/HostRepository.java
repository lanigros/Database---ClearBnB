package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.Host;
import repositoryinterface.HostRepositoryInterface;

public class HostRepository implements HostRepositoryInterface {

  EntityManager entityManager;

  public HostRepository(EntityManager entityManager){
    this.entityManager = entityManager;
  }

  @Override
  public Optional<Host> findById(String id) {
    return Optional.empty();
  }

  @Override
  public List<Host> findAll() {
    return null;
  }

  @Override
  public Optional<Host> save(Host host) {
    return Optional.empty();
  }
}
