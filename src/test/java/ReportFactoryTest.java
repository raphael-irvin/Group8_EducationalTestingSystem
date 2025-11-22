import group8.ets.Student;
import group8.ets.quizmaterials.QuizSession;
import group8.ets.quizmaterials.reports.FeedbackGeneratorService;
import group8.ets.quizmaterials.reports.IFeedbackGeneratorService;
import group8.ets.quizmaterials.reports.IReportFactory;
import group8.ets.quizmaterials.reports.ReportFactory;
import group8.ets.quizmaterials.topicandquestions.QuestionFactory;
import group8.ets.quizmaterials.topicandquestions.Topic;
import group8.ets.quizmaterials.topicandquestions.TopicBuilder;
import org.junit.Before;
import org.junit.Test;

public class ReportFactoryTest {
    Topic topic;
    Student mockStudent = new Student("testUser", "email", "password");
    IFeedbackGeneratorService feedbackService = new FeedbackGeneratorService();
    IReportFactory reportFactory = new ReportFactory(feedbackService);
    QuizSession mockQuizSession;

    @Before
    public void setUp() {
        TopicBuilder topicBuilder = new TopicBuilder();
        QuestionFactory questionFactory = new QuestionFactory();
        topic = topicBuilder.buildTopic("Mathematics", "All math related questions");

        // Difficulty level 1 (15 questions) - basic facts and arithmetic
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 2+2?", 1, "4", "1", "2", "3"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 5-3?", 1, "2", "1", "3", "4"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 3*1?", 1, "3", "1", "2", "4"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 10 divided by 2?", 1, "5", "2", "10", "8"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Is 5 a prime number?", 1, true));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Is 10 greater than 20?", 1, false));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the square of 2?", 1, "4", "2", "6", "8"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("How many sides does a triangle have?", 1, "3", "2", "4", "5"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the value of 0+7?", 1, "7", "6", "8", "9"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("A circle has corners.", 1, false));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 1+1?", 1, "2", "1", "3", "4"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the next number after 4?", 1, "5", "6", "3", "7"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which number is even?", 1, "4", "3", "7", "9"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Zero is an even number.", 1, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which is a single digit number?", 1, "7", "12", "15", "21"));

        // Difficulty level 2 (15 questions) - intermediate arithmetic, basic algebra and geometry
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 12+13?", 2, "25", "22", "23", "26"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 6*7?", 2, "42", "36", "48", "40"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 49 divided by 7?", 2, "7", "6", "8", "9"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the perimeter of a rectangle with sides 3 and 5?", 2, "16", "15", "8", "20"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("An isosceles triangle has at least two equal sides.", 2, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Solve for x: x + 5 = 12", 2, "7", "6", "8", "5"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the area of a square with side length 4?", 2, "16", "8", "12", "10"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 15 - 9?", 2, "6", "5", "7", "8"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The sum of angles in a triangle is 180 degrees.", 2, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 9 + 8?", 2, "17", "16", "15", "18"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("If 3x = 12, what is x?", 2, "4", "3", "2", "6"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the mean of 2,4,6?", 2, "4", "3", "6", "5"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("A rhombus always has right angles.", 2, false));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 7 * 5?", 2, "35", "30", "25", "40"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 100 - 45?", 2, "55", "45", "65", "60"));

        // Difficulty level 3 (15 questions) - advanced problems, algebra, basic calculus intuition, harder geometry
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Solve for x: 2x + 3 = 11", 3, "4", "3", "5", "2"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 13 * 7?", 3, "91", "81", "99", "87"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the square root of 144?", 3, "12", "11", "10", "14"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("If f(x)=2x, what is f(5)?", 3, "10", "7", "12", "8"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The derivative of x^2 with respect to x is 2x.", 3, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the value of 17 + 28?", 3, "45", "44", "43", "46"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 81 divided by 9?", 3, "9", "8", "7", "6"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("If a triangle has sides 3,4,5 is it a right triangle?", 3, "Yes", "No", "Impossible", "Only if scaled"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The angles of a right triangle add up to 180 degrees.", 3, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Solve: 3x - 2 = 10", 3, "4", "3", "2", "6"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 0 factorial (0!)?", 3, "1", "0", "Undefined", "-1"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which is a prime number?", 3, "29", "21", "27", "33"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The number e is approximately 2.718.", 3, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the product of -3 and -7?", 3, "21", "-21", "10", "-10"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the cube of 2?", 3, "8", "6", "4", "12"));

        // Initialize Mock Quiz Session with difficulty level 2
        mockQuizSession = new QuizSession(mockStudent, topic, 2, reportFactory);

        // Set Random Answers for the mock quiz session
        for (var question : mockQuizSession.getQuestions()) {
            if (question.getClass().getSimpleName().equals("MultipleChoiceQuestion")) {
                question.setCurrentAnswer("4"); // Arbitrary answer for testing
            } else if (question.getClass().getSimpleName().equals("TrueOrFalseQuestion")) {
                question.setCurrentAnswer("true"); // Arbitrary answer for testing
            }
        }
    }

    @Test
    public void generateReport() {
        mockQuizSession.finishQuiz();
        System.out.println("Total Questions: " + mockQuizSession.getReportSummary().getTotalQuestions());
        System.out.println("Correct Answer: " + mockQuizSession.getReportSummary().getCorrectAnswers());
        System.out.println("Incorrect Answers: " + mockQuizSession.getReportSummary().getIncorrectAnswers());
        System.out.println("Score Percentage: " + mockQuizSession.getReportSummary().getScorePercentage() + "%");
        System.out.println("Feedback: " + mockQuizSession.getReportSummary().getFeedback());
    }
}
