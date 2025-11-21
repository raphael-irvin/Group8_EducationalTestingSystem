package group8.ets.quizmaterials.topicandquestions;

/*
CLASS INFORMATION:
The QuestionBank class serves as a repository for quiz questions categorized by topics.
It allows for the storage, retrieval, and management of questions to be used in quiz sessions of the respective topic.
 */

import java.util.ArrayList;

public class QuestionBank {

    // ATTRIBUTES
    // Question Storage
    private ArrayList<Question> questions = new ArrayList<>();

    // Add a Question to the QuestionBank
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Retrieve a Random Set of Questions
    public ArrayList<Question> getRandomQuestions(int numberOfQuestions) {
        // TODO: Logic to retrieve a random set of questions, limited to numberOfQuestions
        return new ArrayList<>(); // Placeholder return
    }

    // Getter for all questions
    public ArrayList<Question> getAllQuestions() {
        return questions;
    }

    // Retrieve the total number of questions
    public int getTotalQuestions() {
        return questions.size();
    }
}
