package repositoryinterface;

import java.util.List;
import java.util.Optional;
import model.Host;
import model.Renter;

public interface RenterRepositoryInterface {

  public Optional<Renter> findById(String id);

  public List<Renter> findAll();

  public Optional<Renter> save(Renter renter);

}
