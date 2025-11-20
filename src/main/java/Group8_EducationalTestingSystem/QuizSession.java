package Group8_EducationalTestingSystem;

/*
CLASS INFORMATION:
The QuizSession will be instantiated when a student starts a quiz. It will hold information about the current quiz session for that student.
 */

import Group8_EducationalTestingSystem.QuizMaterials.TopicAndQuestions.Question;
import Group8_EducationalTestingSystem.QuizMaterials.TopicAndQuestions.Topic;

import java.util.ArrayList;

public class QuizSession {

    // ATTRIBUTES
    // Session Information
    private Student student;
    private Topic selectedTopic;
    private ArrayList<Question> questions;

    // Score and Performance Data
    private double score;
    private String feedback;

    // Default Constructor
    public QuizSession(Student student, Topic selectedTopic) {
        // TODO: Initialize Necessary Setups (Questions, Index, Timer, etc.)
    }

    // Session Operations
    public void startQuiz() {
        // TODO: Logic to start the quiz session
    }

    public void evaluateQuiz() {
        // TODO: Logic to evaluate the quiz and calculate score
    }

    public void provideFeedback() {
        // TODO: Logic to generate feedback based on performance
    }

    // Getters and Setters
    public double getScore() {
        return score;
    }

    public String getFeedback() {
        return feedback;
    }
}
