package group8.ets.quizmaterials.topicandquestions;

/*
CLASS INFORMATION:
The Topic class represents a subject or category for quiz questions.
The Topic will affect which questions are presented to the student during a quiz session through their respective QuestionBank.
 */

import group8.ets.Session;
import group8.ets.Utility;
import group8.ets.database.TopicDatabase;

public class Topic {

    // ATTRIBUTES
    // Topic Information
    private String topicName;
    private String description;

    // Question Pool
    private QuestionBank questionBank;

    // Default Constructor is protected to avoid direct instantiation of Topic from the main class
    protected Topic(String topicName, String description, QuestionBank questionBank) {
        this.topicName = topicName;
        this.description = description;
        this.questionBank = questionBank;
        TopicDatabase.getInstance().store(this);
        Utility.log("Topic created: " + topicName);
    }

    // Methods to add or remove questions from the QuestionBank
    public void addMCQQuestion(MultipleChoiceQuestion question) {
        questionBank.addQuestion(question);
    }

    public void addTrueOrFalseQuestion(TrueOrFalseQuestion question) {
        questionBank.addQuestion(question);
    }

    // Getters and Setters
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionBank getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }
}