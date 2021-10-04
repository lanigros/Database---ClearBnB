package mapper;

import java.util.ArrayList;
import java.util.List;
import model.Amenity;
import model.AmenityHistory;
import model.HomeHistoryLog;

public class AmenityMapper {

  public static List<AmenityHistory> convertToHistory(List<Amenity> amenities,
      HomeHistoryLog homeHistory) {
    List<AmenityHistory> list = new ArrayList<>();
    for (Amenity am : amenities) {
      AmenityHistory amenityHistory = new AmenityHistory(
          homeHistory,
          am.getAmenity()
      );
      list.add(amenityHistory);
    }

    return list;
  }

}
