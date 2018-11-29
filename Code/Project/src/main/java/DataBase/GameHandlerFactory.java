package DataBase;

import java.util.Map;

// Factory
public class GameHandlerFactory {
	public static GameHandler newGame(Map<Long, Player> input) {
		return new GameHandler(input);
	}
}
