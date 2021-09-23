package mapper;

import datatransforobject.UserCoreDTO;
import datatransforobject.UserNameIdDTO;
import model.User;

public class UserMapper {

  public static UserCoreDTO convertToCoreDTOWithoutPassword(User user) {
    UserCoreDTO dto = new UserCoreDTO();
    dto.setFirstName(user.getFirstName());
    dto.setLastName(user.getLastName());
    dto.setEmail(user.getEmail());
    dto.setId(user.getId());

    return dto;
  }

  public static User hidePasswordFromUser(User user) {
    user.setPassword("***");
    return user;
  }

  public static User convertToUser(UserCoreDTO dto) {

    User userDO = new User();
    userDO.setFirstName(dto.getFirstName());
    userDO.setLastName(dto.getLastName());
    userDO.setEmail(dto.getEmail());
    userDO.setPassword(dto.getPassword());
    return userDO;
  }

  public static UserNameIdDTO convertToNameAndId(User user) {
    UserNameIdDTO dto = new UserNameIdDTO();
    dto.setFullName(user.getFirstName(), user.getLastName());
    dto.setId(user.getId());
    return dto;

  }

}
