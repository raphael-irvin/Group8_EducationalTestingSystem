package group8.ets.controllers;

import group8.ets.MainApp;
import group8.ets.Session;
import group8.ets.quizmaterials.QuizSession;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * This screen shows the list of quiz attempts and the details
 * (difficulty + score) of the selected attempt.
 */
public class QuizHistoryController {

    @FXML
    private Label profileNameLabel;   // shows my profile name on top

    @FXML
    private Label difficultyLabel;    // shows the difficulty of the selected attempt

    @FXML
    private Label scoreLabel;         // shows the score of the selected attempt

    @FXML
    private VBox historyBox;          // container for topic history buttons

    // I remember which index is currently selected in this screen.
    public static String currentSelectedSessionID = null;

    @FXML
    private void initialize() {
        profileNameLabel.setText("Profile: " + Session.getInstance().getLoggedInStudent().getName());

        QuizSession selectedQuizSession = Session.getInstance().getLoggedInStudent()
                .getTakenQuizzes().stream()
                .filter(qs -> qs.getSessionId().equals(currentSelectedSessionID))
                .findFirst()
                .orElse(null);

        difficultyLabel.setText("Difficulty: " + (selectedQuizSession != null ? selectedQuizSession.getDifficultyLevel() : "__"));
        scoreLabel.setText("Score: " + (selectedQuizSession != null ? selectedQuizSession.getReportSummary().getScorePercentage() + "%" : "__%"));

        // I build the history list from QuizSession.quizHistory.
        historyBox.getChildren().clear();

        if (Session.getInstance().getLoggedInStudent().getTakenQuizzes().isEmpty()) {
            Label empty = new Label("No quiz attempts yet.");
            empty.setStyle("-fx-text-fill: #666666;");
            historyBox.getChildren().add(empty);
            return;
        }

        for (QuizSession quizSession : Session.getInstance().getLoggedInStudent().getTakenQuizzes()) {
            String sessionID = quizSession.getSessionId();

            Button btn = new Button(quizSession.getSelectedTopic().getTopicName());
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setPrefWidth(259.0);
            btn.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 5; "
                    + "-fx-border-color: #000000; -fx-border-width: 0.5;");

            btn.setOnAction(e -> selectHistoryItem(sessionID, btn));

            historyBox.getChildren().add(btn);
        }
    }

    // When I pick a topic from the history list, I update the right side panel.
    private void selectHistoryItem(String sessionID, Button clickedButton) {
        currentSelectedSessionID = sessionID;
        QuizSession quizSession = Session.getInstance().getLoggedInStudent()
                .getTakenQuizzes().stream()
                .filter(qs -> qs.getSessionId().equals(sessionID))
                .findFirst()
                .orElse(null);

        difficultyLabel.setText("Difficulty: " + quizSession.getDifficultyLevel());
        scoreLabel.setText("Score: " + quizSession.getReportSummary().getScorePercentage() + "%");

        // I highlight the selected history button.
        for (var node : historyBox.getChildren()) {
            if (node instanceof Button b) {
                if (b == clickedButton) {
                    b.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 5; "
                            + "-fx-border-color: #38ac1b; -fx-border-width: 1.2;");
                } else {
                    b.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 5; "
                            + "-fx-border-color: #000000; -fx-border-width: 0.5;");
                }
            }
        }
    }

    @FXML
    private void handleGoToHome() throws Exception {
        // Go back to the home page (topic selection).
        MainApp.switchScene("Home.fxml", "Home");
    }

    @FXML
    private void handleGoToProfile() throws Exception {
        // Open the profile page.
        MainApp.switchScene("Profile.fxml", "Profile");
    }

    @FXML
    private void handleSignOut() throws Exception {
        // Log out and open the login screen.
        MainApp.switchScene("Login.fxml", "Login");
    }

    @FXML
    private void handleGoToResultQuiz() throws Exception {
        // For now I still open the last result screen only.
        if (currentSelectedSessionID != null) {
            MainApp.switchScene("ResultQuiz.fxml", "Result Quiz");
        }
    }
}
