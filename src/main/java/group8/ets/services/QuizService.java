package group8.ets.services;

/*
CLASS INFORMATION:
The QuizService class is intended to handle operations related to quizzes within the Educational Testing System.
This includes creating, updating, deleting, and retrieving quizzes, as well as managing quiz sessions and results.
It is singleton in nature, ensuring that only one instance of QuizService exists throughout the application lifecycle.
 */

import group8.ets.Student;
import group8.ets.quizmaterials.QuizSession;
import group8.ets.quizmaterials.reports.FeedbackGeneratorService;
import group8.ets.quizmaterials.reports.ReportFactory;
import group8.ets.quizmaterials.topicandquestions.Question;
import group8.ets.quizmaterials.topicandquestions.Topic;

public class QuizService {

    // Singleton Instance
    private static QuizService instance = null;

    // Dependency Services
    private final ReportFactory reportFactory;

    // Private Constructor to prevent instantiation
    private QuizService() {
        reportFactory = new ReportFactory(new FeedbackGeneratorService());
    }

    // Method to get the Singleton Instance
    public static QuizService getInstance() {
        if (instance == null) {
            instance = new QuizService();
        }
        return instance;
    }

    // Start Quiz Session
    public QuizSession startQuizSession(Student student, Topic selectedTopic, int difficultyLevel) {
        return new QuizSession(student, selectedTopic, difficultyLevel, reportFactory);
    }

    // Select Answer for a Question
    public void submitAnswer(Question question, String selectedAnswer) {
        question.setCurrentAnswer(selectedAnswer);
    }

    // Finish Quiz Session
    public void finishQuizSession(QuizSession quizSession) {
        quizSession.finishQuiz();

        // Save Quiz Results to Student Profile
        Student student = quizSession.getStudent();
        student.getTakenQuizzes().add(quizSession);
    }


}
