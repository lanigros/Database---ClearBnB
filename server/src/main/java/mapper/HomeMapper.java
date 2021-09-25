package mapper;


import datatransforobject.HomeAddressDTO;
import datatransforobject.HomeCoreDTO;
import datatransforobject.HomeCoreNoHostDTO;
import datatransforobject.HomeHistoryDTO;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import model.Amenity;
import model.Home;
import model.HomeHistoryLog;
import model.HomeImage;
import model.Host;
import utility.AmenityEnumConverter;

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
    dto.setAmenities(historyLog.getAmenities());

    return dto;

  }

  public static Home convertToHome(HomeAddressDTO dto, Host host) {
    Home home = new Home();
    home.setPricePerNight(dto.getPricePerNight());
    home.setStartDate(dto.getStartDate());
    home.setEndDate(dto.getEndDate());
    home.setHost(host);
    List<Amenity> amenities = amenityEnumConverter.getAmenitiesAsAmenityList(dto.getAmenities(),
        home);
    List<HomeImage> homeImages = HomeImageMapper.convertToHomeImages(dto.getImages(), home);
    home.setAmenities(amenities);
    home.setImages(homeImages);
    home.setCreatedDate(new Timestamp(Instant.now().toEpochMilli()));
    return home;

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

  public static HomeHistoryLog convertHistory(Home home) {
    HomeHistoryLog homeHistory = new HomeHistoryLog();
    homeHistory.setHome(home);
    homeHistory.setPricePerNight(home.getPricePerNight());
    homeHistory.setStartDate(home.getStartDate());
    homeHistory.setEndDate(home.getEndDate());
    homeHistory.setImages(HomeImageMapper.convertToHistory(home.getImages(), homeHistory));
    homeHistory.setAmenities(AmenityMapper.convertToHistory(home.getAmenities(), homeHistory));

    return homeHistory;

  }

}
