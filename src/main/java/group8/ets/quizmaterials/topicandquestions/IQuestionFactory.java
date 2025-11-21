package group8.ets.quizmaterials.topicandquestions;

public interface IQuestionFactory {
    MultipleChoiceQuestion createMultipleChoiceQuestion(String questionText, int difficultyLevel, String correctAnswer, String... wrongAnswers);
    TrueOrFalseQuestion createTrueFalseQuestion(String questionText, int difficultyLevel, boolean correctAnswer);
}
