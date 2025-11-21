import group8.ets.quizmaterials.topicandquestions.QuestionFactory;
import group8.ets.quizmaterials.topicandquestions.TrueOrFalseQuestion;
import org.junit.Before;
import org.junit.Test;

public class TrueOrFalseQuestionTest {

    private TrueOrFalseQuestion trueOrFalseQuestion;
    private final String questionText = "The sky is blue.";
    private final int difficultyLevel = 1;
    private final boolean correctAnswer = true;

    @Before
    public void createTestQuestion() {
        QuestionFactory factory = new QuestionFactory();
        trueOrFalseQuestion = factory.createTrueFalseQuestion(questionText, difficultyLevel, correctAnswer);
    }

    @Test
    public void getCorrectAnswer() {
        assert trueOrFalseQuestion.getCorrectAnswer().equals("true");
    }

    @Test
    public void testSetCurrentAnswer() {
        trueOrFalseQuestion.setCurrentAnswer("true");
    }

    @Test
    public void testCheckAnswer_Correct() {
        trueOrFalseQuestion.setCurrentAnswer("true");
        assert trueOrFalseQuestion.checkAnswer();
    }

    @Test
    public void testCheckAnswer_Incorrect() {
        trueOrFalseQuestion.setCurrentAnswer("false");
        assert !trueOrFalseQuestion.checkAnswer();
    }
}
