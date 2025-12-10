package group8.ets.controllers;

import group8.ets.MainApp;
import group8.ets.Utility;
import group8.ets.services.AuthService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

        if (AuthService.getInstance().login(email, password)) {
            try {
                // After successful login, go to Home page
                MainApp.switchScene("Home.fxml", "Educational Testing System - Home");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            // TODO: Implement Warning Panel for Invalid Credentials
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
