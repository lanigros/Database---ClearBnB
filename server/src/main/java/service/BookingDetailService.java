package service;

import datatransforobject.BookingDetailCoreDTO;
import datatransforobject.HomeAddressDTO;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.AddressMapper;
import mapper.BookingDetailMapper;
import model.Address;
import model.BookingDetail;
import model.Home;
import model.Renter;
import repository.BookingDetailRepository;
import repository.HomeRepository;
import repository.RenterRepository;
import utility.ManagerFactory;

public class BookingDetailService {
  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "User");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final RenterRepository renterRepository = new RenterRepository(entityManager);
  private final BookingDetailRepository bookingDetailRepository = new BookingDetailRepository(entityManager);
  private final HomeRepository homeRepository = new HomeRepository(entityManager);

  public Optional<BookingDetail> createHome(String sessionID, BookingDetailCoreDTO bookingDetailCoreDTO) {
    int userId = ActiveSessionService.getActiveSessionUserId(sessionID);
    Optional<Renter> renter = renterRepository.findByUserId(8);
    if (renter.isEmpty()) {
      return Optional.empty();
    }
    Optional<Home> home = homeRepository.findById(String.valueOf(bookingDetailCoreDTO.getHomeId()));
    if(home.isEmpty()) return Optional.empty();
    BookingDetail bookingDetail = BookingDetailMapper.convertToBookingDetail(bookingDetailCoreDTO,
        renter.get(), home.get());
    return bookingDetailRepository.save(bookingDetail);
  }
}
