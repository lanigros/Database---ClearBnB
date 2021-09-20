package utility;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import model.Amenity;
import model.Amenity.AMENITY_ENUM;

public class AmenityConverter implements AttributeConverter<Amenity, String> {

    private static final String SEPARATOR = "\\|";

    //Convert amenity object to string
    //with format WIFI|KITCHEN|PARKING|BATH
    @Override
    public String convertToDatabaseColumn(Amenity amenity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AMENITY_ENUM.WIFI).append(SEPARATOR).append(AMENITY_ENUM.KITCHEN)
                     .append(SEPARATOR).append(AMENITY_ENUM.PARKING).append(SEPARATOR)
                     .append(AMENITY_ENUM.BATH);
        return stringBuilder.toString();
    }
    //Convert a String with format red|green|blue|alpha to an Amenity object

    @Override
    public Amenity convertToEntityAttribute(String amenity_enum) {
        String[] amenity = amenity_enum.split(SEPARATOR);
        return new Amenity(amenity);
    }

}

@Converter(autoApply = true)
public class NameAttributeConveter implements AttributeConverter<Amenity, String> {

    @Override
    public String convertToDatabaseColumn(Amenity attribute) {
        String amenities = attribute.getAmenity() == null ? "No amenities on this home" : attribute.getAmenity();
        return amenities;
    }

    @Override
    public Amenity convertToEntityAttribute(String dbData) {
        if (dbData != null && dbData.split(" ").length > 0) {
            Amenity amenity = new Amenity();
            amenity.setAmenity(dbData.split("").length > 0);
            return amenity;
        }
        return null;
    }

}
