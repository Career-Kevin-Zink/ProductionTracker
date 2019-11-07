package io.github.zinkmk.product;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** @author Kevin Zink */
public class Main extends Application {
  /**
   * The starting point of a javaFX program.
   *
   * @param primaryStage The first thing the user sees, primary stage of the javaFX app.
   * @throws Exception Throws an exception.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ProductTabs.fxml"));
    primaryStage.setTitle("Production Tracker");
    Scene scene = new Scene(root, 600, 400);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(Main.class.getResource("styleSheet.css").toExternalForm());
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
