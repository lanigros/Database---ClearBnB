package mapper;

import java.util.ArrayList;
import java.util.List;
import model.Home;
import model.HomeImage;

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

}
