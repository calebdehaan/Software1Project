package graphicalUserInterface.createNewPlayerVerification;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.fxml.FXML;

public class CreateNewPlayerVerificationController {
	private Main main;
	
	@FXML
	private void goHome() throws IOException {
		main.showMainItems();
	}
}
