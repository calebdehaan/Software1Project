package graphicalUserInterface.game;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.fxml.FXML;

public class GameController {
	private Main main;
	
	//@FXML
	
	
	@FXML
	private void goCancel() throws IOException {
		main.showMainItems();
	}
	
	@FXML
	private void goGameOver() throws IOException {
		main.showGameOverScene();
	}
	
	@FXML
	private void goTurnover() throws IOException {
		main.showTurnoverScene();
	}
}
