package utility;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import model.Amenity.AmenityEnum;

@Converter(autoApply = true)
public class AmenityConverter implements AttributeConverter<AmenityEnum, String> {

    @Override
    public String convertToDatabaseColumn(AmenityEnum amenities) {
        return amenities.toString();
    }

    @Override
    public AmenityEnum convertToEntityAttribute(String s) {
        switch (s) {
            case "WIFI":
                return AmenityEnum.WIFI;
            case "KITCHEN":
                return AmenityEnum.KITCHEN;
            case "PARKING":
                return AmenityEnum.PARKING;
            case "BATH":
                return AmenityEnum.BATH;
            default:
                return null;
        }
    }

}