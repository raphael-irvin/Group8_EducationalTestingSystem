package group8.ets.quizmaterials.topicandquestions;

/*
CLASS INFORMATION:
The TopicBuilder class is intended to provide a flexible way to construct Topic objects with various configurations.
It follows the Builder design pattern to allow for step-by-step construction of Topic instances.
 */

import group8.ets.Session;
import group8.ets.Utility;
import group8.ets.database.TopicDatabase;

public class TopicBuilder implements ITopicBuilder{

    // Constructor
    public TopicBuilder() {
        Utility.log("TopicBuilder instance created.");
    }

    // Method to build a Topic
    public Topic buildTopic(String topicName, String description) {
        QuestionBank questionBank = new QuestionBank();
        return new Topic(topicName, description, questionBank);
    }
}
