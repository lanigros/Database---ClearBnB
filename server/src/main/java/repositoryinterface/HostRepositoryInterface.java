package repositoryinterface;

import java.util.List;
import java.util.Optional;
import model.Host;

public interface HostRepositoryInterface {

  public Optional<Host> findById(String id);

  public List<Host> findAll();

  public Optional<Host> save(Host host);

}
