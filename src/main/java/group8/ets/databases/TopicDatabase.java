package group8.ets.databases;

/*
CLASS INFORMATION:
The TopicDatabase class is responsible for managing the storage and retrieval of Topic objects within the Educational Testing System.
It implements the Database interface, providing concrete implementations for storing topics and retrieving all stored topics.
it is Singleton in nature, ensuring that only one instance of TopicDatabase exists throughout the application lifecycle.
 */

import group8.ets.quizmaterials.topicandquestions.Topic;

import java.util.HashMap;
import java.util.List;

public class TopicDatabase implements ITopicDatabase{

    // Attributes
    private final HashMap<String, Topic> topics = new HashMap<>();

    // Singleton Instance
    private static TopicDatabase instance = null;

    // Private Constructor to prevent instantiation
    private TopicDatabase() {
    }

    // Method to get the Singleton Instance
    public static TopicDatabase getInstance() {
        if (instance == null) {
            instance = new TopicDatabase();
        }
        return instance;
    }

    // Store a Topic in the database
    @Override
    public void store(Topic topic) {
        topics.put(topic.getTopicName(), topic);
    }

    // Retrieve all Topics from the database
    @Override
    public List<Topic> getAll() {
        return List.copyOf(topics.values());
    }

    // Get a Topic by name (scalability purpose)
    public Topic getTopicByName(String topicName) {
        return topics.get(topicName);
    }
}
