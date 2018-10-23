package graphicalUserInterface.preGame;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.fxml.FXML;

public class PreGameController {
	private Main main;
	
	@FXML
	private void goCancel() throws IOException {
		main.showMainItems();
	}
	
	@FXML
	private void goGame() throws IOException {
		main.showGameScene();
	}
	
	@FXML
	private void goTurnover() throws IOException {
		main.showTurnoverScene();
	}
}
