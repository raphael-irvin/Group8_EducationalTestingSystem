package group8.ets.quizmaterials.reports;

/*
CLASS INFORMATION:
The ReportFactory is responsible to generate a corresponding ReportSummary for a finished QuizSession.
It provides methods to simplify ReportSummary Object generation.
 */

import group8.ets.quizmaterials.QuizSession;
import group8.ets.Utility;

public class ReportFactory implements IReportFactory{

    // Private constructor to prevent instantiation
    public ReportFactory(QuizSession quizSession) {
        Utility.log("ReportFactory instance created.");
    }

    public ReportSummary generateReportSummary(QuizSession quizSession) {
        // Initial Values
        int totalQuestions = 0; int correctAnswers = 0; int incorrectAnswers = 0; double scorePercentage = 0.0; String feedback = "N/A";

        // TODO: Count Total Questions, Correct Answers, Incorrect Answers, and Calculate Score Percentage
        return new ReportSummary(totalQuestions, correctAnswers, incorrectAnswers, scorePercentage, feedback);
    }
}
