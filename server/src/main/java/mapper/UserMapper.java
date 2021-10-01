package mapper;

import datatransforobject.UserCompleteProfileDTO;
import datatransforobject.UserCoreDTO;
import datatransforobject.UserNameIdDTO;
import datatransforobject.UserProfileDTO;
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

  public static UserProfileDTO convertToProfile(User user) {
    UserProfileDTO dto = new UserProfileDTO();
    dto.setHomes(HomeMapper.convertToNoHost(user.getHostProfile().getHomes()));
    dto.setId(user.getId());
    dto.setEmail(user.getEmail());
    dto.setFirstName(user.getFirstName());
    dto.setLastName(user.getFirstName());
    dto.setAvgRatingHostFromList(user.getHostProfile().getReviews());
    dto.setAvgRatingRenterFromList(user.getRenterProfile().getReviews());
    dto.setRenterReview(user.getRenterProfile().getReviews());
    dto.setHostReview(user.getHostProfile().getReviews());

    System.out.println(dto.toString());
    return dto;
  }

  public static UserCompleteProfileDTO convertToCompleteProfile(User user) {
    UserCompleteProfileDTO dto = new UserCompleteProfileDTO();
    System.out.println(user.getHostProfile().getHomes());
    dto.setHomes(HomeMapper.convertToWithBooking(user.getHostProfile().getHomes()));
    dto.setId(user.getId());
    dto.setEmail(user.getEmail());
    dto.setFirstName(user.getFirstName());
    dto.setLastName(user.getFirstName());
    dto.setAvgRatingHost(user.getHostProfile().getReviews());
    dto.setAvgRatingRenter(user.getRenterProfile().getReviews());
    dto.setRenterReview(user.getRenterProfile().getReviews());
    dto.setHostReview(user.getHostProfile().getReviews());
    dto.setMadeReviews(user.getMadeReviews());
    dto.setBookingDetails(BookingDetailMapper.convertToBookingCoreHomeDTO(user.getRenterProfile().getBookingDetails()));
    return dto;
  }


}
