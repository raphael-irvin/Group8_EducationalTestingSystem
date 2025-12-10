package group8.ets.controllers;

import group8.ets.MainApp;
import group8.ets.databases.TopicDatabase;
import group8.ets.quizmaterials.topicandquestions.Topic;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SelectQuizController {

    @FXML
    private VBox topicsContainer;          // left list of topics

    @FXML
    private Label topicTitleLabel;         // selected topic title

    @FXML
    private Label topicDescLabel;          // selected topic description

    @FXML
    private ChoiceBox<String> difficultyChoiceBox;  // Easy / Medium / Hard

    private Topic selectedTopic;           // current topic I picked

    @FXML
    private void initialize() {
        // I load difficulty choices
        difficultyChoiceBox.getItems().addAll("Easy", "Medium", "Hard");
        difficultyChoiceBox.setValue("Easy");

        // I build the topic buttons from my mock topics
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

        // I select the first topic by default
        if (!TopicDatabase.getInstance().getAll().isEmpty() && !topicsContainer.getChildren().isEmpty()) {
            selectTopic(TopicDatabase.getInstance().getAll().getFirst(), (Button) topicsContainer.getChildren().get(0));
        }
    }

    // This method updates the right side when I click a topic
    private void selectTopic(Topic topic, Button clickedButton) {
        selectedTopic = topic;

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
        // I start the quiz session (title + difficulty + total questions)
        // TODO: Pass selectedTopic and difficulty to current quiz session

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
        MainApp.switchScene("Login.fxml", "Login");
    }
}
