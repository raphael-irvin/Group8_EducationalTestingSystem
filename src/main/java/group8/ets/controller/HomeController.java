package group8.ets.controller;

import group8.ets.MainApp;
import group8.ets.Utility;
import group8.ets.database.TopicDatabase;
import group8.ets.quizmaterials.topicandquestions.Topic;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import jdk.jshell.execution.Util;

import javax.swing.*;

public class HomeController extends Controller{

    @FXML
    private VBox topicsContainer;

    @FXML
    private void initialize() {
        Utility.log("Initializing HomeController and loading topics...");
        topicsContainer.getChildren().clear();

        for (Topic topic : TopicDatabase.getInstance().getAll()) {
            Button btn = new Button(topic.getTopicName());
            btn.setPrefWidth(259.0);
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setStyle(
                    "-fx-background-color: #f0f0f0; " +
                            "-fx-padding: 5; " +
                            "-fx-border-color: #204A87;"
            );

            btn.setOnAction(e -> handleSelectTopic());
            topicsContainer.getChildren().add(btn);
        }
    }

    @FXML
    private void handleSelectTopic() {
        MainApp.switchScene("SelectQuiz.fxml", "Select Quiz");
    }

    @FXML
    private void handleGoToProfile() {
        MainApp.switchScene("Profile.fxml", "Profile");
    }

    @FXML
    private void handleSignOut() {
        MainApp.switchScene("Login.fxml", "Login");
    }
}
