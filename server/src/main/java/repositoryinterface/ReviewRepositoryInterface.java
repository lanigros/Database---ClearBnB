package repositoryinterface;

import java.util.List;
import java.util.Optional;
import model.Review;

public interface ReviewRepositoryInterface {

  public Optional<Review> findById(String id);

  public List<Review> findAll();

  public Optional<Review> save(Review review);

}
