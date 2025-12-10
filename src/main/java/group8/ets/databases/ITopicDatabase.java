package group8.ets.databases;

/*
CLASS INFORMATION:
The Database interface serves as a contract for database operations within the Educational Testing System.
It defines the essential methods that any database implementation must provide to ensure consistent data management and retrieval.
 */

import group8.ets.quizmaterials.topicandquestions.Topic;

import java.util.List;

public interface ITopicDatabase {
    void store(Topic topic);
    List<Topic> getAll();
}
