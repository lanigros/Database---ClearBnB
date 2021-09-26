package repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

public boolean checkIfAvailable(Timestamp startDate, Timestamp endDate, Home home){
    try{
      BookingDetail bookingDetail = entityManager.createNamedQuery("BookingDetail.checkIfAvailable", BookingDetail.class)
          .setParameter("startDate", startDate)
          .setParameter("endDate", endDate)
          .setParameter("home", home)
          .setMaxResults(1).getSingleResult();
      return false;
    }catch(NoResultException e){
      return true;
    }

}

  @Override
  public Optional<BookingDetail> save(BookingDetail bookingDetail) {
    try {
      entityManager.getTransaction().begin();
      BookingDetail savedBookingDetail = entityManager.merge(bookingDetail);
      entityManager.getTransaction().commit();
      return Optional.of(savedBookingDetail);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }
}
