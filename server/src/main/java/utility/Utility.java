package utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.Cookie;
import service.ActiveSessionService;

public class Utility {
  static final SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
  private static Random random = new Random();

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

  public static String createRandomAlphanumeric() {
    // code from https://www.baeldung.com/java-random-string
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 50;

    String generatedString = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

    System.out.println(generatedString);
    return generatedString;
  }

  public static Cookie generateCookie(String cookieName, String cookieValue) {

    Cookie cookie = new Cookie(cookieName, cookieValue);
    cookie.setMaxAge(800000);
    return cookie;
  }

  public static Cookie generateCookie(String cookieName, String cookieValue, int maxAge) {
    Cookie cookie = generateCookie(cookieName, cookieValue);
    cookie.setMaxAge(maxAge);
    return cookie;
  }

  public static Timestamp convertToTimestamp(String date) throws ParseException {
    Date a = formatter.parse(date);
    return new Timestamp(a.getTime());
  }

}
