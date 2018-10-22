package graphicalUserInterface.gameOver;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.fxml.FXML;

public class GameOverController {
	private Main main;
	
	@FXML
	private void goFinished() throws IOException {
		main.showMainItems();
	}
}
