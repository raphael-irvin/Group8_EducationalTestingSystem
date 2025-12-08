import group8.ets.database.TopicDatabase;
import group8.ets.quizmaterials.topicandquestions.QuestionFactory;
import group8.ets.quizmaterials.topicandquestions.Topic;
import group8.ets.quizmaterials.topicandquestions.TopicBuilder;
import org.junit.Before;
import org.junit.Test;

public class TopicDatabaseTest {
    @Before
    public void setUp() {
        TopicBuilder topicBuilder = new TopicBuilder();
        Topic topic = topicBuilder.buildTopic("Mathematics", "All math related questions");
        Topic topic2 = topicBuilder.buildTopic("Science", "All science related questions");
        Topic topic3 = topicBuilder.buildTopic("History", "All history related questions");
    }

    @Test
    public void testTopicStorage() {
        int topicCount = TopicDatabase.getInstance().getAll().size();
        assert(topicCount == 3); // At least the 3 topics we added in set
    }
}
