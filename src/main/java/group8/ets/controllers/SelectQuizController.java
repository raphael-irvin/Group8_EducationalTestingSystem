package group8.ets.controllers;

import group8.ets.MainApp;
import group8.ets.Session;
import group8.ets.databases.TopicDatabase;
import group8.ets.quizmaterials.topicandquestions.Topic;
import group8.ets.services.QuizService;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class SelectQuizController {

    @FXML
    private VBox topicsContainer;          // left list of topics

    @FXML
    private Label topicTitleLabel;         // selected topic title

    @FXML
    private Label topicDescLabel;          // selected topic description

    @FXML
    private ChoiceBox<String> difficultyChoiceBox;  // Easy / Medium / Hard

    @FXML
    private void initialize() {
        // Load difficulty options
        difficultyChoiceBox.getItems().addAll("Easy", "Medium", "Hard");
        difficultyChoiceBox.setValue("Easy");

        // Build the list of topics dynamically from TopicDatabase
        topicsContainer.getChildren().clear();

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

            btn.setOnAction(e -> selectTopic(topic, btn));
            topicsContainer.getChildren().add(btn);
        }

        // Select the first topic by default
        if (!TopicDatabase.getInstance().getAll().isEmpty() && !topicsContainer.getChildren().isEmpty()) {
            selectTopic(TopicDatabase.getInstance().getAll().getFirst(), (Button) topicsContainer.getChildren().getFirst());
        }
    }

    // Updates the selected topic details and highlights the selected button
    private void selectTopic(Topic topic, Button clickedButton) {

        topicTitleLabel.setText(topic.getTopicName());
        topicDescLabel.setText(topic.getDescription());

        // I highlight the selected button
        for (Node node : topicsContainer.getChildren()) {
            if (node instanceof Button b) {
                if (b == clickedButton) {
                    b.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 5; "
                            + "-fx-border-color: #38ac1b; -fx-border-width: 1.2;");
                } else {
                    b.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 5; "
                            + "-fx-border-color: #204A87;");
                }
            }
        }
    }

    @FXML
    private void handleStartQuiz() throws Exception {
        // TODO: Pass selectedTopic and difficulty to current quiz session
        // Translate Difficulty Value to Integer (Easy = 1, Medium = 2, Hard = 3)
        int difficultyLevel;

        if (difficultyChoiceBox.getValue() == null) {
            // Default to Easy if no selection
            difficultyChoiceBox.setValue("Easy");
        }

        if (Objects.equals(difficultyChoiceBox.getValue(), "Easy")) {
            difficultyLevel = 1;
        } else if (Objects.equals(difficultyChoiceBox.getValue(), "Medium")) {
            difficultyLevel = 2;
        } else {
            difficultyLevel = 3;
        }

        Session.getInstance().setCurrentQuizSession(QuizService.getInstance().startQuizSession(Session.getInstance().getLoggedInStudent(),
                TopicDatabase.getInstance().getTopicByName(topicTitleLabel.getText()),
                difficultyLevel));

        MainApp.switchScene("Quiz.fxml", "Quiz");
    }

    @FXML
    private void handleGoToHome() throws Exception {
        MainApp.switchScene("Home.fxml", "Home");
    }

    @FXML
    private void handleGoToProfile() throws Exception {
        MainApp.switchScene("Profile.fxml", "Profile");
    }

    @FXML
    private void handleSignOut() throws Exception {
        Session.getInstance().clearSession();
        MainApp.switchScene("Login.fxml", "Login");
    }
}
