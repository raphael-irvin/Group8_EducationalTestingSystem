package group8.ets.controller;

import group8.ets.MainApp;
import group8.ets.Student;
import group8.ets.Utility;
import group8.ets.database.StudentDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jdk.jshell.execution.Util;

public class LoginController extends Controller{

    // Email field from Login.fxml (fx:id="emailField")
    @FXML
    private TextField emailField;

    // Password field from Login.fxml (fx:id="passwordField")
    @FXML
    private PasswordField passwordField;

    // Called when "Login" button is clicked
    @FXML
    private void handleLogin() {
        // Read input values
        String email = emailField.getText();
        String password = passwordField.getText();

        // Verify credentials against StudentDatabase
        boolean loginSuccessful = false;
        for (Student student : StudentDatabase.getInstance().getAllStudents()) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                loginSuccessful = true;
                Utility.log("Login successful for email: " + email);
                break;
            }
        }

        if (loginSuccessful) {
            try {
                // After successful login, go to Home page
                MainApp.switchScene("Home.fxml", "Educational Testing System - Home");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Utility.log("Login failed for email: " + email);
        }
    }

    // Called when "Don't have an account? Sign up" link is clicked
    @FXML
    private void handleGoToSignUp() {
        try {
            // Go to Sign Up page
            MainApp.switchScene("SignUp.fxml", "Educational Testing System - Sign Up");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
