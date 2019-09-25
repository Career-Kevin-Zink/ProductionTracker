package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

/**
 * @author Kevin Zink
 */
public class Main extends Application {
    /**
     * The starting point of a javaFX program.
     *
     * @param primaryStage The first thing the user sees, primary stage of the javaFX app.
     * @throws Exception Throws an exception.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Production Tracker");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
                (Main.class.getResource("styleSheet.css").toExternalForm());
        primaryStage.show();

    }

    public static void queryier(String sql) {
        System.out.println(sql);
        final String JDBC_DRIVER = "org.h2.Driver"; // org.sqlite.JDBC for H2
        final String DB_URL = "jdbc:h2:./res/PTI";  //  this replaces the h2 with sqlite (or whatver else.)
        final String USER = "";// API keys ? hehe
        final String PASS = "";// don't publish database pass to github
        try {
            Class.forName(JDBC_DRIVER); // registering my database, JDBC_ DRIVER SQLITE_DRIVER
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
