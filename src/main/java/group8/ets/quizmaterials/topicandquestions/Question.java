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

    // NOTE: Answer Attributes are declared separately in each subclass due to differing types

    // Default Constructor is protected to prevent direct instantiation
    protected Question(String questionText, int difficultyLevel) {
        this.questionText = questionText;
        this.difficultyLevel = difficultyLevel;
    }

    // Getters and Setters

    public String getQuestionText() {
        return questionText;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    // Abstract Methods
    abstract void setCurrentAnswer(String answer);
    abstract boolean checkAnswer();
    abstract String getCorrectAnswer();
}

