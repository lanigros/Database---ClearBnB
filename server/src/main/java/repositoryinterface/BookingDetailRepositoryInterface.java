package repositoryinterface;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import model.BookingDetail;
import model.Home;

public interface BookingDetailRepositoryInterface {

  public Optional<BookingDetail> findById(String id);

  public List<BookingDetail> findAll();

  public Optional<BookingDetail> save(BookingDetail bookingDetail);

  public boolean checkIfAvailable(Timestamp startDate, Timestamp endDate, Home home);

}
