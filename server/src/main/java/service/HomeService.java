package service;

import datatransforobject.HomeAddressDTO;
import datatransforobject.HomeCoreDTO;
import datatransforobject.HomeCoreNoHostDTO;
import datatransforobject.HomeHistoryDTO;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.AddressMapper;
import mapper.HomeMapper;
import model.Address;
import model.AmenityHistory;
import model.Home;
import model.HomeHistoryLog;
import model.HomeView;
import model.Host;
import org.hibernate.Filter;
import org.hibernate.Session;
import repository.AmenityHistoryRepository;
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
  private final AmenityHistoryRepository amenityHistoryRepository = new AmenityHistoryRepository(
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

  public List getAll(Map<String, List<String>> filters) throws ParseException {
    Session session = entityManager.unwrap(Session.class);
    if (filters.containsKey("price")) {
      int price = Integer.parseInt(filters.get("price").get(0));
      Filter filter2 = session.enableFilter("priceFilter");
      filter2.setParameter("pricePerNight", price);
    }
    if (filters.containsKey("start_date")) {
      Timestamp start = Utility.convertToTimestamp(filters.get("start_date").get(0));
      Timestamp end = Utility.convertToTimestamp(filters.get("end_date").get(0));
      Filter filter = session.enableFilter("dateFilter");
      filter.setParameter("start_date", start);
      filter.setParameter("end_date", end);
    }
//    Filter f = session.enableFilter("countryFilter");
//    f.setParameter("country", "country");
    List<HomeView> homes = homeRepository.findAll();

    session.disableFilter("priceFilter");
    session.disableFilter("dateFilter");
    session.disableFilter("countryFilter");

    if(homes.size() > 0){
      Set<Integer> list = new HashSet<>();
      homes.forEach(home -> {
        System.out.print(home.getPricePerNight());
        list.add(home.getId());
      });

      StringBuilder query = new StringBuilder("SELECT h FROM Home h WHERE h.id = ");

      for(int nr: list){
        query.append(nr).append(" OR h.id = ");
      }

      List<Home> homes1 = homeRepository.bulkFind(query.substring(0, query.length()-11));
      return HomeMapper.convertToNoHost(homes1);
    }
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

  public List<AmenityHistory> getByHomeHistoryId(String homeHistoryId) {
    List<AmenityHistory> amenityHistoryList = amenityHistoryRepository.findByHomeHistoryId(
        homeHistoryId);
    return amenityHistoryList;
  }

  public Optional<Home> createHome(String sessionID, HomeAddressDTO dto) {
    int userId = activeSessionService.getActiveSessionUserId(sessionID);
    Optional<Host> host = hostRepository.findByUserId(userId);
    if(host.isEmpty()){
      return Optional.empty();
    }
    Home home = HomeMapper.convertToHome(dto, host.get());
    Address address = AddressMapper.convertToAddress(dto, home);
    home.setAddress(address);

    Optional<Home> savedHome = homeRepository.save(home);
    return savedHome;




    //fixa en host from userID




  }


}

