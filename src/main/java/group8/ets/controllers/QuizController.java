package group8.ets.controllers;

import group8.ets.MainApp;
import group8.ets.Session;
import group8.ets.quizmaterials.topicandquestions.MultipleChoiceQuestion;
import group8.ets.quizmaterials.topicandquestions.Question;
import group8.ets.services.QuizService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuizController {

    // Answered Question Counter
    private int answeredQuestionCount = 0;

    // Store Answered Questions
    private ArrayList<Question> answeredQuestions = new ArrayList<>();

    @FXML
    private VBox questionsBox;            // container for all question cards

    @FXML
    private Label topicDifficultyLabel;   // shows "Topic difficulty: Easy"

    @FXML
    private Label answersInfoLabel;       // shows "x / 10 answers"

    // I keep all quiz items here so I can read the answers later.
    private final ArrayList<Question> questions = Session.getInstance().getCurrentQuizSession().getQuestions();

    @FXML
    private void initialize() {
        // I clear the box and add all question cards.
        questionsBox.getChildren().clear();

        // Initialize each question card
        for (Question question : questions) {
            VBox card = buildCard(question);
            questionsBox.getChildren().add(card);
        }

        // I show the difficulty selected in the SelectQuiz page.
        topicDifficultyLabel.setText("Topic difficulty: " + Session.getInstance().getCurrentQuizSession().getDifficultyLevel());

        // I initialise the "x / total answers" text.
        answersInfoLabel.setText(answeredQuestionCount + " / " + questions.size() + " answers");
    }

    // This creates the UI card (VBox) for one question.
    private VBox buildCard(Question question) {
        VBox box = new VBox(8.0);
        box.setStyle("-fx-border-color: #b0b0b0; -fx-border-width: 1; "
                + "-fx-background-color: #ffffff; -fx-padding: 10;");

        Label qLabel = new Label(question.getQuestionText());
        qLabel.setStyle("-fx-font-weight: bold;");
        qLabel.setWrapText(true);
        box.getChildren().add(qLabel);

        ToggleGroup toggleGroup = new ToggleGroup();
        if (question.getQuestionType().equalsIgnoreCase("MultipleChoice")) {
            for (String option : ((MultipleChoiceQuestion) question).getOptions()) {
                RadioButton rb = new RadioButton(option);
                rb.setToggleGroup(toggleGroup);
                rb.setWrapText(true);

                // Whenever I pick an answer, I refresh the counter.
                rb.setOnAction(e -> updateAnswersInfo(question, rb.getText()));

                box.getChildren().add(rb);
            }
        } // For True/False questions
        else if (question.getQuestionType().equalsIgnoreCase("TrueOrFalse")) {
            RadioButton trueRB = new RadioButton("True");
            trueRB.setToggleGroup(toggleGroup);
            trueRB.setWrapText(true);
            trueRB.setOnAction(e -> updateAnswersInfo(question, "True"));

            RadioButton falseRB = new RadioButton("False");
            falseRB.setToggleGroup(toggleGroup);
            falseRB.setWrapText(true);
            falseRB.setOnAction(e -> updateAnswersInfo(question, "False"));

            box.getChildren().addAll(trueRB, falseRB);
        }

        return box;
    }

    // This shows "x / total answers" on the right side and set current set answer for the question.
    private void updateAnswersInfo(Question question, String selectedAnswer) {
        // Set Current Answer for the Question
        question.setCurrentAnswer(selectedAnswer);

        // Mark Question as Answered and Increment Counter if not already answered
        if (!answeredQuestions.contains(question)) {
            answeredQuestions.add(question);
            answeredQuestionCount++;
        }

        answersInfoLabel.setText(answeredQuestionCount + " / " + questions.size() + " answers");
    }

    @FXML
    private void handleFinishQuiz() throws Exception {
        QuizService.getInstance().finishQuizSession(Session.getInstance().getCurrentQuizSession());

        MainApp.switchScene("ResultQuiz.fxml", "Result Quiz");
    }

    @FXML
    private void handleCancelQuiz() throws Exception {
        // I just go back to topic selection.
        MainApp.switchScene("SelectQuiz.fxml", "Select Quiz");
    }
}
