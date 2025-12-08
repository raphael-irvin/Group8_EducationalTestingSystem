package group8.ets.quizmaterials.reports;

import group8.ets.quizmaterials.QuizSession;

public interface IFeedbackGeneratorService {

    String generateFeedback(QuizSession quizSession, double scorePercentage);
}
