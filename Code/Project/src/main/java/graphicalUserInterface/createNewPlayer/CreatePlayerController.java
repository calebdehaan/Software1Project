package graphicalUserInterface.createNewPlayer;

import java.io.IOException;

import DataBase.utility.DominantHand;
import graphicalUserInterface.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreatePlayerController {
	private Main main;
	
	private ObservableList<Integer> ageBoxList = FXCollections.observableArrayList(16,17,18,19,20,21,22,23);
	private ObservableList<DominantHand> dominantHandBoxList = FXCollections.observableArrayList(DominantHand.Right, DominantHand.Left, DominantHand.Ambidextrous);
	
	@FXML
	private TextField nameField;
	@FXML
	private TextField weightField;
	@FXML
	private TextField heightField;
	@FXML
	private ChoiceBox ageBox;
	@FXML
	private ChoiceBox dominantHandBox;
	
	@FXML
	private void initialize() {
		ageBox.setValue(18);
		ageBox.setItems(ageBoxList);
		dominantHandBox.setValue(DominantHand.Right);
		dominantHandBox.setItems(dominantHandBoxList);
	}
	
	@FXML
	private void goCancel() throws IOException {
		main.showMainItems();
	}
	
	@FXML
	private void goConfirm() throws IOException {
		main.showCreateNewPlayerVerificationScene();
	}
}
