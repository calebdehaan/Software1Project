package DataBase;

import ActionPackage.Action;
import ActionPackage.ActionEnum;
import ActionPackage.ActionVisitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// toString uses StringBuilder, which uses the Builder Design Pattern.
public class GameHandler extends GameHandlerFactory{
    public static final Logger logger = Logger.getLogger(GameHandler.class.getName());
    private static final String DB_DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost/Database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Digby1097";

    private Map<Long, Player> playerList;
    private Deque<Action> stack = new ArrayDeque<>();

    public GameHandler() {
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
    public void undo() {
        stack.removeLast();
    }

    /**
     * Calculates stats from the actions done throughout the game.
     * Records in database.
     */
    public void recordAll() throws SQLException {
        Connection dbConnection;
        Statement statement;
        System.out.println("hey");

        while (!stack.isEmpty()) {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            if (stack.getFirst().getActionName().equals(ActionEnum.PASSCOMPLETE)) {
                statement.execute("update theprojectdata.player set passes = passes + 1, completions = completions + 1 where idPlayer = \'" + stack.getFirst().getId() + "\';");
            } else if(stack.getFirst().getActionName().equals(ActionEnum.PASSFAIL)) {
            	statement.execute("update theprojectdata.player set passes = passes + 1 where idPlayer = \'" + stack.getFirst().getId() + "\';");
            } else if(stack.getFirst().getActionName().equals(ActionEnum.INJURY)) {
            	statement.execute("update theprojectdata.player set injured = '1' where idPlayer = \'" + stack.getFirst().getId() + "\';");
            } else if(stack.getFirst().getActionName().equals(ActionEnum.CATCH)) {
            	statement.execute("update theprojectdata.player set catches = catches + 1 where idPlayer = \'" + stack.getFirst().getId() + "\';");
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
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        try {
            return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        return null;
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
