package group8.ets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        Utility.log("Application started. Loading main scene...");
        MainApp.primaryStage = stage;
        switchScene("Login.fxml", "Login");
    }

    public static void switchScene(String fxmlFile, String title) {
        try {
            URL fxmlLocation = MainApp.class.getResource("/" + fxmlFile);
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();
            Utility.log("Switched to scene: " + title);
        } catch (Exception e) {
            Utility.log("Error switching scene: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Utility.log("Performing initialization tasks...");
        Initialize.init();
        Utility.log("Launching application...");
        launch(args);
    }
}
