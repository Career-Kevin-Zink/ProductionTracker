package io.github.zinkmk.product;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Kevin Zink This is the controller for my FXML page It takes all of the FX id's and puts
 * them into codes It also contains code for when I press the Buttons in the scene. Basically it
 * lets you control ProductTabs.fxml
 */
public class ProductTabsController {
    private final ArrayList<Product> products = new ArrayList<>();
    @FXML
    private ChoiceBox<ItemType> itemType;
    @FXML
    private TextField productNameTxtInp;
    @FXML
    private TextField manTxtInp;
    @FXML
    private Label lblName;
    @FXML
    private Button AddProductButton;
    @FXML
    private ComboBox<String> QtyComboBox; // change ? to String
    @FXML
    private TextArea ProdLogView;
    @FXML
    private Button RecordProductionButton;
    @FXML
    private ListView<String> chooseProductsLV;
    @FXML
    private TextField nameTxtField;
    @FXML
    private TextField passTxtField;
    @FXML
    private TextArea displayTxtArea;
    @FXML
    private Button submitButton;
    @FXML
    private TableView<Product> existingProductsTableView;

    @FXML
    /**
     * Checks for empty fields then makes a product and saves it to the database, it also populates
     * the table view with it.
     */
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

        Widget wgt =
                new Widget(0, itemType.getValue(), manTxtInp.getText(), productNameTxtInp.getText());

        existingProductsTableView.getItems().add(wgt);
        DBManager.saveProduct(
                wgt,
                QtyComboBox.getValue()); // making a new product object); // saving product to the database
    }

    @FXML
    /**
     * Method to check for empty text fields and then make an object with the given fields when the
     * button is pushed.
     */
    void submitButtonPushed(ActionEvent event) {
        if (nameTxtField.getText().isEmpty()) System.out.println("Name cannot be empty!");
        if (passTxtField.getText().isEmpty()) System.out.println("Password cannot be empty!");

        Employee emp = new Employee(nameTxtField.getText(), passTxtField.getText());
        displayTxtArea.setText(emp.toString());
    }

    @FXML
    /**
     * Method called when the "record" button is pushed. Takes the selected List View item and it's
     * information, then saves it to the production log.
     */
    void recordProductionButtonPushed(
            ActionEvent event) { // execute when we push the the linked button.

        Product product =
                products.get(
                        chooseProductsLV
                                .getSelectionModel()
                                .getSelectedIndex()); // gets all the old products ?????
        ProductionRecord pr = new ProductionRecord(product); // makes a new PR object
        DBManager.saveProductionRecord(pr); // saving pr to database
        ProdLogView.appendText(
                "\n"
                        + pr.toString()
                        + " Quantity = "
                        + QtyComboBox.getValue()); // output to production log view in fxml
    }

    /**
     * Method that is called when the program launches which initializes some default values.
     */
    public void initialize() throws SQLException {

        ResultSet allProducts = DBManager.loadProducts();
        /** If / while loop checking for products first, then loading them one by one. */
        if (allProducts != null) {
            while (allProducts.next()) {
                Product temp = null;
                /** Switch statement to differentiate between the ItemType's */
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
                    case "VisualMobile":
                        temp =
                                new Widget(
                                        allProducts.getInt(1),
                                        ItemType.VM,
                                        allProducts.getString(4),
                                        allProducts.getString(2));
                        products.add(temp);
                        break;
                    case "AudioMobile":
                        temp =
                                new Widget(
                                        allProducts.getInt(1),
                                        ItemType.AM,
                                        allProducts.getString(4),
                                        allProducts.getString(2));
                        products.add(temp);
                        break;
                }
                /**
                 * Populates the List view on the "Produce" tab, Also loads the products into the table in
                 * "Product Line"
                 */
                chooseProductsLV
                        .getItems()
                        .add(
                                String.format(
                                        "%s %s", allProducts.getString("MANUFACTURER"), allProducts.getString("NAME")));
                existingProductsTableView.getItems().add(temp);
            }
            allProducts.close();
        }
        /** Same shenanigans as the last one, but for ProductionRecords instead of products. */
        ResultSet allProductionRecords = DBManager.loadProductionRecords();
        if (allProducts != null) {
            assert allProductionRecords != null;
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
                        "2", "3", "4", "5", "6", "7", "8", "9", "10", "100",
                        "1000")); // change combo box into > String instead of ?
        QtyComboBox.setEditable(true);
        QtyComboBox.getSelectionModel().selectFirst();

        // it adds the various item types to the ItemType combobox on Product Line
        for (ItemType type : ItemType.values()) {
            itemType.getItems().add(type);
        }
        itemType.getSelectionModel().selectFirst();
        chooseProductsLV.getSelectionModel().selectFirst();
        // </editor-fold>
    }
}
