package group8.ets.quizmaterials.topicandquestions;

/*
CLASS INFORMATION:
The QuestionBank class serves as a repository for quiz questions categorized by topics.
It allows for the storage, retrieval, and management of questions to be used in quiz sessions of the respective topic.
 */

import java.util.ArrayList;
import java.util.Random;

public class QuestionBank {

    // ATTRIBUTES
    // Question Storage
    private ArrayList<Question> questions = new ArrayList<>();

    // Add a Question to the QuestionBank
    protected void addQuestion(Question question) {
        questions.add(question);
    }

    // Retrieve a Random Set of Questions
    public ArrayList<Question> getRandomQuestions(int numberOfQuestions, int difficultyLevel) {
        Random rand = new Random();

        // Set output list for valid selected questions
        ArrayList<Question> output = new ArrayList<>();

        // Safety check to prevent infinite loop
        if (questions.stream().filter(q -> q.getDifficultyLevel() <= difficultyLevel).count() < numberOfQuestions) {
            throw new IllegalArgumentException("Not enough questions available for the specified difficulty level.");
        }

        // Loop until the output list reaches the desired number of questions
        while (output.size() < numberOfQuestions) {
            // Select a random question from the question bank
            Question currentTarget = questions.get(rand.nextInt(0, questions.size()));

            // Check if the question matches the difficulty level and is not already in the output list
            if (currentTarget.getDifficultyLevel() <= difficultyLevel && !output.contains(currentTarget)) {
                output.add(currentTarget);
            }
        }
        return output; // Placeholder return
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
