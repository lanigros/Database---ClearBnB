package service;

import datatransforobject.HomeAddressDTO;
import datatransforobject.HomeCoreDTO;
import datatransforobject.HomeHistoryDTO;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.AddressMapper;
import mapper.HomeMapper;
import model.Address;
import model.Home;
import model.HomeHistoryLog;
import model.Host;
import org.hibernate.Filter;
import org.hibernate.Session;
import repository.HomeHistoryLogRepository;
import repository.HomeRepository;
import repository.HostRepository;
import utility.ManagerFactory;
import utility.Utility;

public class HomeService {


  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "Home");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final HomeRepository homeRepository = new HomeRepository(entityManager);
  private final HomeHistoryLogRepository homeHistoryLogRepository = new HomeHistoryLogRepository(
      entityManager);


  private final HostRepository hostRepository = new HostRepository(entityManager);

  private final ActiveSessionService activeSessionService;


  public HomeService() {
    this.activeSessionService = new ActiveSessionService();

  }

  public Optional<HomeCoreDTO> getById(String id) {

    Optional<Home> homeDO = homeRepository.findById(id);

    if (homeDO.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(HomeMapper.convertToCore(homeDO.get()));

  }

  public List<Home> getAll(Map<String, List<String>> filters) throws ParseException {
    Session session = entityManager.unwrap(Session.class);

    if (filters.containsKey("price")) {
      int price = Integer.parseInt(filters.get("price").get(0));
      Filter filter2 = session.enableFilter("priceFilter");
      filter2.setParameter("price_per_night", price);
    }
    if (filters.containsKey("start_date")) {
      Timestamp start = Utility.convertToTimestamp(filters.get("start_date").get(0));
      Timestamp end = Utility.convertToTimestamp(filters.get("end_date").get(0));

      Filter filter = session.enableFilter("dateFilter");
      filter.setParameter("start_date", start);
      filter.setParameter("end_date", end);
    }

    List<Home> homes = homeRepository.findAll();
    session.disableFilter("priceFilter");
    session.disableFilter("dateFilter");
    return homes;
  }


  public Optional<HomeHistoryDTO> getId(String id) {

    Optional<HomeHistoryLog> homeHistoryDO = homeHistoryLogRepository.findById(id);
    if (homeHistoryDO.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(HomeMapper.convertToCore(homeHistoryDO.get()));

  }

  public List<HomeHistoryLog> getByHomeId(String homeId) {
    List<HomeHistoryLog> homeHistoryHomeId = homeHistoryLogRepository.findByHomeId(homeId);
    return homeHistoryHomeId;

  }

  public Optional<Home> createHome(String sessionID, HomeAddressDTO dto) {
//    int userId = activeSessionService.getActiveSessionUserId(sessionID);
    int userId = 1;
    Optional<Host> host = hostRepository.findByUserId(userId);

    if(host.isEmpty()){
      return Optional.empty();
    }
    Home home = HomeMapper.convertToHome(dto, host.get());
    Address address = AddressMapper.convertToAddress(dto, home);

    Optional<Home> savedHome = homeRepository.save(home);
    return savedHome;




    //fixa en host from userID




  }


}

