package group8.ets;

/*
CLASS INFORMATION:
The Group8_EducationalTestingSystem.Utility class is intended to provide common helper methods and functionalities that can be used across different parts of the application.
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {

    // Method to log messages to the console
    public static void log(String message) {
        System.out.println("[SYSTEM LOG]: " + message);
    }

    // Method to get current date & time (PARSED)
    public static LocalDateTime getCurrentDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        return LocalDateTime.parse(formattedDateTime, formatter);
    }

}
