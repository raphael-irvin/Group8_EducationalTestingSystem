package group8.ets;

/*
CLASS INFORMATION:
The Session class is intended to manage user sessions within the Educational Testing System.
It will handle session creation, validation, and termination to ensure secure access to the system's features.
it is singleton in nature, ensuring that only one instance of Session exists throughout the application lifecycle.
 */

import group8.ets.quizmaterials.QuizSession;

public class Session {
    private Student loggedInStudent;
    private QuizSession currentQuizSession;

    // Singleton Instance
    private static Session instance = null;

    // Private Constructor to prevent instantiation
    private Session() {
    }

    // Method to get the Singleton Instance
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    // USER SESSION MANAGEMENT METHODS
    // Set Current Active Student
    public void setLoggedInStudent(Student student) {
        this.loggedInStudent = student;
    }

    // Get Current Active Student
    public Student getLoggedInStudent() {
        return this.loggedInStudent;
    }

    // Empty Current Active Student (Logout)
    public void clearSession() {
        this.loggedInStudent = null;
    }

    // QUIZ SESSION MANAGEMENT METHODS
    // Set Current Active Quiz Session
    public void setCurrentQuizSession(QuizSession quizSession) {
        this.currentQuizSession = quizSession;
    }

    // Get Current Active Quiz Session
    public QuizSession getCurrentQuizSession() {
        return this.currentQuizSession;
    }
}
