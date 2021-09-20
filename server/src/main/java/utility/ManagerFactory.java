package utility;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory {

  public static EntityManagerFactory getEntityManagerFactory(String entity) {
    return Persistence.createEntityManagerFactory(entity, getProperties());
  }

  private static Map<String, String> getProperties() {
    Dotenv dotenv = Dotenv.load();
    Map<String, String> result = new HashMap<>();

    // Read the properties from a file instead of hard-coding it here.
    // Or pass the password in from the command-line.
    result.put("javax.persistence.jdbc.password", dotenv.get("PASSWORD"));

    return result;
  }

}
