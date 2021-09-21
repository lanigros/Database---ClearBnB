package mapper;


import datatransforobject.HomeCoreDTO;
import model.Home;

public class HomeMapper {

  public static HomeCoreDTO convertToCore(Home home) {
    System.out.println(home.getHost());
    HomeCoreDTO dto = new HomeCoreDTO();
    dto.setId(home.getId());
    dto.setAddress(home.getAddress());
    dto.setHost(HostMapper.convertToHostBasic(home.getHost()));
    dto.setPricePerNight(home.getPricePerNight());
    dto.setImages(home.getImages());
    dto.setStartDate(home.getStartDate());
    dto.setEndDate(home.getEndDate());
    dto.setCreatedDate(home.getCreatedDate());
    return dto;

  }

}
