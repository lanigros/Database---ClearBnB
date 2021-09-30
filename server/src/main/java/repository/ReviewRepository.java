package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.Review;
import repositoryinterface.ReviewRepositoryInterface;

public class ReviewRepository implements ReviewRepositoryInterface {

  private final EntityManager entityManager;

  public ReviewRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<Review> findById(int id) {
    Review review = entityManager.find(Review.class, id);
    return review != null ? Optional.of(review) : Optional.empty();
  }

  @Override
  public List<Review> findAll(String id) {
    return entityManager.createQuery("from Review", Review.class).getResultList();
  }

  @Override
  public Optional<Review> save(Review review) {
    try {
      entityManager.getTransaction().begin();
      entityManager.merge(review);
      entityManager.getTransaction().commit();
      return Optional.of(review);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  @Override
  public Optional<Integer> update(int reviewId) {
    try {
      entityManager.getTransaction().begin();
      entityManager.createNamedQuery("Review.deleteReview")
          .setParameter("isDeleted", true)
          .setParameter("id", reviewId)
                   .executeUpdate();
      entityManager.getTransaction().commit();
      entityManager.clear();
      return Optional.of(reviewId);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

}
