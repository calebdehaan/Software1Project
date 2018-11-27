package graphicalUserInterface.playerStats;

import java.io.IOException;

import DataBase.Player;
import DataBase.StringOnlyPlayer;
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
	
	@FXML
	private TableView<StringOnlyPlayer> tableView = new TableView<StringOnlyPlayer>();
	
	@FXML
	public void initialize() {
		//set up the columns in the table

		TableColumn weightColumn = new TableColumn("weight");
		TableColumn heightColumn = new TableColumn("height");
		TableColumn ageColumn = new TableColumn("age");
		TableColumn nameColumn = new TableColumn("name");
		TableColumn dominantHandColumn = new TableColumn("domhand");
		TableColumn idColumn = new TableColumn("id");
		
		tableView.getColumns().addAll(weightColumn,heightColumn,ageColumn,nameColumn,dominantHandColumn,idColumn);
		
		weightColumn.setCellValueFactory(new PropertyValueFactory<Player, Weight>("weight"));
		heightColumn.setCellValueFactory(new PropertyValueFactory<Player, Height>("height"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("age"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		dominantHandColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("domhand"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Player, Long>("id"));
		
		
		//load dummy data
		tableView.setItems(getPlayers());
	}
	
	@FXML
	private void goHome() throws IOException {
		main.showMainItems();
	}
	
	// Height height, Weight weight, int age, String name, DominantHand domHand
	// this method will return an ObservableList of Player objects
	public ObservableList<StringOnlyPlayer> getPlayers(){
		ObservableList<StringOnlyPlayer> players = FXCollections.observableArrayList();
		Height height = new Height(3, 2);
		Weight weight = new Weight(34.10);
		Player tempPlayer = new Player(height, weight, 11, "John", DominantHand.Left);
		players.add(new StringOnlyPlayer(tempPlayer));
		tempPlayer = new Player(height, weight, 45, "Bill", DominantHand.Ambidextrous);
		players.add(new StringOnlyPlayer(tempPlayer));
		return players;
	}
}
