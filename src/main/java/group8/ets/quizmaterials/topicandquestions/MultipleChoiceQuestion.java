package group8.ets.quizmaterials.topicandquestions;

/*
CLASS INFORMATION:
The MultipleChoiceQuestion class represents a multiple-choice question in the quiz system.

IMPORTANT: IT IS NOT DESIGNED TO BE INSTANTIATED DIRECTLY FROM THE MAIN CLASS.
-> The QuestionFactory is responsible for creating instances of this class.
 */

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {

    // ATTRIBUTES
    private ArrayList<String> options;
    private final String correctAnswer;
    private String currentAnswer;

    // Constructor
    protected MultipleChoiceQuestion(String questionText, int difficultyLevel, ArrayList<String> options, String correctAnswer) {
        super(questionText, difficultyLevel);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void setCurrentAnswer(String answer) {
        this.currentAnswer = answer;
    }

    @Override
    public boolean checkAnswer() {
        return currentAnswer.equals(correctAnswer);
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    // Getters and Setters
    public ArrayList<String> getOptions() {
        return options;
    }
}
