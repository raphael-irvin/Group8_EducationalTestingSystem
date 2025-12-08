package group8.ets.controller;

import group8.ets.MainApp;
import group8.ets.Student;
import group8.ets.Utility;
import group8.ets.database.StudentDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController extends Controller{

    // Text field for the user's email (connected to fx:id="emailField" in SignUp.fxml)
    @FXML
    private TextField emailField;

    // Password field for the user's password (fx:id="passwordField")
    @FXML
    private PasswordField passwordField;

    // Text field for the user's name / username (fx:id="nameField")
    @FXML
    private TextField nameField;

    // This method is called automatically after the FXML is loaded
    @FXML
    private void initialize() {
        // You can put default values or setup code here if needed
        // For now, we leave it empty
    }

    // Triggered when the "SignUp" button is pressed
    @FXML
    private void handleSignUp() {
        // Read values from the form
        String email = emailField.getText();
        String password = passwordField.getText();
        String name = nameField.getText();

        // Make sure email, password, and name are not empty (basic validation)
        if (!email.isEmpty() || !password.isEmpty() || !name.isEmpty()) {
            Utility.log("SignUp attempt with email: " + email + ", name: " + name);
            // Make sure email is not already used
            for (Student student : StudentDatabase.getInstance().getAllStudents()) {
                if (student.getEmail().equals(email)) {
                    Utility.log("SignUp failed: Email already in use - " + email);
                    return; // Exit if email is already taken
                }
            }

            // Create new Student and add to database
            Student newStudent = new Student(name, email, password);

            // Redirect to Login screen after successful sign up
            try {
                // After successful sign up, go back to Login screen
                MainApp.switchScene("Login.fxml", "Educational Testing System - Login");
            } catch (Exception e) {
                e.printStackTrace();
            }

        // If Email, Password, or Name is empty
        } else {
            Utility.log("SignUp failed: All fields are required.");
        }
    }

    // Triggered when the "Login with existing account" hyperlink is pressed
    @FXML
    private void handleGoToLogin() {
        try {
            MainApp.switchScene("Login.fxml", "Educational Testing System - Login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
