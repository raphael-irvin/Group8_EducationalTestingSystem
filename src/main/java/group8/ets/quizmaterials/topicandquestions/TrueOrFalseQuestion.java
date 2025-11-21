package group8.ets.quizmaterials.topicandquestions;

/*
CLASS INFORMATION:
The TrueOrFalseQuestion class represents a true or false type question in the quiz system.

IMPORTANT: IT IS NOT DESIGNED TO BE INSTANTIATED DIRECTLY FROM THE MAIN CLASS.
-> The QuestionFactory is responsible for creating instances of this class.
 */

public class TrueOrFalseQuestion extends Question implements QuestionType {

    // ATTRIBUTES
    private final boolean correctAnswer;
    private Boolean currentAnswer;

    // Constructor
    protected TrueOrFalseQuestion(String questionText, int difficultyLevel, boolean correctAnswer) {
        super(questionText, difficultyLevel);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void displayQuestion() {
        // TODO: Logic to display the question
    }

    @Override
    public void setCurrentAnswer(String answer) {
        if (answer.equalsIgnoreCase("true")) {
            this.currentAnswer = true;
        } else if (answer.equalsIgnoreCase("false")) {
            this.currentAnswer = false;
        } else {
            this.currentAnswer = null; // Invalid answer
        }
    }

    @Override
    public boolean checkAnswer() {
        return currentAnswer != null && currentAnswer == correctAnswer;
    }

    @Override
    public String getCorrectAnswer() {
        return Boolean.toString(correctAnswer);
    }
}
