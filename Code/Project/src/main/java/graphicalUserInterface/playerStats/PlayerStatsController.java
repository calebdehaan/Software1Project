package graphicalUserInterface.playerStats;

import java.io.IOException;

import DataBase.Player;
import DataBase.utility.DominantHand;
import DataBase.utility.Height;
import DataBase.utility.Weight;
import graphicalUserInterface.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerStatsController {
	private Main main;
	/*
	@FXML
	private TableView<Player> tableView;
	@FXML
	private TableColumn<Player, Weight> weightColumn;
	@FXML
	private TableColumn<Player, Height> heightColumn;
	@FXML
	private TableColumn<Player, String> ageColumn;
	@FXML
	private TableColumn<Player, String> dominantHandColumn;
	@FXML
	private TableColumn<Player, Long> idColumn;
	
	@FXML
	public void initialize() {
		//set up the columns in the table
		weightColumn.setCellValueFactory(new PropertyValueFactory<Player, Weight>("weight"));
		heightColumn.setCellValueFactory(new PropertyValueFactory<Player, Height>("height"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("age"));
		dominantHandColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("dom. hand"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Player, Long>("id"));
		
		//load dummy data
		tableView.setItems(getPlayers());
	}
	*/
	@FXML
	private void goHome() throws IOException {
		main.showMainItems();
	}
	/*
	// Height height, Weight weight, int age, String name, DominantHand domHand
	// this method will return an ObservableList of Player objects
	public ObservableList<Player> getPlayers(){
		ObservableList<Player> players = FXCollections.observableArrayList();
		Height height = new Height(3, 2);
		Weight weight = new Weight(34.10);
		players.add(new Player(height, weight, 11, "John", DominantHand.Left));
		players.add(new Player(height, weight, 45, "Bill", DominantHand.Ambidextrious));
		return players;
	}*/
}
