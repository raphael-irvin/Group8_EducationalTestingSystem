package group8.ets;

import group8.ets.quizmaterials.topicandquestions.QuestionFactory;
import group8.ets.quizmaterials.topicandquestions.Topic;
import group8.ets.quizmaterials.topicandquestions.TopicBuilder;

public class Main {

    public static void main(String[] args) {
        TopicBuilder topicBuilder = new TopicBuilder();
        Topic mathTopic = topicBuilder.buildTopic("Basic Mathematics", "Basic Math Questions");

        QuestionFactory factory = new QuestionFactory();

        mathTopic.addMCQQuestion(factory.createMultipleChoiceQuestion(
                "What is 2+2",
                1,
                "4",
                "1", "2", "3"
        ));

        mathTopic.addMCQQuestion(factory.createMultipleChoiceQuestion(
                "What is 2*2",
                1,
                "4",
                "1", "2", "3"
        ));

        mathTopic.addMCQQuestion(factory.createMultipleChoiceQuestion(
                "What is 2/2",
                1,
                "1",
                "2", "3", "4"
        ));

        mathTopic.addTrueOrFalseQuestion(factory.createTrueFalseQuestion(
                "Is 5 a prime number?", 1, true
        ));

        mathTopic.addTrueOrFalseQuestion(factory.createTrueFalseQuestion(
                "Is 10 greater than 20?", 1, false
        ));

        System.out.println("Topic: " + mathTopic.getTopicName());
        System.out.println("Description: " + mathTopic.getDescription());
        System.out.println("Number of Questions: " + mathTopic.getQuestionBank().getTotalQuestions());
    }
}
