package Group8_EducationalTestingSystem;

import Group8_EducationalTestingSystem.QuizMaterials.TopicAndQuestions.QuestionFactory;
import Group8_EducationalTestingSystem.QuizMaterials.TopicAndQuestions.Topic;
import Group8_EducationalTestingSystem.QuizMaterials.TopicAndQuestions.TopicBuilder;

public class Main {

    public static void main(String[] args) {
        Topic mathTopic = TopicBuilder.getInstance().buildTopic("Basic Mathematics", "Basic Math Questions");

        QuestionFactory factory = QuestionFactory.getInstance();

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
