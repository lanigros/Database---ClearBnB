package repositoryinterface;

import java.util.List;
import java.util.Optional;
import model.AmenityHistory;

public interface AmenityHistoryRepositoryInterface {

    public Optional<AmenityHistory> findById(String id);

    public List<AmenityHistory> findAll();

}
