package io.github.zinkmk.product;

import java.util.Date;

public class ProductionRecord {
  private int productionNumber;
  private int productID;
  private String SerialNumber;
  private String dateProduced;
  private static int itemCount = 0;

  public ProductionRecord( // constructor for loading previous PR's
      int productionNumber, int productID, String serialNumber, String dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    SerialNumber = serialNumber;
    this.dateProduced = dateProduced;
    itemCount++;
  }
  // Todo: form serial number.
  public ProductionRecord(Product product) { // constructor for making a new PR
    productID = product.getId();
    dateProduced = new Date().toString();
    SerialNumber =
        product.getManufacturer().substring(0, 3)
            + product.getType().name()
            + String.format("%05d", itemCount); // serial numbers funzies, substring helps a lot.
    itemCount++;
  }

  public int getProductionNumber() {
    return productionNumber;
  } //  >>>>> start getters and setters

  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public String getSerialNumber() {
    return SerialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    SerialNumber = serialNumber;
  }

  public String getDateProduced() {
    return dateProduced;
  }
  // >>>> END getters and setters

  public void setDateProduced(String dateProduced) { // >>>> end getters and setters
    this.dateProduced = dateProduced;
  }
  // "Prod. Num: 0 Product ID: 0 Serial Num: 0 Date: Mon Oct 14 10:29:48 UTC 2019"
  public String toString() { //  toString
    return "Prod. Num: "
        + productionNumber
        + " Production ID: "
        + productID
        + " Serial Num: "
        + SerialNumber
        + " Date: "
        + dateProduced;
  }
}
