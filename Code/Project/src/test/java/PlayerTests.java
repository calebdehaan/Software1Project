import DataBase.Player;
import DataBase.utility.DominantHand;
import DataBase.utility.Height;
import DataBase.utility.Weight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {
    
    @ParameterizedTest
    @DisplayName("Default Constructor")
    @CsvSource({"name, 22"})
    void playerConstructorTest(String name, int age) {
        Player p = new Player(name);
        assertEquals(name, p.getName());
    }
    
    @Test
    @DisplayName("Clone - Valid")
    void cloneTestValid() {
        Player testSubject = new Player(new Height(6, 3), new Weight(180), 22, "Tobin", DominantHand.Right);
        Player clone = testSubject.clone();
    
        Assertions.assertEquals(testSubject, clone);
    }
}

