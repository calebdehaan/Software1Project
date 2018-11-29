package graphicalUserInterface.game;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import graphicalUserInterface.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class GameController {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/TheProjectData";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Digby1097";
	
	private Main main;
	
	private ObservableList<String> playerList;
	
	@FXML
	private ChoiceBox Players;
	
	@FXML
	private TextField textBox;
	
	@FXML
	public void initialize() throws IOException, SQLException {
		ArrayList<String> tempArray = new ArrayList<String>();
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		ResultSet rs = statement.executeQuery("Select name from theprojectdata.currentplayers");
		if(rs.next() != false) {
			do {
				tempArray.add(rs.getString("name").toString());
			}while(rs.next());
		}
		playerList = FXCollections.observableArrayList(tempArray);
		playerList.get(0);
		Players.setItems(playerList);
		textBox.setText(playerList.get(0));
	}
	
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
	
	@FXML
	private void goCompletion() {
		
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
