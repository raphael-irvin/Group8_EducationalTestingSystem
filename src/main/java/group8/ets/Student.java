package group8.ets;

/*
CLASS INFORMATION:
The Group8_EducationalTestingSystem.Student (User) class is the primary class used for user sessions and to store respective data of the user
 */

import group8.ets.quizmaterials.QuizSession;

import java.util.ArrayList;

public class Student {

    // ATTRIBUTES
    // Personal Information
    private String name;
    private String email;
    private String password;

    // Score and Performance Data
    private ArrayList<QuizSession> takenQuizzes = new ArrayList<>();
    private double averageScore;

    //Default Constructor
    public Student(String name, String email, String password) {
        this.password = password;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<QuizSession> getTakenQuizzes() {
        return takenQuizzes;
    }

    public void addTakenQuiz(QuizSession quizSession) {
        this.takenQuizzes.add(quizSession);
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
