package Group8_EducationalTestingSystem.QuizMaterials.Reports;

/*
CLASS INFORMATION:
The ReportFactory is responsible to generate a corresponding ReportSummary for a finished QuizSession.
It provides methods to simplify ReportSummary Object generation.
It is Singleton in nature, ensuring that only one instance of the factory exists throughout the application.
 */

import Group8_EducationalTestingSystem.QuizMaterials.QuizSession;
import Group8_EducationalTestingSystem.Utility;

public class ReportFactory {

    // Singleton Instance
    private static ReportFactory instance;

    // Private constructor to prevent instantiation
    private ReportFactory() {
        Utility.log("ReportFactory instance created.");
    }

    // Get Singleton Instance
    public static ReportFactory getInstance() {
        if (instance == null) {
            instance = new ReportFactory();
        }
        return instance;
    }

    public ReportSummary generateReportSummary(QuizSession quizSession) {
        // Initial Values
        int totalQuestions = 0; int correctAnswers = 0; int incorrectAnswers = 0; double scorePercentage = 0.0; String feedback = "N/A";

        // TODO: Count Total Questions, Correct Answers, Incorrect Answers, and Calculate Score Percentage
        return new ReportSummary(totalQuestions, correctAnswers, incorrectAnswers, scorePercentage, feedback);
    }
}
