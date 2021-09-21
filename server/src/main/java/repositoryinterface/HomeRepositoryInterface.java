package repositoryinterface;

import java.util.List;
import java.util.Optional;
import model.Home;

public interface HomeRepositoryInterface {

  public Optional<Home> findById(String id);

  public List<Home> findAll();

  public Optional<Home> save(Home home);

}
