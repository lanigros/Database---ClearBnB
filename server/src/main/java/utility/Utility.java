package utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

  static final SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");

  public static boolean match(String password, String hashedPassword) {
    return hash(password).equals(hashedPassword);
  }

  public static String hash(String password) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA3-256");
      byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
      return bytesToHex(hash);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder(2 * hash.length);
    for (byte b : hash) {
      String hex = Integer.toHexString(0xff & b);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    return hexString.toString();
  }

  public static Timestamp convertToTimestamp(String date) throws ParseException {
    Date a = formatter.parse(date);
    return new Timestamp(a.getTime());
  }

}
