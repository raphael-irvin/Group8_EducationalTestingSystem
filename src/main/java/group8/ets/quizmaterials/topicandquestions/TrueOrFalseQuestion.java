package group8.ets.quizmaterials.topicandquestions;

/*
CLASS INFORMATION:
The TrueOrFalseQuestion class represents a true or false type question in the quiz system.

IMPORTANT: IT IS NOT DESIGNED TO BE INSTANTIATED DIRECTLY FROM THE MAIN CLASS.
-> The QuestionFactory is responsible for creating instances of this class.
 */

public class TrueOrFalseQuestion extends Question {

    // ATTRIBUTES
    private final boolean correctAnswer;
    private Boolean currentAnswer;

    // Constructor
    protected TrueOrFalseQuestion(String questionText, int difficultyLevel, boolean correctAnswer) {
        super(questionText, difficultyLevel, "TrueOrFalse");
        this.correctAnswer = correctAnswer;
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
    public String getCurrentAnswer() {
        if (currentAnswer = true) {
            return "true";
        } else if (currentAnswer = false) {
            return "false";
        } else {
            return null; // No answer set
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
