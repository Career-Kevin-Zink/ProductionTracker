package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

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

        public static void queryier(String sql) {
            System.out.println(sql);
        final String JDBC_DRIVER = "org.h2.Driver"; // org.sqlite.JDBC for H2
        final String DB_URL = "jdbc:h2:./res/PTI";  //  this replaces the h2 with sqlite (or whatver else.)

        final String USER = "";// API keys ? hehe
        final String PASS = "";// don't publish database pass to github


        Connection conn = null;  //init conect, opens the database -- Connection = class conn = object
        Statement stmt = null; //

        try {
            Class.forName(JDBC_DRIVER); // registering my database, JDBC_ DRIVER SQLITE_DRIVER

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

             //

       stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public static void main(String[] args) {
        launch(args);



    }
}
