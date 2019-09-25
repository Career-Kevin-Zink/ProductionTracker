package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField productNameTxtInp;

    @FXML
    private TextField manTxtInp;

    @FXML
    private Label lblName;

    @FXML
    private Button AddProductButton;

    @FXML
    private Button RecordProductionButton;

    @FXML
    void AddProductBtnPushed(ActionEvent event) {
        Main.queryier(" INSERT INTO Product(type, manufacturer, name) VALUES ('AUDIO','" +  manTxtInp.getText() + "','" + productNameTxtInp.getText() + "' ) ");
    }

    @FXML
    void recordProductionButtonPushed(ActionEvent event) {
        System.out.println("product Recorded");
    }

}
