package be.pxl.ja2.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BeerInformationApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/beer_information.fxml"));
        Scene scene = new Scene(root, 580, 450);
        primaryStage.setTitle("Demo...");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
