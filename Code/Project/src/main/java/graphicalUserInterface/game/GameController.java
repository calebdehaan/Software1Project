package graphicalUserInterface.game;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ActionPackage.Action;
import ActionPackage.Catch;
import ActionPackage.Injury;
import ActionPackage.PassTo;
import DataBase.GameHandler;
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

	GameHandler gh = new GameHandler();

	private ObservableList<String> playerList;

	@FXML
	private ChoiceBox Players;

	@FXML
	private ChoiceBox Players1;

	@FXML
	private TextField textBox;

	private String prev;

	private String previousPrev;

	@FXML
	public void initialize() throws IOException, SQLException {
		ArrayList<String> tempArray = new ArrayList<String>();
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		ResultSet rs = statement.executeQuery("Select name from theprojectdata.currentplayers");
		if (rs.next() != false) {
			do {
				tempArray.add(rs.getString("name").toString());
			} while (rs.next());
		}
		playerList = FXCollections.observableArrayList(tempArray);
		Players.setItems(playerList);
		Players1.setItems(playerList);
		textBox.setText(playerList.get(0));
		prev = textBox.getText().toString();
		previousPrev = prev;
	}

	@FXML
	private void goCancel() throws IOException {
		main.showMainItems();
	}

	@FXML
	private void goGameOver() throws IOException, SQLException {
		gh.recordAll();
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		statement.execute("Update theprojectdata.player set gamesplayed = gamesplayed + 1");
		main.showGameOverScene();
	}

	@FXML
	private void goPenalty() {
		gh.undo();
		textBox.setText(previousPrev);
		prev = previousPrev;
	}

	@FXML
	private void goInjury() throws SQLException {
		if (!Players1.getValue().toString().equals(null)) {
			Connection dbConnection = getDBConnection();
			Statement statement = dbConnection.createStatement();
			Injury i = null;
			ResultSet rs = statement.executeQuery("Select idPlayer from theprojectdata.currentplayers where name = \'"
					+ Players1.getValue().toString() + "\';");
			if (rs.next() != false) {
				i = new Injury(rs.getLong("idPlayer"), Players1.getValue().toString() + " was injured");
				gh.newAction(i);
			}
		} else {
			System.out.println("Lit");
		}
	}

	@FXML
	private void goTurnover() throws IOException, SQLException {
		String temp = Players.getValue().toString();
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		PassTo pt;
		ResultSet rs = statement
				.executeQuery("Select idPlayer from theprojectdata.currentplayers where name = \'" + prev + "\';");
		if (rs.next() != false) {
			do {
				pt = new PassTo(rs.getLong("idPlayer"), prev + " failed to pass");
				gh.newAction(pt);
			} while (rs.next());
		}
		main.showTurnoverScene();
	}

	@FXML
	private void goCompletion() throws SQLException {
		String temp = Players.getValue().toString();
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		PassTo pt;
		Long id = null;
		Catch c;
		ResultSet r1 = statement
				.executeQuery("Select idPlayer from theprojectdata.currentplayers where name = \'" + prev + "\';");
		if (r1.next() != false) {
			id = r1.getLong("idPlayer");
		}
		ResultSet rs = statement
				.executeQuery("Select idPlayer from theprojectdata.currentplayers where name = \'" + temp + "\';");
		if (rs.next() != false) {
			do {
				pt = new PassTo(id, rs.getLong("idPlayer"), prev + " passed to " + temp);
				c = new Catch(rs.getLong("idPlayer"), temp + " caught a pass");
				gh.newAction(pt);
				gh.newAction(c);
			} while (rs.next());
		}
		previousPrev = prev;
		prev = temp;
		textBox.setText(Players.getValue().toString());
	}

	@FXML
	private void goScore() throws SQLException, IOException {
		gh.recordAll();
		main.showPreGameScene();
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

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public String getPreviousPrev() {
		return previousPrev;
	}

	public void setPreviousPrev(String previousPrev) {
		this.previousPrev = previousPrev;
	}
}
