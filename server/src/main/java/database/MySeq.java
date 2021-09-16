//Behövs denna klassen?
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySeq {

  private static Connection con = null;

  //singelton instance
  static {
    String url = "jdbc:mysql://localhost:3306/db_mysql";
    String user = "alex";
    String pass = "banan123";
    try {

      con = DriverManager.getConnection(url, user, pass);
      System.out.println("MySQL connections established");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    return con;
  }
}



