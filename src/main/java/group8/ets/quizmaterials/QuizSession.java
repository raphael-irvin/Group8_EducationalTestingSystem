package group8.ets.quizmaterials;

/*
CLASS INFORMATION:
The QuizSession will be instantiated when a student starts a quiz. It will hold information about the current quiz session for that student.
 */

import group8.ets.quizmaterials.reports.ReportFactory;
import group8.ets.quizmaterials.reports.ReportSummary;
import group8.ets.quizmaterials.topicandquestions.Question;
import group8.ets.quizmaterials.topicandquestions.Topic;
import group8.ets.Student;

import java.util.ArrayList;

public class QuizSession {

    // ATTRIBUTES
    // Session Information
    private Student student;
    private Topic selectedTopic;
    private String difficultyLevel;
    private ArrayList<Question> questions;

    // Score and Performance Data
    private ReportSummary reportSummary;

    // Default Constructor
    public QuizSession(Student student, Topic selectedTopic) {
        // TODO: Initialize Necessary Setups (Questions, Index, Timer, etc.)
    }

    // Session Operations
    public void startQuiz() {
        // TODO: Logic to start the quiz session
    }

    public void finishQuiz() {
        // TODO: Logic to evaluate the quiz and calculate score
        this.reportSummary = ReportFactory.getInstance().generateReportSummary(this);
    }

    // Getters and Setters

    public Student getStudent() {
        return student;
    }

    public Topic getSelectedTopic() {
        return selectedTopic;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public ReportSummary getReportSummary() {
        return reportSummary;
    }
}
