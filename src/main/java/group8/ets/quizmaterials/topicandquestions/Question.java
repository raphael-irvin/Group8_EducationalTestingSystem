package group8.ets.quizmaterials.topicandquestions;

/*
CLASS INFORMATION:
The Question class is an abstract representation of a quiz question.
It serves as a base class for different types of questions (e.g., multiple-choice, true/false, short answer).
 */

// Base Abstract Class for Questions
public abstract class Question {

    // ATTRIBUTES
    // Question Information
    private final String questionText;
    private final int difficultyLevel;
    private final String questionType;

    // NOTE: Answer Attributes are declared separately in each subclass due to differing types

    // Default Constructor is protected to prevent direct instantiation
    protected Question(String questionText, int difficultyLevel, String questionType) {
        this.questionText = questionText;
        this.difficultyLevel = difficultyLevel;
        this.questionType = questionType;
    }

    // Getters and Setters

    public String getQuestionText() {
        return questionText;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getQuestionType() {
        return questionType;
    }

    // Abstract Methods
    public abstract void setCurrentAnswer(String answer);
    public abstract String getCurrentAnswer();
    public abstract boolean checkAnswer();
    public abstract String getCorrectAnswer();
}

