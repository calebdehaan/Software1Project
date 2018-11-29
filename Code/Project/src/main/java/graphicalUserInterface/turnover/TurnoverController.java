package graphicalUserInterface.turnover;

import java.io.IOException;

import graphicalUserInterface.Main;
import graphicalUserInterface.game.GameController;
import javafx.fxml.FXML;

public class TurnoverController {
	private Main main;
	
	@FXML
	private void goCancel() throws IOException {
		main.showMainItems();
	}
	
	@FXML
	private void goGameOver() throws IOException {
		main.showGameOverScene();
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
