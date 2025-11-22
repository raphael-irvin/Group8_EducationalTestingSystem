import group8.ets.quizmaterials.topicandquestions.MultipleChoiceQuestion;
import group8.ets.quizmaterials.topicandquestions.QuestionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MultipleChoiceQuestionTest {

    private MultipleChoiceQuestion question;
    private final String questionText = "What is the capital of France?";
    private final int difficultyLevel = 2;
    private final String correctAnswer = "Paris";

    @Before
    public void createTestQuestion() {
        QuestionFactory factory = new QuestionFactory();
        question = factory.createMultipleChoiceQuestion(questionText, difficultyLevel, correctAnswer, "London", "Berlin", "Madrid");
    }

    @Test
    public void getCorrectAnswer() {
        assertEquals("Paris", question.getCorrectAnswer());
    }

    @Test
    public void testSetCurrentAnswer() {
        question.setCurrentAnswer("Paris");
    }

    @Test
    public void testCheckAnswer_Correct() {
        question.setCurrentAnswer("Paris");
        assertTrue(question.checkAnswer());
    }

    @Test
    public void testCheckAnswer_Incorrect() {
        question.setCurrentAnswer("London");
        assertFalse(question.checkAnswer());
    }
}
