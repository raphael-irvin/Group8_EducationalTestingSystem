package Group8_EducationalTestingSystem.QuizMaterials.TopicAndQuestions;

/*
CLASS INFORMATION:
The MultipleChoiceQuestion class represents a multiple-choice question in the quiz system.

IMPORTANT: IT IS NOT DESIGNED TO BE INSTANTIATED DIRECTLY FROM THE MAIN CLASS.
-> The QuestionFactory is responsible for creating instances of this class.
 */

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question implements QuestionType {

    // ATTRIBUTES
    private ArrayList<String> options;
    private final String correctAnswer;
    private String currentAnswer;

    // Constructor
    protected MultipleChoiceQuestion(String questionText, String topicField, ArrayList<String> options, String correctAnswer) {
        super(questionText, topicField);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void displayQuestion() {
        // TODO: Logic to display the question and options
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
