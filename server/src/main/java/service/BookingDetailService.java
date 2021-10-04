package service;

import datatransforobject.BookingDetailCoreDTO;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.BookingDetailMapper;
import model.BookingDetail;
import model.Home;
import model.Renter;
import repository.BookingDetailRepository;
import repository.HomeRepository;
import repository.RenterRepository;
import utility.ManagerFactory;
import utility.Utility;

public class BookingDetailService {
  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "User");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final RenterRepository renterRepository = new RenterRepository(entityManager);
  private final BookingDetailRepository bookingDetailRepository = new BookingDetailRepository(entityManager);
  private final HomeRepository homeRepository = new HomeRepository(entityManager);

  public Optional<BookingDetail> createBooking(String sessionId, BookingDetailCoreDTO bookingDetailCoreDTO) {
    int userId = ActiveSessionService.getActiveSessionUserId(sessionId);
    // Find renterProfile
    Optional<Renter> renter = renterRepository.findByUserId(userId);
    if (renter.isEmpty()) return Optional.empty();
    // Find home about to be booked
    Optional<Home> home = homeRepository.findById(String.valueOf(bookingDetailCoreDTO.getHomeId()));
    if (home.isEmpty() || bookingDetailCoreDTO.getStartDate().before(home.get().getStartDate()) ||
        bookingDetailCoreDTO.getEndDate().after(home.get().getEndDate())) {
      System.out.println("if");
      return Optional.empty();
    }
    
    BookingDetail bookingDetail = BookingDetailMapper.convertToBookingDetail(bookingDetailCoreDTO,
        renter.get(), home.get());

    boolean available = bookingDetailRepository.checkIfAvailable(bookingDetail.getStartDate(),
        bookingDetail.getEndDate(), home.get());
    if(!available) return Optional.empty();

    //calculate total price
    int pricePerNight = bookingDetail.getHome().getPricePerNight();
    System.out.println(pricePerNight);
    int duration = Utility.calculateDuration(bookingDetail.getStartDate(), bookingDetail.getEndDate());
    int totalPrice = pricePerNight * duration;
    bookingDetail.setTotalPrice(totalPrice);



    // try to perform payment, break if doesn't work
    if(!WalletService.tryTransaction(totalPrice, userId)){
      return Optional.empty();
    }

    return bookingDetailRepository.save(bookingDetail);
  }

}
