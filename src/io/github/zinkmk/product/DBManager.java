package io.github.zinkmk.product;

import sun.security.x509.SerialNumber;

import java.sql.*;

public class DBManager {
  private static final String JDBC_DRIVER = "org.h2.Driver"; // org.sqlite.JDBC for H2
  private static final String DB_URL = "jdbc:h2:./res/PTI";

  public static void saveProduct(
      Product product) { // Function to save the product into the database.
    try { // try / catch so we don't error out.
      Class.forName(JDBC_DRIVER); // registering my database, JDBC_ DRIVER SQLITE_DRIVER
      Connection conn = DriverManager.getConnection(DB_URL);
      PreparedStatement Pstmt =
          conn.prepareStatement(
              "INSERT INTO Product (NAME, TYPE, MANUFACTURER)"
                  + "VALUES (?,?,?)", // specifically into this area with these values
              PreparedStatement.RETURN_GENERATED_KEYS);
      Pstmt.setString(1, product.getName());
      Pstmt.setString(2, product.getType().getValue());
      Pstmt.setString(3, product.getManufacturer());

      // Execute update
      Pstmt.executeUpdate();
      ResultSet rs = Pstmt.getGeneratedKeys();

      // Create an Obj using the generated key
      while (rs.next()) {
        product.setId(rs.getInt(1));
        System.out.println(product.toString());
      }

      rs.close(); // closing RS
      Pstmt.close(); // PreparedStatement closed
      conn.close(); // connection closed
    } catch (Exception ex) { // and we need to end our try/catch
      ex.printStackTrace();
    }
  }

  public static ResultSet loadProducts() { // Function to load a product from the database
    try { // try/catch to not error out
      Class.forName(JDBC_DRIVER); // registering my database, JDBC_ DRIVER SQLITE_DRIVER
      Connection conn = DriverManager.getConnection(DB_URL);
      Statement stmt = conn.createStatement();
      ResultSet rs =
          stmt.executeQuery(
              "SELECT * FROM PRODUCT"); // our statement is loaded from the RS from this area

      return rs; // returns our info
    } catch (Exception ex) { // ending our try/catch
      ex.printStackTrace();
    }
    return null; // if we trigger the try catch gotta still return something, so nothing works.
  }

  public static ResultSet loadProductionRecords() { // Here we're loading our produciton records
    try {
      Class.forName(JDBC_DRIVER); // registering my database, JDBC_ DRIVER SQLITE_DRIVER
      Connection conn = DriverManager.getConnection(DB_URL);
      Statement stmt =
          conn.createStatement(); // most of it's the same code as before just for a diff part
      ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTIONRECORD"); // of the database.
      // ProductionRecord pr = new ProductionRecord(product, SerialNumber);      //something to keep
      // in mind
      return rs; // speicifically, Statements go with loads
    } catch (Exception ex) { // and prepared statements go with saves.
      ex.printStackTrace();
    }
    return null;
  }

  public static void saveProductionRecord(
      ProductionRecord productionRecord) { // and here we save our PR's
    try {
      Class.forName(JDBC_DRIVER); // registering my database, JDBC_ DRIVER SQLITE_DRIVER
      Connection conn = DriverManager.getConnection(DB_URL);
      PreparedStatement Pstmt =
          conn.prepareStatement(
              "INSERT INTO ProductionRecord (PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED)"
                  + "VALUES (?,?,?)",
              PreparedStatement.RETURN_GENERATED_KEYS);

      Pstmt.setInt(1, productionRecord.getProductID());
      Pstmt.setString(2, productionRecord.getSerialNumber());
      Pstmt.setString(3, productionRecord.getDateProduced().toString());
      // Execute update
      Pstmt.executeUpdate();
      ResultSet rs = Pstmt.getGeneratedKeys();

      // Create an Obj using the generated key
      while (rs.next()) {
        productionRecord.setProductionNumber(rs.getInt(1));
      }
    } catch (Exception e) {

    }
  }
}
