package mapper;

import java.util.ArrayList;
import java.util.List;
import model.Home;
import model.HomeHistoryLog;
import model.HomeImage;
import model.HomeImageHistory;

public class HomeImageMapper {

  public static List<HomeImage>convertToHomeImages(List<String>imageUrls, Home home){
    List<HomeImage>homeImages = new ArrayList<>();
    for (String imageUrl : imageUrls) {
      HomeImage homeImage = new HomeImage();
      homeImage.setImageUrl(imageUrl);
      homeImage.setHome(home);
      homeImages.add(homeImage);
    }
    return homeImages;
  }

  public static List<HomeImageHistory> convertToHistory(List<HomeImage> images, HomeHistoryLog homeHistory){
    List<HomeImageHistory> list = new ArrayList<>();

    for (HomeImage img: images){
      HomeImageHistory imageHistory = new HomeImageHistory();
      imageHistory.setImageUrl(img.getImageUrl());
      imageHistory.setHomeHistoryLog(homeHistory);
      list.add(imageHistory);
    }

    return list;
  }

}
