package repositoryinterface;

import java.util.List;
import java.util.Optional;
import model.BookingDetail;

public interface BookingDetailRepositoryInterface {

  public Optional<BookingDetail> findById(String id);

  public List<BookingDetail> findAll();

  public Optional<BookingDetail> save(BookingDetail bookingDetail);

}
