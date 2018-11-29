package graphicalUserInterface.createNewPlayer;

import DataBase.utility.DominantHand;
import graphicalUserInterface.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreatePlayerController {
	public static final Logger logger = Logger.getLogger(CreatePlayerController.class.getName());
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/TheProjectData";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Digby1097";

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
		String theQuery = "INSERT INTO TheProjectData.Player (Height, Weight, Age, Name, Hand, Passes, Completions, Catches, Scores, Injured, GamesPlayed) "
				+ "Values (\'" + heightField.getText() + "\', \'" + weightField.getText() + "\', \'" + ageBox.getValue()
				+ "\', \'" + nameField.getText() + "\', \'" + dominantHandBox.getValue() + "\', \'0\', \'0\', \'0\', \'0\', \'0\', \'0\');";
		logger.log(Level.WARNING, theQuery);
		statement.execute(theQuery);
		logger.log(Level.WARNING, "executed");
		main.showCreateNewPlayerVerificationScene();
		logger.log(Level.WARNING, "Hey");
	}

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			logger.log(Level.WARNING, e.getMessage());
			logger.log(Level.WARNING, "Failed to establish database");
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
