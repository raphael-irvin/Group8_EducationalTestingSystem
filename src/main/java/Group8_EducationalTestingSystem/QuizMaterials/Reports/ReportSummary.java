package Group8_EducationalTestingSystem.QuizMaterials.Reports;

/*
CLASS INFORMATION:
The ReportSummary object will be attached to a corresponding QuizSession that has been finished.

IMPORTANT: IT IS NOT DESIGNED TO BE INSTANTIATED DIRECTLY FROM THE MAIN CLASS.
-> The ReportFactory is responsible to generate the report.
 */

public class ReportSummary {

    // Quiz Summary Attributes
    private int totalQuestions;
    private int correctAnswers;
    private int incorrectAnswers;
    private double scorePercentage;
    private String feedback;

    // Constructor -> Made Protected to prevent instantiation from main class
    protected ReportSummary(int totalQuestions, int correctAnswers, int incorrectAnswers, double scorePercentage, String feedback) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
        this.scorePercentage = scorePercentage;
        this.feedback = feedback;
    }
}
