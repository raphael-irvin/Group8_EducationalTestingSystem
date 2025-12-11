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
    @Override
    public String generateFeedback(QuizSession quizSession, double scorePercentage) {
        // TODO: Implement OpenAI API integration to generate feedback
        return "placeholder feedback";
    }
}

