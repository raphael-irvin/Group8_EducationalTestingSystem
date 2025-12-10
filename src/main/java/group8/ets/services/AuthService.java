package group8.ets.services;

/*
CLASS INFORMATION:
The AuthService class is responsible for handling authentication-related operations such as user login, registration, and session management.
It will interact with the student database to verify credentials and manage user access to the Educational Testing System.
It is singleton in nature, ensuring that only one instance of AuthService exists throughout the application lifecycle.
 */

import group8.ets.Student;
import group8.ets.Utility;
import group8.ets.databases.StudentDatabase;

public class AuthService {

    // Singleton Instance
    private static AuthService instance = null;

    // Private Constructor to prevent instantiation
    private AuthService() {
    }

    // Method to get the Singleton Instance
    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    // AUTHENTICATION METHODS
    // Login Method
    public boolean login(String email, String password) {
        // Verify credentials against StudentDatabase
        boolean loginSuccessful = false;
        for (Student student : StudentDatabase.getInstance().getAllStudents()) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                loginSuccessful = true;
                Utility.log("Login successful for email: " + email);
                break;
            }
        }
        if (!loginSuccessful) {
            Utility.log("Login failed for email: " + email);
        }
        return loginSuccessful;
    }

    // Registration Method
    public boolean register(String name, String email, String password) {
        // Make sure email, password, and name are not empty (basic validation)
        if (!email.isEmpty() || !password.isEmpty() || !name.isEmpty()) {
            Utility.log("SignUp attempt with email: " + email + ", name: " + name);
            // Make sure email is not already used
            for (Student student : StudentDatabase.getInstance().getAllStudents()) {
                if (student.getEmail().equals(email)) {
                    Utility.log("SignUp failed: Email already in use - " + email);
                    return false; // Exit if email is already taken
                }
            }

            // Create new Student and add to database
            Student newStudent = new Student(name, email, password);
            Utility.log("SignUp successful for email: " + email);
            return true;
        }
        Utility.log("SignUp failed: Missing fields - email: " + email + ", name: " + name);
        return false;
    }

}
