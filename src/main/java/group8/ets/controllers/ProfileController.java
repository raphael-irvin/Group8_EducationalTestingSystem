package group8.ets.controllers;

import group8.ets.MainApp;
import group8.ets.Session;
import group8.ets.quizmaterials.QuizSession;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * This screen shows my profile name, a simple average score,
 * and a short list of quiz history entries.
 */
public class ProfileController {

    @FXML
    private Label profileNameLabel;   // shows the profile name at the top

    @FXML
    private Label avgScoreLabel;      // shows my average score

    @FXML
    private VBox topicsBox;           // container for topic history buttons

    @FXML
    private void initialize() {
        // Initialize Profile Name
        profileNameLabel.setText("Profile: " + Session.getInstance().getLoggedInStudent().getName());

        // I calculate a very simple average over all history entries.
        if (Session.getInstance().getLoggedInStudent().getTakenQuizzes().isEmpty()) {
            avgScoreLabel.setText("Avg Score: --%");
        } else {
            double sum = 0;
            for (QuizSession quizSession : Session.getInstance().getLoggedInStudent().getTakenQuizzes()) {
                sum += quizSession.getReportSummary().getScorePercentage();
            }
            double avg = Math.round(sum / Session.getInstance().getLoggedInStudent().getTakenQuizzes().size());
            avgScoreLabel.setText("Avg Score: " + avg + "%");
        }

        // I build the history list dynamically from QuizSession.quizHistory.
        topicsBox.getChildren().clear();

        if (Session.getInstance().getLoggedInStudent().getTakenQuizzes().isEmpty()) {
            // No attempts yet – I show a simple placeholder label.
            Label empty = new Label("No quiz attempts yet.");
            empty.setStyle("-fx-text-fill: #666666;");
            topicsBox.getChildren().add(empty);
        } else {
            for (QuizSession quizSession : Session.getInstance().getLoggedInStudent().getTakenQuizzes()) {
                String quizID = quizSession.getSessionId();
                Button btn = new Button(quizSession.getSelectedTopic().getTopicName());
                btn.setMaxWidth(Double.MAX_VALUE);
                btn.setPrefWidth(259.0);
                btn.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 5; -fx-border-color: #204A87;");

                // When I click a history item, I open the QuizHistory screen.
                btn.setOnAction(e -> openHistory(quizID));

                topicsBox.getChildren().add(btn);
            }
        }
    }

    // I store the selected history index and navigate to QuizHistory.
    private void openHistory(String quizID) {
        try {
            QuizHistoryController.currentSelectedSessionID = quizID;
            MainApp.switchScene("QuizHistory.fxml", "Quiz History");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleGoToHome() throws Exception {
        // Go back to the home (quiz selection) screen.
        MainApp.switchScene("Home.fxml", "Home");
    }

    @FXML
    private void handleSignOut() throws Exception {
        // Log out and go back to the login screen.
        MainApp.switchScene("Login.fxml", "Login");
    }
}
