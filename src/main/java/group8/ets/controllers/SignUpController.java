package group8.ets.controllers;

import group8.ets.MainApp;
import group8.ets.Student;
import group8.ets.Utility;
import group8.ets.databases.StudentDatabase;
import group8.ets.services.AuthService;
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

        // Redirect to Log in screen after successful sign up
        if (AuthService.getInstance().register(name, email, password)) {
            try {
                // After successful sign up, go back to Login screen
                MainApp.switchScene("Login.fxml", "Educational Testing System - Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // TODO: Implement Warning Panel for Invalid Credentials
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
