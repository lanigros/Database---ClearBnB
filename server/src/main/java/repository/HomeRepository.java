package repository;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Home;
import model.HomeView;
import repositoryinterface.HomeRepositoryInterface;
import utility.Utility;

public class HomeRepository implements HomeRepositoryInterface {

  private final EntityManager entityManager;

  public HomeRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public Optional<Home> findById(String ids) {
    int id = Integer.parseInt(ids);
    Home home = entityManager.find(Home.class, id);
    System.out.println(home.getHistoryLogs());
    return home != null ? Optional.of(home) : Optional.empty();
  }

  public int findPriceById(int homeId) {
    return entityManager.createNamedQuery("Home.findPriceById", Integer.class)
        .setParameter("id", homeId).getSingleResult();
  }

  @Override
  public List<HomeView> findAll(String q, Map<String, List<String>> filters) throws ParseException {
    Query query = entityManager.createNativeQuery(q, HomeView.class);
    for (Map.Entry<String, List<String>> entry : filters.entrySet()) {
      String key = entry.getKey();
      List<String> value = entry.getValue();
      if (key.contains("date")) {
        query.setParameter(key, Utility.convertToTimestamp(value.get(0)));
      } else if (key.equals("amenity")) {
        for (int i = 0; i < value.size(); i++){
          query.setParameter(("am"+(i+1)), value.get(i));
        }
      } else if (key.equals("search"))  {
        query.setParameter(key, "%"+value.get(0)+"%");
      } else {
        query.setParameter(key, value.get(0));

      }
    }
    return query.getResultList();
  }

  public List<Home> bulkFind(String query) {
    return entityManager.createQuery(query, Home.class).getResultList();
  }

  @Override
  public Optional<Home> save(Home home, boolean homeIsUpdate) {
    try {
      entityManager.getTransaction().begin();
      if (homeIsUpdate) {
        entityManager.createNamedQuery("Amenity.deleteAllByHome").setParameter("home", home)
            .executeUpdate();
        entityManager.createNamedQuery("HomeImage.deleteAllByHome").setParameter("home", home)
            .executeUpdate();
      }
      entityManager.merge(home);
      entityManager.getTransaction().commit();
      entityManager.clear();
      return Optional.of(home);
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }
}
