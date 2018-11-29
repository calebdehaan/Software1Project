package graphicalUserInterface.loginPage;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageController {
	private Main main;
	
	@FXML
	private TextField usernameField;
	@FXML
	PasswordField passwordField;
	@FXML
	private TextField statusField;
	
	@FXML
	private void exitProgram() {
		System.exit(0);
	}
	
	@FXML
	private void initialize() {
		statusField.setEditable(false);
		statusField.setMouseTransparent(true);
		statusField.setFocusTraversable(false);
	}
	
	@FXML
	private void goToMain() throws Exception{
		if(usernameField.getText() != null && passwordField.getText() != null) {
			if("admin".equals(usernameField.getText().toLowerCase()) && "password".equals(passwordField.getText())) {
				statusField.setText("Correct credentials... logging in.");
				Thread.sleep(1000);
				main.showMainItems();
			} else {
				statusField.setText("Incorrect credentials... try again.");
			}
		}
		
	}
}
