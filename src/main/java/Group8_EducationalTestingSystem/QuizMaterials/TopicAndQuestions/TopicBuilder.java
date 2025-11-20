package Group8_EducationalTestingSystem.QuizMaterials.TopicAndQuestions;

/*
CLASS INFORMATION:
The TopicBuilder class is intended to provide a flexible way to construct Topic objects with various configurations.
It follows the Builder design pattern to allow for step-by-step construction of Topic instances.
It is Singleton to ensure only one instance of the builder exists.
 */

import Group8_EducationalTestingSystem.Utility;

public class TopicBuilder {

    // Singleton Instance
    private static TopicBuilder instance;

    // Private constructor to prevent instantiation
    private TopicBuilder() {
        Utility.log("TopicBuilder instance created.");
    }

    // Method to verify singleton instance
    public static TopicBuilder getInstance() {
        if (instance == null) {
            instance = new TopicBuilder();
        }
        return instance;
    }

    // Method to build a Topic
    public Topic buildTopic(String topicName, String description) {
        QuestionBank questionBank = new QuestionBank();
        return new Topic(topicName, description, questionBank);
    }
}
