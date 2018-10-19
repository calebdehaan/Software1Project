import DataBase.Player;

import java.util.Map;

public class GameHandlerFactory {
    public static GameHandler newGame(Map<Long, Player> input) {
        return new GameHandler(input);
    }
}
