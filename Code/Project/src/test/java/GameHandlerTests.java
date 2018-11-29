import DataBase.GameHandler;
import DataBase.GameHandlerFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;

public class GameHandlerTests {
    private GameHandler g1, g2;

    @BeforeAll
    public void setup(){
        g1 = GameHandlerFactory.newGame(new HashMap<>());
        g2 = GameHandlerFactory.newGame(new HashMap<>());
    }

    @Test
    @DisplayName("Valid Value Constructor")
    public void gameHandlerValueConstructorValid(){
        g1 = GameHandlerFactory.newGame(new HashMap<>());
    }

    @Test
    @DisplayName("Invalid Value Constructor")
    public void gameHandlerValueConstructorInvalid(){
        Assertions.assertThrows(NullPointerException.class, () -> GameHandlerFactory.newGame(null));
    }


}
