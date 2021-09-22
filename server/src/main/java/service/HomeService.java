package service;

import datatransforobject.HomeCoreDTO;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.HomeMapper;
import model.Home;
import org.hibernate.Filter;
import org.hibernate.Session;
import repository.HomeRepository;
import utility.ManagerFactory;

public class HomeService {

  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "Home");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  Session session = entityManager.unwrap(Session.class);

  private final HomeRepository homeRepository = new HomeRepository(entityManager);

  public Optional<HomeCoreDTO> getById(String id) {

    Optional<Home> homeDO = homeRepository.findById(id);

    if (homeDO.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(HomeMapper.convertToCore(homeDO.get()));

  }

  public List<Home> getAllWithEverything() {
    Filter filter = session.enableFilter("dateFilter");
    Filter filter2 = session.enableFilter("priceFilter");
    Filter filter3 = session.enableFilter("countryFilter");
    Date date = new Date();
    Timestamp ts1 = new Timestamp(date.getTime());
    long a = 1635909136530L;
    Timestamp ts2 = new Timestamp(a);

    System.out.println(ts1.toLocalDateTime() + " " + ts2.toLocalDateTime());
    filter.setParameter("start_date", ts1);
    filter.setParameter("end_date", ts2);
    filter2.setParameter("price_per_night", 1000);
    filter3.setParameter("country", "AAAAA");

    List<Home> homes = homeRepository.findAll();
    return homes;
  }
}

