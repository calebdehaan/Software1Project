import DataBase.GameHandler;
import DataBase.GameHandlerFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.TreeMap;

public class GameHandlerTests {
    private GameHandler g1, g2;

    @BeforeAll
    public void setup() {
        g1 = GameHandlerFactory.newGame(new HashMap<>());
        g2 = GameHandlerFactory.newGame(new HashMap<>());
    }

    @Test
    @DisplayName("Valid Value Constructor")
    public void gameHandlerValueConstructorValid() {
        g1 = GameHandlerFactory.newGame(new HashMap<>());
        g2 = GameHandlerFactory.newGame(new TreeMap<>());
    }

    @Test
    @DisplayName("Invalid Value Constructor")
    public void gameHandlerValueConstructorInvalid() {
        Assertions.assertThrows(NullPointerException.class, () -> GameHandlerFactory.newGame(null));
    }

    @Test
    @DisplayName("Valid Equals")
    public void equalsTestValid(){
        Assertions.assertEquals(g1, g2);
    }

    @Test
    @DisplayName("Invalid Equals")
    public void equalsTestInvalid(){
        Assertions.assertThrows(Exception.class, () -> g1.equals(null));
    }
}
