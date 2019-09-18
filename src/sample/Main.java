package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Kevin Zink
 * @brief
 */
public class Main extends Application {
  /**
   * The starting point of a javaFX program.
   *
   * @param primaryStage the first thing the use sees, primary stage of the javaFX app
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
    String str = "string";
    String substr = str.substring(0);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
