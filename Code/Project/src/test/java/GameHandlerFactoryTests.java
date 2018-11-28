import DataBase.GameHandler;
import DataBase.GameHandlerFactory;
import DataBase.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

public class GameHandlerFactoryTests {
    @Test
    @DisplayName("New Game")
    public void testNewGame() {
        Map<Long, Player> map = new HashMap<>();
        GameHandler g1, g2;

        g1 = GameHandlerFactory.newGame(map);
        g2 = GameHandlerFactory.newGame(map);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(g1),
                () -> Assertions.assertNotNull(g2),

                () -> Assertions.assertNotSame(g1, g2),
                () -> Assertions.assertEquals(g1, g2)
        );

    }
}
