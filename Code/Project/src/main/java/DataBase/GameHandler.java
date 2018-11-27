package DataBase;

import ActionPackage.Action;
import ActionPackage.ActionEnum;
import ActionPackage.ActionVisitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class GameHandler {
	private static final String DB_DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/Database";
	private static final String DB_USER = "TheUser";
	private static final String DB_PASSWORD = "UserOnly";

	private Map<Long, Player> playerList;
	private Deque<Action> stack = new ArrayDeque<Action>();

	GameHandler(Map<Long, Player> roster) {
		playerList = roster;
	}

	public void newAction(Action a) {
		stack.add(a);
	}

	/**
	 * Removes last action completed from the stack.
	 *
	 * @param a
	 */
	public void undo(Action a) {
		stack.removeLast();
	}

	/**
	 * Calculates stats from the actions done throughout the game.
	 */
	public void recordAll() throws SQLException {
		ActionVisitor visitor = new ActionVisitor(playerList);
		Connection dbConnection = null;
		Statement statement = null;
		String theQuery = "";
		System.out.println("HEY");

		while (!stack.isEmpty()) {
			stack.getFirst().visit(visitor);
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(stack.getFirst().getId());
			if(stack.getFirst().getActionName().equals(ActionEnum.PASSCOMPLETE)) {
				theQuery = "UPDATE Player SET Passes = Passes + 1, Completions = Completions + 1 WHERE idPlayer = " + stack.getFirst().getId();
				System.out.println(theQuery);
			}
			stack.removeFirst();
		}
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
