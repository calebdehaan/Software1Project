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
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTests {
    private static final int NUM_TESTS = 100;
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static Player validPlayer, twin1, twin2;


    @BeforeAll
    static void setup() {
        validPlayer = new Player(new Height(6, 3), new Weight(180), 22, "Tobin", DominantHand.Right);
    }

    /**
     * Generates a random integer between lower and upper, inclusive
     *
     * @param lower lower bound
     * @param upper upper bound
     * @return See desc.
     */
    private static int randInt(int lower, int upper) {
        Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }

    /**
     * Generates a random double between lower and upper, inclusive
     *
     * @param lower lower bound
     * @param upper upper bound
     * @return See desc.
     */
    private static double randDouble(double lower, double upper) {
        Random random = new Random();
        return (random.nextDouble() * (upper - lower)) + lower;
    }

    /**
     * Generates a random Alpha-Numeric string of length "length"
     *
     * @param length how long the result should be
     * @return See desc.
     */
    private static String randomString(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = randInt(0, ALPHA_NUMERIC_STRING.length() - 1);
            builder.append(ALPHA_NUMERIC_STRING.charAt(index));
        }
        return builder.toString();
    }


    @TestFactory
    List<DynamicTest> valueConstructorTestsValid() {
        List<DynamicTest> result = new ArrayList<>(NUM_TESTS);

        for (int i = 0; i < NUM_TESTS; i++) {
            result.add(DynamicTest.dynamicTest("Valid Player #" + i, () -> {
                Height height = new Height(randInt(0, 10), randInt(0, 100));
                Weight weight = new Weight(randDouble(Player.WEIGHT_MIN, Player.WEIGHT_MAX));
                int age = randInt(Player.AGE_MIN, Player.AGE_MAX);
                String name = "Player";
                DominantHand hand = DominantHand.values()[randInt(0, 2)];

                new Player(height, weight, age, name, hand);
            }));
        }

        return result;
    }

    @TestFactory
    List<DynamicTest> valueConstructorTestsInvalid() {
        List<DynamicTest> result = new ArrayList<>(NUM_TESTS);

        for (int i = 0; i < NUM_TESTS - 2; i++) {
            result.add(DynamicTest.dynamicTest("Invalid Player #" + i, () -> {
                Height height = new Height(randInt(-20, 20), randInt(-100, 100));
                Weight weight = new Weight((new Random()).nextDouble());
                int age = (new Random()).nextInt();
                String name = randomString(randInt(0, 100));
                DominantHand hand = DominantHand.values()[randInt(0, 2)];

                assertThrows(Exception.class, () -> new Player(height, weight, age, name, hand));
            }));
        }

        // Null Name
        result.add(DynamicTest.dynamicTest("Invalid Player #" + (NUM_TESTS - 2), () -> {
            Height height = new Height((int) (Math.random() * 2), (int) (Math.random() * 2));
            Weight weight = new Weight((new Random()).nextDouble());
            int age = (new Random()).nextInt();
            DominantHand hand = DominantHand.values()[randInt(0, 2)];

            assertThrows(Exception.class, () -> new Player(height, weight, age, null, hand));
        }));

        // Empty Name
        result.add(DynamicTest.dynamicTest("Invalid Player #" + (NUM_TESTS - 1), () -> {
            Height height = new Height((int) (Math.random() * 2), (int) (Math.random() * 2));
            Weight weight = new Weight((new Random()).nextDouble());
            int age = (new Random()).nextInt();
            String name = "";
            DominantHand hand = DominantHand.values()[randInt(0, 2)];

            assertThrows(Exception.class, () -> new Player(height, weight, age, name, hand));
        }));

        return result;
    }

    @Test
    @DisplayName("Valid Default Constructor")
    void defaultConstructorTestValid() {
        twin1 = new Player("Twin");
        twin2 = new Player("Twin");
    }

    @Test
    @DisplayName("Invalid Default Constructor")
    void defaultConstructorTestInvalid() {
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

