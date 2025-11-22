package group8.ets.quizmaterials.reports;

/*
CLASS INFORMATION:
The ReportFactory is responsible to generate a corresponding ReportSummary for a finished QuizSession.
It provides methods to simplify ReportSummary Object generation. All complex logic and calculations are encapsulated within this Factory.
 */

import group8.ets.quizmaterials.QuizSession;
import group8.ets.Utility;
import group8.ets.quizmaterials.topicandquestions.Question;

public class ReportFactory implements IReportFactory{

    // Services
    private final IFeedbackGeneratorService feedbackGeneratorService;

    // Constructor
    public ReportFactory(IFeedbackGeneratorService feedbackGeneratorService) {
        this.feedbackGeneratorService = feedbackGeneratorService;
        Utility.log("ReportFactory instance created.");
    }

    public ReportSummary generateReportSummary(QuizSession quizSession) {
        // Initial Values
        int totalQuestions = quizSession.getTotalQuestions();
        int correctAnswers = 0;
        int incorrectAnswers = totalQuestions;
        double scorePercentage = 0.0;
        String feedback = "N/A";

        // For Each Question in the QuizSession, Check if the Answer is Correct
        for (Question question : quizSession.getQuestions()) {
            // If the Answer is Correct, Increment Correct Answers and Decrement Incorrect Answers
            if (question.checkAnswer()) {
                correctAnswers++;
                incorrectAnswers--;
            }
        }

        // Calculate Score Percentage
        scorePercentage = ((double) correctAnswers / totalQuestions) * 100.0;

        // Generate Feedback using FeedbackGeneratorService
        feedback = feedbackGeneratorService.generateFeedback(quizSession);

        return new ReportSummary(totalQuestions, correctAnswers, incorrectAnswers, scorePercentage, feedback);
    }
}
