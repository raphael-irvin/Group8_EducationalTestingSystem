package group8.ets.quizmaterials.reports;

/*
CLASS INFORMATION:
The FeedbackGeneratorService is responsible for generating feedback based on the performance of a QuizSession.
It shall implement External OpenAI API to generate detailed and personalized feedback for students.
It shall process the QuizSession data and interact with the OpenAI API to obtain feedback.
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import group8.ets.Utility;
import group8.ets.quizmaterials.QuizSession;
import group8.ets.quizmaterials.topicandquestions.Question;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class FeedbackGeneratorService implements IFeedbackGeneratorService {

    // CONFIGURATION - OpenRouter API Details
    // API KEY is hardcoded for simplicity, but in production, it should be securely stored and retrieved.
    private static final String API_KEY = "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";
    private static final String API_URL = "https://openrouter.ai/api/v1/chat/completions";
    // Free model example. You can change this to "meta-llama/llama-3-8b-instruct:free" or others.
    private static final String MODEL_NAME = "amazon/nova-2-lite-v1:free";

    private final HttpClient httpClient;
    private final Gson gson;

    public FeedbackGeneratorService() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
        Utility.log("FeedbackGeneratorService initialized.");
    }

    @Override
    public String generateFeedback(QuizSession quizSession, double scorePercentage) {
        Utility.log("Requesting AI feedback for score: " + scorePercentage + "%");

        try {
            // Construct the Prompt
            String systemContext = "You are a helpful and encouraging teacher assistant specialized in providing constructive feedback to students based on their quiz performance. There is no need to use markup in your responses.";
            String userPrompt = buildPrompt(quizSession, scorePercentage);

            // Build JSON Body using Gson
            JsonObject messageSystem = new JsonObject();
            messageSystem.addProperty("role", "system");
            messageSystem.addProperty("content", systemContext);

            JsonObject messageUser = new JsonObject();
            messageUser.addProperty("role", "user");
            messageUser.addProperty("content", userPrompt);

            JsonArray messages = new JsonArray();
            messages.add(messageSystem);
            messages.add(messageUser);

            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("model", MODEL_NAME);
            requestBody.add("messages", messages);
            requestBody.addProperty("temperature", 0.7); // Creativity level

            String jsonPayload = gson.toJson(requestBody);

            // Create and Send HTTP Request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Authorization", "Bearer " + API_KEY)
                    .header("Content-Type", "application/json")
                    // OpenRouter requires these headers for ranking
                    .header("HTTP-Referer", "http://localhost:8080")
                    .header("X-Title", "Group8 Educational Testing System")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload, StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse Response
            if (response.statusCode() == 200) {
                JsonObject responseJson = gson.fromJson(response.body(), JsonObject.class);
                // Navigate: choices[0] -> message -> content
                String content = responseJson.getAsJsonArray("choices")
                        .get(0).getAsJsonObject()
                        .getAsJsonObject("message")
                        .get("content").getAsString();

                Utility.log("Feedback received successfully.");
                return content.trim();
            } else {
                Utility.log("API Error: " + response.statusCode() + " - " + response.body());
                return "Could not generate AI feedback at this time. (Error " + response.statusCode() + ")";
            }

        } catch (Exception e) {
            Utility.log("Exception during feedback generation: " + e.getMessage());
            e.printStackTrace();
            return "An error occurred while contacting the feedback service.";
        }
    }

    /*
     Helper method to construct a detailed string prompt from the QuizSession object.
     */
    private String buildPrompt(QuizSession session, double score) {
        StringBuilder sb = new StringBuilder();

        sb.append("Generate a short, constructive feedback paragraph (max 3 sentences) for a student.\n");
        sb.append("Topic: ").append(session.getSelectedTopic().getTopicName()).append("\n");
        sb.append("Difficulty Level: ").append(session.getDifficultyLevel()).append("\n");
        sb.append("Score: ").append(String.format("%.1f", score)).append("%\n");

        // Analyze incorrect answers to give context
        sb.append("Context: The student struggled with the following questions:\n");
        int incorrectCount = 0;

        for (Question q : session.getQuestions()) {
            if (!q.checkAnswer()) {
                if (incorrectCount < 5) { // Limit to sending 3 mistakes to save tokens
                    sb.append("- Question: \"").append(q.getQuestionText()).append("\"\n");
                    sb.append("  Student Answer: ").append(q.getCurrentAnswer()).append("\n");
                    sb.append("  Correct Answer: ").append(q.getCorrectAnswer()).append("\n");
                }
                incorrectCount++;
            }
        }

        if (incorrectCount == 0) {
            sb.append("None! The student answered everything correctly.\n");
            sb.append("Tone: Highly praising and encouraging challenge.");
        } else {
            sb.append("Tone: Encouraging and offering specific advice based on the mistakes.");
        }

        return sb.toString();
    }
}

