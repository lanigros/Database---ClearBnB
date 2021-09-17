import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Home;
import repository.HomeRepository;

public class Main {

    public static void main(String[] args) {
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Home");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        HomeRepository HomeRepository = new HomeRepository(entityManager);
        // Create our repositories
        List<Home> homes = HomeRepository.findAll();
        System.out.println(homes);
    }

}
