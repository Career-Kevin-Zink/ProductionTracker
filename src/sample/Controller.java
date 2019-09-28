package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    /** Method that is called when the program launches which initializes some default values. */
    public void initialize() {
        QtyComboBox.setItems(
                FXCollections.observableArrayList("1",
                        "2","3", "4", "5", "6", "7", "8", "9", "10"));
        QtyComboBox.setEditable(true);
        QtyComboBox.getSelectionModel().selectFirst();
    }
    @FXML
    private TextField productNameTxtInp;

    @FXML
    private TextField manTxtInp;

    @FXML
    private Label lblName;

    @FXML
    private Button AddProductButton;

    @FXML
    private ComboBox<String> QtyComboBox;

    @FXML
    private Button RecordProductionButton;

    @FXML
    void AddProductBtnPushed(ActionEvent event) {
        Main.queryier(" INSERT INTO Product(type, manufacturer, name) VALUES ('AUDIO','" + manTxtInp.getText() + "','" + productNameTxtInp.getText() + "' ) ");
    }

    @FXML
    void recordProductionButtonPushed(ActionEvent event) {
        System.out.println("product Recorded");
    }

}
