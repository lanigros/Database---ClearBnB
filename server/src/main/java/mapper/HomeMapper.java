package mapper;


import datatransforobject.HomeAddressDTO;
import datatransforobject.HomeCoreDTO;
import datatransforobject.HomeHistoryDTO;
import java.util.ArrayList;
import java.util.List;
import model.Amenity;
import utility.AmenityEnumConverter;
import model.Home;
import model.HomeHistoryLog;
import model.Host;

public class HomeMapper {
  private static final AmenityEnumConverter amenityEnumConverter = new AmenityEnumConverter();

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

    return dto;

  }

  public static Home convertToHome(HomeAddressDTO dto, Host host){
    Home home = new Home();
    home.setPricePerNight(dto.getPricePerNight());
    home.setStartDate(dto.getStartDate());
    home.setEndDate(dto.getEndDate());
    home.setHost(host);
    List<String> amenityStrings =  dto.getAmenities();
    List<Amenity> amenities = amenityEnumConverter.getAmenitiesAsAmenityList(amenityStrings, home);
    home.setAmenities(amenities);
    return home;
  }

}
