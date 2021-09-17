package repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import model.BookingDetail;

public class BookingDetailRepository {

  private final EntityManager entityManager;


  public BookingDetailRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Optional<BookingDetail> findById(int id) {
    BookingDetail bookingDetail = entityManager.find(BookingDetail.class, id);
    return bookingDetail != null ? Optional.of(bookingDetail) : Optional.empty();
  }

  public List<BookingDetail> findAll() {
    return entityManager.createQuery("from BookingDetail", BookingDetail.class).getResultList();
  }

}
