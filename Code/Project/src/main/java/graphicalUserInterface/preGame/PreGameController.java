package graphicalUserInterface.preGame;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import graphicalUserInterface.Main;
import graphicalUserInterface.game.GameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class PreGameController {
	private Main main;
	
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/TheProjectData";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Digby1097";
	
	private ObservableList<String> available;
	@FXML
	private ChoiceBox Player1;
	@FXML
	private ChoiceBox Player2;
	@FXML
	private ChoiceBox Player3;
	@FXML
	private ChoiceBox Player4;
	@FXML
	private ChoiceBox Player5;
	@FXML
	private ChoiceBox Player6;
	@FXML
	private ChoiceBox Player7;
	
	
	@FXML
	private void goCancel() throws IOException {
		main.showMainItems();
	}
	
	@FXML
	private void goGame() throws IOException, SQLException {
		ArrayList<String> tempArray = new ArrayList<String>();
		tempArray.add(Player1.getValue().toString());
		tempArray.add(Player2.getValue().toString());
		tempArray.add(Player3.getValue().toString());
		tempArray.add(Player4.getValue().toString());
		tempArray.add(Player5.getValue().toString());
		tempArray.add(Player6.getValue().toString());
		tempArray.add(Player7.getValue().toString());
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		statement.execute("Delete from theprojectdata.currentplayers");
		for(int i=0;i<tempArray.size();i++) {
			statement.execute("Insert into TheProjectData.CurrentPlayers values(\'" + (i+1) + "\', \'" + tempArray.get(i) + "\');");
		}
		main.showGameScene();
	}
	
	@FXML
	private void goTurnover() throws IOException {
		main.showTurnoverScene();
	}
	
	@FXML
	private void initialize() throws SQLException {
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		String query = "Select name from TheProjectData.Player";
		ArrayList<String> tempArray = new ArrayList<String>();
		ResultSet rs = statement.executeQuery(query);
		if(rs.next() != false) {
			do {
				System.out.println(rs.getString("name"));
				tempArray.add(rs.getString("name"));
			}while(rs.next());
		}
		System.out.println("howdy");
		available = FXCollections.observableArrayList(tempArray);
		Player1.setItems(available);
		Player2.setItems(available);
		Player3.setItems(available);
		Player4.setItems(available);
		Player5.setItems(available);
		Player6.setItems(available);
		Player7.setItems(available);
	}
	
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Failed to establish database");
			System.exit(-1);
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
}
