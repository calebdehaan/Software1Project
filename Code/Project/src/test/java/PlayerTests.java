import DataBase.Player;
import DataBase.utility.DominantHand;
import DataBase.utility.Height;
import DataBase.utility.Weight;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {
    private static final int NUM_TESTS = 100;

    private static Player validPlayer, twin1, twin2;
    private static List<DynamicTest> validPlayers, invalidPlayers;


    @BeforeAll
    static void setup(){
        validPlayer = new Player(new Height(6, 3), new Weight(180), 22, "Tobin", DominantHand.Right);
        validPlayers = generateValidPlayers();
        invalidPlayers = generateInvalidPlayers();
    }

    @TestFactory
    static List<DynamicTest> generateValidPlayers(){
        List<DynamicTest> result = new ArrayList<>(NUM_TESTS);

        for(int i = 0; i < NUM_TESTS; i++){
            result.add(DynamicTest.dynamicTest("Valid Player #" + i, () -> {
                Height height = new Height((int) (Math.random() * 2), (int) (Math.random() * 2));
                Weight weight = new Weight((new Random()).nextDouble());
                int age = ((new Random()).nextInt() + Player.AGE_MIN) % Player.AGE_MAX;
                String name = "Player";
                DominantHand hand = DominantHand.values()[(new Random()).nextInt() % 2]; // TODO: 2 or 3?

                new Player(height, weight, age, name, hand);
            }));
        }

        return result;
    }

    @TestFactory
    static List<DynamicTest> generateInvalidPlayers(){
        List<DynamicTest> result = new ArrayList<>(NUM_TESTS);

        for(int i = 0; i < NUM_TESTS - 2; i++){
            result.add(DynamicTest.dynamicTest("Invalid Player #" + i, () -> {
                Height height = new Height((int) (Math.random() * 2), (int) (Math.random() * 2));
                Weight weight = new Weight((new Random()).nextDouble());
                int age = (new Random()).nextInt();
                String name = "Player".substring((new Random()).nextInt() % "Player".length());
                DominantHand hand = DominantHand.values()[(new Random()).nextInt() % 2]; // TODO: 2 or 3?

                new Player(height, weight, age, name, hand);
            }));
        }

        result.add(DynamicTest.dynamicTest("Invalid Player #" + (NUM_TESTS - 2), () -> {
            Height height = new Height((int) (Math.random() * 2), (int) (Math.random() * 2));
            Weight weight = new Weight((new Random()).nextDouble());
            int age = (new Random()).nextInt();
            DominantHand hand = DominantHand.values()[(new Random()).nextInt() % 2]; // TODO: 2 or 3?

            new Player(height, weight, age, null, hand);
        }));

        result.add(DynamicTest.dynamicTest("Invalid Player #" + (NUM_TESTS - 1), () -> {
            Height height = new Height((int) (Math.random() * 2), (int) (Math.random() * 2));
            Weight weight = new Weight((new Random()).nextDouble());
            int age = (new Random()).nextInt();
            String name = "";
            DominantHand hand = DominantHand.values()[(new Random()).nextInt() % 2]; // TODO: 2 or 3?

            new Player(height, weight, age, name, hand);
        }));

        return result;
    }

    @Test
    @DisplayName("Valid Default Constructor")
    void defaultConstructorTestValid(){
        twin1 = new Player("Twin");
        twin2 = new Player("Twin");
    }

    @Test
    @DisplayName("Invalid Default Constructor")
    void defaultConstructorTestInvalid(){
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> twin1 = new Player("")),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> twin2 = new Player(null))
        );
    }

    @ParameterizedTest
    @DisplayName("Valid Name Only Constructor")
    @CsvSource({"name, 22", "NAME, 53", "nombre, 41", "ጄሰንሰን, 20", "Ջեյմոն, 20", "ジェイムソン, 20", "제임슨, 20"})
    void nameOnlyConstructorTestValid(String name, int age) {
        Player p = new Player(name);
        assertEquals(name, p.getName());
    }

    @Test
    @DisplayName("Invalid Name Only Constructor")
    void nameOnlyConstructorTestInvalid() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(null)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(""))
        );
    }

    @Test
    @DisplayName("Valid Full Constructor")
    void constructorTestValid(){

    }

    @Test
    @DisplayName("Invalid Full Constructor")
    void constructorTestInvalid(){

    }


    @Test
    @DisplayName("Valid Clone")
    void cloneTestValid() {
        Player clone = validPlayer.clone();
        Assertions.assertEquals(validPlayer, clone);
    }

    @Test
    @DisplayName("Invalid Clone")
    void cloneTestInvalid() {
        Assertions.assertThrows(NullPointerException.class, () -> ((Player) null).clone());
    }
}

