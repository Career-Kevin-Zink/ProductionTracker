package io.github.zinkmk.product;

import java.util.Date;

/**
 * @author Kevin Zink This makes a production record, it's main use is to help generate the Serial
 * Number in the product log.
 */
class ProductionRecord {
    private int productionNumber;
    private int productID;
    private String SerialNumber;
    private String dateProduced;
    private static int itemCount = 0;

    /**
     * constructor for loading previous PR's, we pass a product object from the database and it can
     * fill all the parameters.
     *
     * @param productionNumber We load this from the database.
     * @param productID        We load this from the database.
     * @param serialNumber     We load this from the database.
     * @param dateProduced     We load this from the database.
     */
    public ProductionRecord(
            int productionNumber, int productID, String serialNumber, String dateProduced) {
        this.productionNumber = productionNumber;
        this.productID = productID;
        SerialNumber = serialNumber;
        this.dateProduced = dateProduced;
        itemCount++;
    }

    /**
     * constructor for making a new PR we pass an object to it and the object has all the data needed.
     *
     * @param product the product object we use to get our data.
     */
    public ProductionRecord(Product product) {
        productID = product.getId();
        dateProduced = new Date().toString();
        SerialNumber =
                product.getManufacturer().substring(0, 3)
                        + product.getType().name()
                        + String.format("%05d", itemCount); // serial numbers fun, substring helps a lot.
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
