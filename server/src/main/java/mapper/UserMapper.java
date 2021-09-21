package mapper;

import datatransforobject.UserCoreDTO;
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

  public static User hidePasswordFromUser(User user){
    user.setPassword("***");
    return user;
  }

}
