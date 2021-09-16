import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.User;
import repository.UserRepository;

public class Main {

  public static void main(String[] args) {

    // Create our entity manager
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("User");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    UserRepository userRepository = new UserRepository(entityManager);

    // Create our repositories
    Optional<User> user = userRepository.findById(1);

    System.out.println(user.isPresent() ? user : "No user with that id");

  }

}
