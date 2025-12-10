package group8.ets.services;

/*
CLASS INFORMATION:
The IDGeneratorService class is responsible for generating unique identifiers for various entities within the Educational Testing System.
This service ensures that each generated ID is unique and follows a specific format or pattern as required by the system.
It may utilize different algorithms or strategies to create IDs, such as UUIDs, sequential numbers,
It is singleton in nature, ensuring that only one instance of IDGeneratorService exists throughout the application lifecycle.
 */

import group8.ets.Student;

public class IDGeneratorService {

    // Singleton Instance
    private static IDGeneratorService instance = null;

    // Private Constructor to prevent instantiation
    private IDGeneratorService() {}

    // Method to get the Singleton Instance
    public static IDGeneratorService getInstance() {
        if (instance == null) {
            instance = new IDGeneratorService();
        }
        return instance;
    }

    // Generate QuizSession ID
    public String generateQuizSessionID() {
        return "QS-" + System.currentTimeMillis();
    }

}
