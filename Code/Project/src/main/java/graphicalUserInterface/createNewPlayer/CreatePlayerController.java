package graphicalUserInterface.createNewPlayer;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.fxml.FXML;

public class CreatePlayerController {
	private Main main;
	
	@FXML
	private void goCancel() throws IOException {
		main.showMainItems();
	}
}
