package mapper;

import datatransforobject.UserCoreDTO;
import model.User;

public class UserMapper {

  public static UserCoreDTO withoutPassword(User user) {
    UserCoreDTO dto = new UserCoreDTO();
    dto.setFirstName(user.getFirstName());
    dto.setLastName(user.getLastName());
    dto.setEmail(user.getEmail());
    dto.setId(user.getId());

    return dto;
  }

}
