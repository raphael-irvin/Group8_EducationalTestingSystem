package group8.ets.quizmaterials.reports;

/*
CLASS INFORMATION:
The FeedbackGeneratorService is responsible for generating feedback based on the performance of a QuizSession.
It shall implement External OpenAI API to generate detailed and personalized feedback for students.
It shall process the QuizSession data and interact with the OpenAI API to obtain feedback.
 */


import group8.ets.quizmaterials.QuizSession;
import group8.ets.Utility;

public class FeedbackGeneratorService implements IFeedbackGeneratorService{

    // Constructor
    public FeedbackGeneratorService() {
        Utility.log("FeedbackGeneratorService instance created.");
    }

    // Method to generate feedback based on QuizSession data
    public String generateFeedback(QuizSession quizSession) {
        String feedback = "placeholder";
        // TODO: Implement OpenAI API interaction to generate feedback
        // 1) Feed Each Question, The Selected Answer, and the Correct Answer to the API
        // 2) Prompt the API to generate detailed feedback based on the performance
        // 3) Prompt the API to focus on areas of improvement and strengths
        return feedback;
    }
}
