package group8.ets.quizmaterials.reports;

/*
CLASS INFORMATION:
The ReportSummary object will be attached to a corresponding QuizSession that has been finished.

IMPORTANT: IT IS NOT DESIGNED TO BE INSTANTIATED DIRECTLY FROM THE MAIN CLASS.
-> The ReportFactory is responsible to generate the report.
 */

public class ReportSummary {

    // Quiz Summary Attributes
    private final int totalQuestions;
    private final int correctAnswers;
    private final int incorrectAnswers;
    private final double scorePercentage;
    private final String feedback;

    // Constructor -> Made Protected to prevent instantiation from main class
    protected ReportSummary(int totalQuestions, int correctAnswers, int incorrectAnswers, double scorePercentage, String feedback) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
        this.scorePercentage = scorePercentage;
        this.feedback = feedback;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public double getScorePercentage() {
        return scorePercentage;
    }

    public String getFeedback() {
        return feedback;
    }
}
