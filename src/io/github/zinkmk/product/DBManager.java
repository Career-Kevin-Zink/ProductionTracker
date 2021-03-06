package io.github.zinkmk.product;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Kevin Zink This is the class I use for managing the database. It basically has all of the
 * load / save methods in it so they're all in one nice consice place.
 */
class DBManager {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:./res/PTI";

    /**
     * Method for saving products to database.
     *
     * @param product     The product to be saved.
     * @param QtyComboBox Uses the quantity in the combo box in the FXML to save the qty to the
     *                    database
     */
    public static void saveProduct(Product product, String QtyComboBox) {
        try { // try / catch so we don't error out.
            Properties prop = new Properties();
            prop.load(new FileInputStream("./res/properties"));
            String PASS = prop.getProperty("password");
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, "", PASS);
            PreparedStatement statement =
                    conn.prepareStatement(
                            "INSERT INTO Product (NAME, TYPE, MANUFACTURER, QTY)"
                                    + "VALUES (?,?,?,?)", // specifically into this area with these values
                            PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getType().getValue());
            statement.setString(3, product.getManufacturer());
            statement.setString(4, QtyComboBox);

            // Execute update
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            // Create an Obj using the generated key
            while (rs.next()) {
                product.setId(rs.getInt(1));
                System.out.println(product.toString());
            }

            rs.close(); // closing RS
            statement.close(); // PreparedStatement closed
            conn.close(); // connection closed
        } catch (Exception ex) { // and we need to end our try/catch
            ex.printStackTrace();
        }
    }

    /**
     * Method for loading products from database.
     *
     * @return ResultSet containing all products.
     */
    public static ResultSet loadProducts() { // Function to load a product from the database
        System.out.println("Connecting to database..");
        try { // try/catch to not error out
            Properties prop = new Properties();
            prop.load(new FileInputStream("./res/properties"));
            String PASS = prop.getProperty("password");
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, "", "SonSat1200");
            Statement stmt = conn.createStatement();
            ResultSet rs =
                    stmt.executeQuery(
                            "SELECT * FROM PRODUCT"); // our statement is loaded from the RS from this area
            System.out.println("Connection successful!");
            return rs; // returns our info
        } catch (Exception ex) { // ending our try/catch
            ex.printStackTrace();
            //      Alert a = new Alert.AlertType(Error);
        }
        return null; // if we trigger the try catch gotta still return something, so nothing works.
    }

    /**
     * Method to load production records from database.
     *
     * @return ResultSet containing all production records.
     */
    public static ResultSet loadProductionRecords() { // Here we're loading our production records
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("./res/properties"));
            String PASS = prop.getProperty("password");
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, "", PASS);
            Statement stmt =
                    conn.createStatement(); // most of it's the same code as before just for a diff part
            return stmt.executeQuery("SELECT * FROM PRODUCTIONRECORD"); // of the database.
        } catch (Exception ex) { // and prepared statements go with saves.
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Method for saving production records to the database.
     *
     * @param productionRecord Production record in need of saving.
     */
    public static void saveProductionRecord(
            ProductionRecord productionRecord) { // and here we save our PR's
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("./res/properties"));
            String PASS = prop.getProperty("password");
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, "", PASS);
            PreparedStatement statement =
                    conn.prepareStatement(
                            "INSERT INTO ProductionRecord (PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED)"
                                    + "VALUES (?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setInt(1, productionRecord.getProductID());
            statement.setString(2, productionRecord.getSerialNumber());
            statement.setString(3, productionRecord.getDateProduced());
            // Execute update
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            // Create an Obj using the generated key
            while (rs.next()) {
                productionRecord.setProductionNumber(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
