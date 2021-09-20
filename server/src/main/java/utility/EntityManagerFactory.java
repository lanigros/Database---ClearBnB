package utility;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Persistence;

public class EntityManagerFactory {

  private EntityManagerFactory getEntityManagerFactory() {
    return Persistence.createEntityManagerFactory(getPersistenceUnitName(), getProperties());
  }

  private Map getProperties() {
    Dotenv dotenv = Dotenv.load();
    Map result = new HashMap();

    // Read the properties from a file instead of hard-coding it here.
    // Or pass the password in from the command-line.
    result.put("javax.persistence.jdbc.password", dotenv.get("PASSWORD"));

    return result;
  }

}
