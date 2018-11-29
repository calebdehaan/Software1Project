package graphicalUserInterface.loginPage;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.util.Pair;

public class LoginPageController {
	private Main main;
	
	@FXML
	private TextField usernameField;
	@FXML
	PasswordField passwordField;
	@FXML
	private Text statusField;
	
	private Pair<String, String> credentials = new Pair<>("admin", "password");
	
	
	@FXML
	private void exitProgram() {
		System.exit(0);
	}
	
	@FXML
	private void goToMain() throws Exception{
		if(usernameField.getText() != null && passwordField.getText() != null) {
			if(credentials.getKey().equals(usernameField.getText().toLowerCase()) && credentials.getValue().equals(passwordField.getText())) {
				main.showMainItems();
			} else {
				statusField.setFill(Color.rgb(255, 0, 0));
				statusField.setText("Incorrect credentials... try again.");
			}
		}
	}
}
