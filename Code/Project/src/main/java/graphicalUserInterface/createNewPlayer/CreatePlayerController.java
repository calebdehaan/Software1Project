package graphicalUserInterface.createNewPlayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import DataBase.utility.DominantHand;
import graphicalUserInterface.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreatePlayerController {
	private static final String DB_DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/Database";
	private static final String DB_USER = "TheUser";
	private static final String DB_PASSWORD = "UserOnly";
	
	private Main main;

	private ObservableList<Integer> ageBoxList = FXCollections.observableArrayList(16, 17, 18, 19, 20, 21, 22, 23);
	private ObservableList<DominantHand> dominantHandBoxList = FXCollections.observableArrayList(DominantHand.Right,
			DominantHand.Left, DominantHand.Ambidextrous);

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
	private void goConfirm() throws IOException, SQLException {
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		String theQuery = "Insert into Player (Height, Weight, Age, Name, Hand, Passes, Completions, Catches, Scores, Injured, GamesPlayed)" +
		                  "Values (\'" + heightField.getText() + "\', \'" + weightField.getText() + "\', " + ageBox.getValue() + ", \'" +
		                  nameField.getText() + "\', \'" + dominantHandBox.getValue() + "\', 0, 0, 0, 0, 0, 0";
		statement.executeQuery(theQuery);
		main.showCreateNewPlayerVerificationScene();
		System.out.println("Hey");
	}
	
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
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
