package mapper;


import datatransferobject.HostBasicDTO;
import model.Host;

public class HostMapper {

  public static HostBasicDTO convertToHostBasic(Host host) {
    HostBasicDTO dto = new HostBasicDTO();
    dto.setFullName(host.getUser().getFirstName(), host.getUser().getLastName());
    dto.setUserID(host.getUser().getId());
    dto.setAvgRating(host.getReviews());
    return dto;

  }

}
