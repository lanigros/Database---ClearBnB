package mapper;

import datatransforobject.HomeCoreDTO;
import datatransforobject.HomeCoreNoHostDTO;
import datatransforobject.HomeHistoryDTO;
import java.util.ArrayList;
import java.util.List;
import model.Home;
import model.HomeHistoryLog;

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
        dto.setAmenities(home.getAmenities());
        return dto;
    }

  public static HomeHistoryDTO convertToCore(HomeHistoryLog historyLog) {

    HomeHistoryDTO dto = new HomeHistoryDTO();
    dto.setId(historyLog.getId());
    dto.setAddress(historyLog.getHome().getAddress());
    dto.setPricePerNight(historyLog.getPricePerNight());
    dto.setImages(historyLog.getImages());
    dto.setStartDate(historyLog.getStartDate());
    dto.setEndDate(historyLog.getEndDate());
    dto.setCreatedDate(historyLog.getCreatedDate());
    dto.setAmenities(historyLog.getAmenities());

    return dto;

  }

  public static List<HomeCoreNoHostDTO> convertToNoHost(List<Home> homes) {
    List<HomeCoreNoHostDTO> list = new ArrayList<>();

    homes.forEach(home -> {
      HomeCoreNoHostDTO dto = new HomeCoreNoHostDTO();
      dto.setAddress(home.getAddress());
      dto.setAmenities(home.getAmenities());
      dto.setId(home.getId());
      dto.setImages(home.getImages());
      dto.setCreatedDate(home.getCreatedDate());
      dto.setEndDate(home.getEndDate());
      dto.setStartDate(home.getStartDate());
      dto.setPricePerNight(home.getPricePerNight());
      list.add(dto);
    });

    return list;

  }

}
