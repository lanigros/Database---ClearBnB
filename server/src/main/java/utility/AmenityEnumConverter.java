package utility;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import model.Amenity;
import model.Amenity.AmenityEnum;
import model.Home;

@Converter(autoApply = true)
public class AmenityEnumConverter implements AttributeConverter<AmenityEnum, String> {

    @Override
    public String convertToDatabaseColumn(AmenityEnum amenities) {
        return amenities.toString();
    }

    @Override
    public AmenityEnum convertToEntityAttribute(String s) {

        if(s == null){
            return AmenityEnum.NULL;
        }

        return switch (s) {
            case "WIFI" -> AmenityEnum.WIFI;
            case "KITCHEN" -> AmenityEnum.KITCHEN;
            case "PARKING" -> AmenityEnum.PARKING;
            case "BATH" -> AmenityEnum.BATH;
            default -> null;
        };

    }

    public List<Amenity> getAmenitiesAsAmenityList(List<String> amenityStrings, Home home){
        List<Amenity>amenities = new ArrayList<>();
        for(int i = 0; i < amenityStrings.size(); i++){
            AmenityEnum amenityEnum = this.convertToEntityAttribute(amenityStrings.get(i));
            Amenity amenity = new Amenity();
            amenity.setAmenity(amenityEnum);
            amenity.setHome(home);
            amenities.add(amenity);
        }
        return amenities;
    }

}