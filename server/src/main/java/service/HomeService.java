package service;

import datatransforobject.HomeCoreDTO;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.HomeMapper;
import model.Home;
import org.hibernate.Filter;
import org.hibernate.Session;
import repository.HomeRepository;
import utility.ManagerFactory;
import utility.Utility;

public class HomeService {


  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "Home");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();

  private final HomeRepository homeRepository = new HomeRepository(entityManager);

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


}

