package group8.ets.quizmaterials.reports;

import group8.ets.quizmaterials.QuizSession;

public interface IReportFactory {

    ReportSummary generateReportSummary(QuizSession quizSession);
}
