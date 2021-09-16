package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.Review;

public class ReviewRepository {

  private final EntityManager entityManager;


  public ReviewRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Optional<Review> findById(int id) {
    Review review = entityManager.find(Review.class, id);
    return review != null ? Optional.of(review) : Optional.empty();
  }

  public List<Review> findAll() {
    return entityManager.createQuery("from Review").getResultList();
  }

}
