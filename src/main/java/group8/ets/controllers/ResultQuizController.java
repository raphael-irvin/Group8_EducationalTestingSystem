package group8.ets.controllers;

import group8.ets.MainApp;
import group8.ets.Session;
import group8.ets.quizmaterials.QuizSession;
import group8.ets.quizmaterials.topicandquestions.Question;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * This screen shows the result of the last quiz I took:
 * difficulty, score, feedback, and the list of questions.
 */
public class ResultQuizController {

    // Store QuizSession being accessed
    private final QuizSession currentQuizSession = Session.getInstance().getCurrentQuizSession();

    @FXML
    private VBox reviewBox;        // center: list of questions + answers

    @FXML
    private Label difficultyLabel; // "Difficulty: Easy / Medium / Hard"

    @FXML
    private Label scoreLabel;      // "Score: 80%"

    @FXML
    private Label feedbackLabel;   // short feedback text

    @FXML
    private void initialize() {
        // I show the difficulty and score from the last quiz session (Translate from int to String)
        String difficulty;
        if (currentQuizSession.getDifficultyLevel() == 1) {
            difficulty = "Easy";
        } else if (currentQuizSession.getDifficultyLevel() == 2) {
            difficulty = "Medium";
        } else {
            difficulty = "Hard";
        }
        difficultyLabel.setText("Difficulty: " + difficulty);
        scoreLabel.setText("Score: " + currentQuizSession.getReportSummary().getScorePercentage() + "%");

        feedbackLabel.setText(currentQuizSession.getReportSummary().getFeedback());

        // I fill the review area with one card for each answered question.
        reviewBox.getChildren().clear();

        for (Question aq : currentQuizSession.getQuestions()) {
            VBox card = new VBox(5.0);
            card.setStyle(
                    "-fx-border-color: #b0b0b0; -fx-border-width: 1; " +
                            "-fx-background-color: #ffffff;"
            );
            card.setPadding(new Insets(8, 8, 8, 8));

            Label qLabel = new Label(aq.getQuestionText());
            qLabel.setStyle("-fx-font-weight: bold;");
            qLabel.setWrapText(true);

            Label myAnswer = new Label("My answer: " + aq.getCurrentAnswer());
            myAnswer.setWrapText(true);

            card.getChildren().addAll(qLabel, myAnswer);

            // I only show the correct answer if my answer was wrong.
            if (!aq.getCurrentAnswer().equalsIgnoreCase(aq.getCorrectAnswer())) {
                Label correct = new Label("Correct answer: " + aq.getCorrectAnswer());
                correct.setWrapText(true);
                card.getChildren().add(correct);
            }

            reviewBox.getChildren().add(card);
        }
    }

    @FXML
    private void handleReturnToSelectQuiz() throws Exception {
        // I go back to the topic selection screen.
        MainApp.switchScene("SelectQuiz.fxml", "Select Quiz");
    }
}
