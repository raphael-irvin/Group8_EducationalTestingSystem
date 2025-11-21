package group8.ets.quizmaterials.topicandquestions;

/*
CLASS INFORMATION:
The QuestionFactory class is responsible for creating instances of different types of questions.
It provides methods to generate questions based on specified parameters, ensuring that the correct question type is instantiated with the appropriate attributes.
 */

import group8.ets.Utility;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionFactory implements IQuestionFactory{

    // Constructor
    public QuestionFactory() {
        Utility.log("QuestionFactory instance created.");
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
