package service;

import datatransforobject.UserCoreDTO;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.UserMapper;
import model.User;
import repository.UserRepository;
import utility.ManagerFactory;

public class UserService {


  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "User");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final UserRepository userRepository = new UserRepository(entityManager);

  public Optional<UserCoreDTO> getById(String id) {
    Optional<User> userDO = userRepository.findById(id);

    if (userDO.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(UserMapper.convertToCoreDTOWithoutPassword(userDO.get()));
  }

  public List<User> getAllWithEverything() {
    List<User> users = userRepository.findAll();
    users.forEach(UserMapper::hidePasswordFromUser);
    return users;
  }

}
