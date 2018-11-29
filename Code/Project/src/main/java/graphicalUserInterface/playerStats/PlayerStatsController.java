package graphicalUserInterface.playerStats;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DataBase.Player;
import DataBase.StringOnlyPlayer;
import DataBase.utility.DominantHand;
import DataBase.utility.Height;
import DataBase.utility.Weight;
import graphicalUserInterface.Main;
import graphicalUserInterface.createNewPlayer.CreatePlayerController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerStatsController {
	private Main main;
	public static final Logger logger = Logger.getLogger(PlayerStatsController.class.getName());
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/TheProjectData";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Digby1097";

	private ObservableList<String> available;

	@FXML
	private ChoiceBox PlayerSelected;

	@FXML
	private TextField id;
	@FXML
	private TextField name;
	@FXML
	private TextField height;
	@FXML
	private TextField age;
	@FXML
	private TextField weight;
	@FXML
	private TextField dominantHand;
	@FXML
	private TextField passes;
	@FXML
	private TextField completions;
	@FXML
	private TextField catches;
	@FXML
	private TextField scores;
	@FXML
	private TextField injured;
	@FXML
	private TextField games;

	@FXML
	private void goHome() throws IOException {
		main.showMainItems();
	}

	@FXML
	private void initialize() throws SQLException {
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		String query = "Select name from TheProjectData.Player";
		ArrayList<String> tempArray = new ArrayList<String>();
		ResultSet rs = statement.executeQuery(query);
		if (rs.next() != false) {
			do {
				tempArray.add(rs.getString("name"));
			} while (rs.next());
		}
		available = FXCollections.observableArrayList(tempArray);
		PlayerSelected.setItems(available);
	}

	@FXML
	private void getStats() throws SQLException {
		if (PlayerSelected != null) {
			String query = "Select * from TheProjectData.Player where name = \"" + PlayerSelected.getValue() + "\"";
			Connection dbConnection = getDBConnection();
			Statement statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if (rs.next() != false) {
				id.setText(rs.getString("idPlayer").toString());
				height.setText(rs.getString("Height").toString());
				weight.setText(rs.getString("Weight").toString());
				age.setText(rs.getString("Age").toString());
				name.setText(rs.getString("Name").toString());
				dominantHand.setText(rs.getString("Hand").toString());
				passes.setText(rs.getString("Passes").toString());
				completions.setText(rs.getString("Completions").toString());
				catches.setText(rs.getString("Catches").toString());
				scores.setText(rs.getString("Scores").toString());
				String tempInjuredString = rs.getString("Injured").toString();
				if ("0".equals(tempInjuredString)) {
					injured.setText("no");
				} else {
					injured.setText("yes");
				}
				games.setText(rs.getString("GamesPlayed").toString());
			}
		}
	}

	@FXML
	private void updateStats() throws SQLException {
		if (PlayerSelected != null) {
			String tempInjuredString = new String();
			if ("no".equals(injured.getText().toLowerCase()) || "0".equals(injured.getText())) {
				tempInjuredString = "0";
			} else {
				tempInjuredString = "1";
			}
			String query = "Update TheProjectData.Player" + " SET Name = \"" + name.getText() + "\", Height = \""
					+ height.getText() + "\", Weight = \"" + weight.getText() + "\", Age = \"" + age.getText()
					+ "\", Hand = \"" + dominantHand.getText() + "\", Passes = \"" + passes.getText()
					+ "\", Completions = \"" + completions.getText() + "\", Catches = \"" + catches.getText()
					+ "\", Scores = \"" + scores.getText() + "\", Injured = \"" + tempInjuredString
					+ "\", GamesPlayed = \"" + games.getText() + "\" WHERE idPlayer = \"" + id.getText() + "\"";
			Connection dbConnection = getDBConnection();
			Statement statement = dbConnection.createStatement();
			statement.executeUpdate(query);
		}
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
			logger.log(Level.WARNING, e.getMessage());
		}
		return dbConnection;
	}
}
