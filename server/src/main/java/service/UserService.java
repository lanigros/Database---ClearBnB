package service;

import static java.util.stream.Collectors.toList;

import datatransforobject.UserCoreDTO;
import datatransforobject.UserLoginDTO;
import datatransforobject.UserNameIdDTO;
import datatransforobject.UserProfileDTO;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mapper.UserMapper;
import model.User;
import repository.ActiveSessionRepository;
import repository.UserRepository;
import utility.ManagerFactory;
import utility.Utility;

public class UserService {


  private final EntityManagerFactory entityManagerFactory = ManagerFactory.getEntityManagerFactory(
      "User");
  private final EntityManager entityManager = entityManagerFactory.createEntityManager();
  private final UserRepository userRepository = new UserRepository(entityManager);
  private final ActiveSessionRepository activeSessionRepository = new ActiveSessionRepository(
      entityManager);

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

  public List<UserNameIdDTO> getAllNames() {
    List<User> users = userRepository.findAll();
    List<UserNameIdDTO> list = users.stream().map(UserMapper::convertToNameAndId).collect(toList());

    return list;
  }


  public Optional<UserCoreDTO> registerUser(UserCoreDTO user) {
    Optional<User> exist = userRepository.findByEmail(user.getEmail());
    if (exist.isEmpty()) {
      String hashedPassword = Utility.hash(user.getPassword());
      user.setPassword(hashedPassword);
      Optional<User> createdUser = userRepository.save(user.convertToUser());

      if (createdUser.isPresent()) {
        //To send a json
        UserCoreDTO createdUserCoreDTO = UserMapper.convertToCoreDTOWithoutPassword(
            createdUser.get());
        System.out.println(createdUserCoreDTO);

        return Optional.of(createdUserCoreDTO);

      }
    }
    return Optional.empty();
  }

  public UserCoreDTO checkUserCredentials(UserLoginDTO userLoginDTO) {
    UserCoreDTO userCoreDTO = userRepository.login(userLoginDTO.getEmail());
    if (userCoreDTO == null) {
      return null;
    }

    if (!Utility.match(userLoginDTO.getPassword(), userCoreDTO.getPassword())) {
      return null;
    }

    userCoreDTO.setPassword("***");
    return userCoreDTO;
  }

  public UserCoreDTO findByIdAndReturnUserCoreDTO(String userId) throws Exception {
    Optional<User> user = userRepository.findById(userId);
    if (user.isEmpty()) {
      throw new Exception();
    }
    UserCoreDTO userCoreDTO = user.get().convertToUserCoreDTO();
    userCoreDTO.setPassword("***");
    return userCoreDTO;
  }

  public UserProfileDTO getUserProfile(String userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isEmpty()) {
      return null;
    }
    return UserMapper.convertToProfile(user.get());

  }

}
