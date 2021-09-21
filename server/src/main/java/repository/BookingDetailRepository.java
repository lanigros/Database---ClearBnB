package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.BookingDetail;
import model.Home;
import repositoryinterface.BookingDetailRepositoryInterface;
import repositoryinterface.HomeRepositoryInterface;

public class BookingDetailRepository implements BookingDetailRepositoryInterface {

  private final EntityManager entityManager;


  public BookingDetailRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<BookingDetail> findById(String id) {
    BookingDetail bookingDetail = entityManager.find(BookingDetail.class, id);
    return bookingDetail != null ? Optional.of(bookingDetail) : Optional.empty();
  }
  @Override
  public List<BookingDetail> findAll() {
    return entityManager.createQuery("from BookingDetail", BookingDetail.class).getResultList();
  }

  @Override
  public Optional<BookingDetail> save(BookingDetail bookingDetail) {
    return Optional.empty();
  }
}
