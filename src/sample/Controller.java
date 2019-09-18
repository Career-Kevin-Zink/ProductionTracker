package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label lblName;

    @FXML
    private Button AddProductButton;

    @FXML
    private Button RecordProductionButton;

    @FXML
    void AddProductBtnPushed(ActionEvent event) {
    System.out.println("AddProduct");
    }

    @FXML
    void recordProductionButtonPushed(ActionEvent event) {
    System.out.println("product Recorded");
    }

}
