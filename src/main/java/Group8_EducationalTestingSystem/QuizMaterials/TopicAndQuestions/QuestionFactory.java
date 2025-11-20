package Group8_EducationalTestingSystem.QuizMaterials.TopicAndQuestions;

/*
CLASS INFORMATION:
The QuestionFactory class is responsible for creating instances of different types of questions.
It provides methods to generate questions based on specified parameters, ensuring that the correct question type is instantiated with the appropriate attributes.
It is Singleton in nature, ensuring that only one instance of the factory exists throughout the application.
 */

import Group8_EducationalTestingSystem.Utility;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionFactory {

    // Singleton Instance
    private static QuestionFactory instance;

    // Private constructor to prevent instantiation
    private QuestionFactory() {
        Utility.log("QuestionFactory instance created.");
    }

    //Method to verify singleton instance
    public static QuestionFactory getInstance() {
        if (instance == null) {
            instance = new QuestionFactory();
        }
        return instance;
    }

    // Method to create a Multiple Choice Question
    public MultipleChoiceQuestion createMultipleChoiceQuestion(String questionText, int difficultyLevel, String correctAnswer, String... wrongAnswers) {
        ArrayList<String> options = new ArrayList<>();
        options.add(correctAnswer);
        options.addAll(Arrays.asList(wrongAnswers));
        return new MultipleChoiceQuestion(questionText, difficultyLevel, options, correctAnswer);
    }

    // Method to create a True/False Question
    public TrueOrFalseQuestion createTrueFalseQuestion(String questionText, int difficultyLevel, boolean correctAnswer) {
        return new TrueOrFalseQuestion(questionText, difficultyLevel, correctAnswer);
    }
}
