package repositoryinterface;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import model.Home;

public interface HomeRepositoryInterface {

  public Optional<Home> findById(String id);

  public int findPriceById(int homeId);

  public List<?> findAll(String query, Map<String, List<String>> filters) throws ParseException;

  public Optional<Home> save(Home home, boolean isUpdate);

}
