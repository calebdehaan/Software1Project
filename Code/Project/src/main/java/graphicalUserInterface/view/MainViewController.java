package graphicalUserInterface.view;

import java.io.IOException;

import graphicalUserInterface.Main;
import javafx.fxml.FXML;

public class MainViewController {
	private Main main;

	@FXML
	private void goHome() throws IOException {
		main.showMainItems();
	}

}
