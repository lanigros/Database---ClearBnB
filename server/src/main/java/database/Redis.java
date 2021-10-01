package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import redis.clients.jedis.Jedis;

public class Redis {

  private static Jedis redis = null;

  //singelton instance
  static {
    String uri = "localhost";
    int port = 6379;

    try {
      redis = new Jedis(uri,port);
      System.out.println("Redis connections established");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Jedis getConnection() {
    return redis;
  }

}
