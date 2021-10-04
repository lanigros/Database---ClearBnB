package mapper;

import datatransferobject.HomeAddressDTO;
import model.Address;
import model.Home;

public class AddressMapper {

  public static Address convertToAddress(HomeAddressDTO dto, Home home) {
    return new Address(
        dto.getCity(),
        dto.getStreet(),
        dto.getCountry(),
        dto.getZipCode(),
        home
    );

  }

}
