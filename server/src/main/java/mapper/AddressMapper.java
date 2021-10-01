package mapper;

import datatransforobject.HomeAddressDTO;
import java.util.List;
import model.Address;
import model.Home;

public class AddressMapper {

  public static Address convertToAddress(HomeAddressDTO dto, Home home){
    Address address = new Address();
    address.setCity(dto.getCity());
    address.setCountry(dto.getCountry());
    address.setStreet(dto.getStreet());
    address.setZipCode(dto.getZipCode());
    address.setHomes(home);
    return address;

  }

}
