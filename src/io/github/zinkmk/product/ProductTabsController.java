package io.github.zinkmk.product;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductTabsController {
  ArrayList<Product> products = new ArrayList<>();
  @FXML private ChoiceBox<ItemType> itemType;
  @FXML private TextField productNameTxtInp;
  @FXML private TextField manTxtInp;
  @FXML private Label lblName;
  @FXML private Button AddProductButton;
  @FXML private ComboBox<String> QtyComboBox; // change ? to String
  @FXML private TextArea ProdLogView;
  @FXML private Button RecordProductionButton;
  @FXML private ListView<String> chooseProductsLV;

  @FXML
  void AddProductBtnPushed(ActionEvent event) { // execute these things when you push this button.
    if (productNameTxtInp.getText().trim().isEmpty()) { // checking for empty text fields.
      System.out.println("No empty text fields please.");
      return;
    }
    if (manTxtInp.getText().trim().isEmpty()) {
      System.out.println(
          "No empty text fields please."); // checking for empty text fields in manufacturer
      return;
    }
    DBManager.saveProduct( // saving product to the database
        new Widget(
            0,
            itemType.getValue(),
            manTxtInp.getText(),
            productNameTxtInp.getText())); // making a new product object
  }

  @FXML
  void recordProductionButtonPushed(
      ActionEvent event) { // execute when we push the the linked button.

    Product product =
        products.get(
            chooseProductsLV
                .getSelectionModel()
                .getSelectedIndex()); // gets all the old products ?????
    ProductionRecord pr = new ProductionRecord(product); // makes a new PR object
    DBManager.saveProductionRecord(pr); // saving pr to database
    ProdLogView.appendText("\n" + pr.toString()); // output to production log view in fxml
  }

  /** Method that is called when the program launches which initializes some default values. */
  public void initialize() throws SQLException {

    ResultSet allProducts = DBManager.loadProducts();

    if (allProducts != null) {
      while (allProducts.next()) {
        Product temp = null;

        switch (allProducts.getString(3)) {
          case "Audio":
            temp =
                new Widget(
                    allProducts.getInt(1),
                    ItemType.AU,
                    allProducts.getString(4),
                    allProducts.getString(2));
            products.add(temp);
            break;
          case "Visual":
            temp =
                new Widget(
                    allProducts.getInt(1),
                    ItemType.VI,
                    allProducts.getString(4),
                    allProducts.getString(2));
            products.add(temp);
            break;
        }

        chooseProductsLV
            .getItems()
            .add(
                String.format(
                    "%s %s", allProducts.getString("MANUFACTURER"), allProducts.getString("NAME")));
      }
      allProducts.close();
    }

    ResultSet allProductionRecords = DBManager.loadProductionRecords();
    if (allProducts != null) {
      while (allProductionRecords.next()) {
        ProductionRecord pr =
            new ProductionRecord(
                allProductionRecords.getInt(1),
                allProductionRecords.getInt(2),
                allProductionRecords.getString(3),
                allProductionRecords.getString(4));
        System.out.println(pr.toString());
        ProdLogView.appendText("\n" + pr.toString());
      }
      allProductionRecords.close();
    }

    // <editor-fold desc="Initialization">
    QtyComboBox.setItems(
        FXCollections.observableArrayList(
            "1", // sets a list of items into the combo box, make sure to
            "2", "3", "4", "5", "6", "7", "8", "9",
            "10")); // change combo box into > String instead of ?
    QtyComboBox.setEditable(true);
    QtyComboBox.getSelectionModel().selectFirst();

    for (ItemType type : ItemType.values()) {
      itemType.getItems().add(type);
    }
    itemType.getSelectionModel().selectFirst();
    // </editor-fold>
  }
}
