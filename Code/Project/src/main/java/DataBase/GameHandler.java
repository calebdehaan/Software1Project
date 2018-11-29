package DataBase;

import ActionPackage.Action;
import ActionPackage.ActionEnum;
import ActionPackage.ActionVisitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

// toString uses StringBuilder, which uses the Builder Design Pattern.
public class GameHandler extends GameHandlerFactory{
    private static final String DB_DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost/Database";
    private static final String DB_USER = "TheUser";
    private static final String DB_PASSWORD = "UserOnly";

    private Map<Long, Player> playerList;
    private Deque<Action> stack = new ArrayDeque<>();

    protected GameHandler() {
        this(new HashMap<>());
    }

    protected GameHandler(Map<Long, Player> roster) {
        playerList = Objects.requireNonNull(roster);
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
     * Records in database.
     */
    public void recordAll() throws SQLException {
        ActionVisitor visitor = new ActionVisitor(playerList);
        Connection dbConnection;
        Statement statement;
        String query;

        while (!stack.isEmpty()) {
            stack.getFirst().visit(visitor);
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            //System.out.println(stack.getFirst().getId());
            if (stack.getFirst().getActionName().equals(ActionEnum.PASSCOMPLETE)) {
                query = "UPDATE Player SET Passes = Passes + 1, Completions = Completions + 1 WHERE idPlayer = " + stack.getFirst().getId();
                //System.out.println(query);
            }
            stack.removeFirst();
        }
    }

    /**
     * Establishes a connection to the database
     *
     * @return a connection to the database
     */
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameHandler that = (GameHandler) o;

        if (playerList != null && !playerList.isEmpty())
            if (!Objects.equals(playerList, that.playerList))
                return false;

        if (stack != null && !stack.isEmpty())
            if (!Objects.equals(stack, that.stack))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerList, stack);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Game Handler\nPlayer List:");

        if (this.playerList != null) {
            for (Player p : playerList.values()) {
                builder.append("\t").append(p.toString());
            }
            builder.append("\n");
        } else {
            builder.append("\tnull\n");
        }

        return builder.toString();
    }
}
