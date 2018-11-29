package graphicalUserInterface.view;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.fxml.FXML;

public class MainItemsController {

	private Main main;
	
	@FXML
	private void goCreatePlayer() throws IOException {
		main.showCreatePlayerScene();
		
	}
	
	@FXML
	private void goPreGame() throws IOException{
		main.showPreGameScene();
	}
	
	@FXML
	private void goPlayerStats() throws IOException {
		main.showPlayerStatsScene();
	}
	
	@FXML
	private void exitProgram() {
		System.exit(0);
	}
}
