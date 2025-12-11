package group8.ets.quizmaterials;

/*
CLASS INFORMATION:
The QuizSession will be instantiated when a student starts a quiz. It will hold information about the current quiz session for that student.
 */

import group8.ets.quizmaterials.reports.IReportFactory;
import group8.ets.quizmaterials.reports.ReportSummary;
import group8.ets.quizmaterials.topicandquestions.Question;
import group8.ets.quizmaterials.topicandquestions.Topic;
import group8.ets.Student;
import group8.ets.services.IDGeneratorService;

import java.util.ArrayList;

public class QuizSession {

    // ATTRIBUTES
    // Session Information
    private final String sessionId;
    private final Student student;
    private final Topic selectedTopic;
    private final int difficultyLevel;
    private final ArrayList<Question> questions;

    // Score and Performance Data
    private final IReportFactory reportFactory;
    private ReportSummary reportSummary;

    // Default Constructor
    public QuizSession(Student student, Topic selectedTopic, int difficultyLevel, IReportFactory iReportFactory) {
        // Get Unique Session ID
        this.sessionId = IDGeneratorService.getInstance().generateQuizSessionID();

        // Initialize Other Attributes
        this.student = student;
        this.selectedTopic = selectedTopic;
        this.difficultyLevel = difficultyLevel;
        this.reportFactory = iReportFactory;

        // Setup Questions based on Topic and Difficulty Level
        this.questions = selectedTopic.getQuestionBank().getRandomQuestions(10, difficultyLevel);
    }

    public void finishQuiz() {
        // All Data and Logic are separated into the ReportSummary class
        this.reportSummary = reportFactory.generateReportSummary(this);
    }

    // Getters and Setters

    public String getSessionId() {
        return sessionId;
    }

    public Student getStudent() {
        return student;
    }

    public Topic getSelectedTopic() {
        return selectedTopic;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public ReportSummary getReportSummary() {
        return reportSummary;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }
}
