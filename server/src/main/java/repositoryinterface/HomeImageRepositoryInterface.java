package repositoryinterface;

import java.util.List;
import java.util.Optional;
import model.HomeImage;

public interface HomeImageRepositoryInterface {

  public Optional<HomeImage> findById(String id);

  public List<HomeImage> findAll();

  public Optional<HomeImage> save(HomeImage homeImage);

}
