package graphicalUserInterface.playerStats;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.fxml.FXML;

public class PlayerStatsController {
	private Main main;
	
	@FXML
	private void goHome() throws IOException {
		main.showMainItems();
	}
}
