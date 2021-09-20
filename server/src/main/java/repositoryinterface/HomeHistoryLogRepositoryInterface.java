package repositoryinterface;

import java.util.List;
import java.util.Optional;
import model.HomeHistoryLog;

public interface HomeHistoryLogRepositoryInterface {

  public Optional<HomeHistoryLog> findById(String id);

  public List<HomeHistoryLog> findAll();

  public Optional<HomeHistoryLog> save(HomeHistoryLog homeHistoryLog);
}
