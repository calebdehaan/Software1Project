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
    private static Player validPlayer, invalidPlayer;
    private static Height validHeight, invalidHeight;
    private static Weight validWeight, invalidWeight;
    private static int validAge, invalidAge;
    private static String validName, invalidName;
    private static DominantHand validHand, invalidHand;


    @BeforeAll
    static void setup() {
        validHeight = new Height(6, 3);
        invalidHeight = new Height(-10, 1);

        validWeight = new Weight(180.7);
        invalidWeight = new Weight(-10);

        validName = "Tobin";
        invalidName = "";

        validAge = 22;
        invalidAge = -1;

        validHand = DominantHand.Right;
        invalidHand = null;

        validPlayer = new Player(validHeight, validWeight, validAge, validName, validHand);
        invalidPlayer = null;
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

    /**
     * Given two options, returns one pseudo-randomly.
     *
     * @param opt1 The first option
     * @param opt2 The second option
     * @param <T>  The choices' type
     * @return See desc.
     */
    private static <T> T choose(T opt1, T opt2) {
        int choice = randInt(1, 2);
        switch (choice) {
            case 1:
                return opt1;
            case 2:
                return opt2;
            default:
                System.err.println("Error: Invalid choice: " + choice);
                return null;
        }
    }

    @TestFactory
    @DisplayName("Valid Value Constructor")
    List<DynamicTest> valueConstructorTestsValid() {
        List<DynamicTest> result = new ArrayList<>(NUM_TESTS);

        for (int i = 0; i < NUM_TESTS; i++) {
            result.add(DynamicTest.dynamicTest("Valid Player #" + i, () -> {
                Height height = new Height(randInt(0, 10), randInt(0, 100));
                Weight weight = new Weight(randDouble(Player.WEIGHT_MIN.getWeight(), Player.WEIGHT_MAX.getWeight()));
                int age = randInt(Player.AGE_MIN, Player.AGE_MAX);
                String name = "Player";
                DominantHand hand = DominantHand.values()[randInt(0, 2)];

                new Player(height, weight, age, name, hand);
            }));
        }

        return result;
    }

    @TestFactory
    @DisplayName("Invalid Value Constructor")
    List<DynamicTest> valueConstructorTestsInvalid() {
        List<DynamicTest> result = new ArrayList<>(NUM_TESTS);

        for (int i = 0; i < NUM_TESTS - 2; i++) {
            result.add(DynamicTest.dynamicTest("Invalid Player #" + i, () -> {
                Height height = choose(invalidHeight, validHeight);
                Weight weight = choose(invalidWeight, validWeight);
                int age = choose(invalidAge, validAge);
                String name = choose(invalidName, validName);
                DominantHand hand = choose(invalidHand, validHand);

                // TODO: Select one property at a time to be invalid; get value from list?
                assertThrows(Exception.class, () -> new Player(
                                choose(null, height),
                                choose(null, weight),
                                choose(-100, age),
                                choose(null, name),
                                choose(null, hand)
                        )
                );
            }));
        }

        return result;
    }

    @Test
    @DisplayName("Valid Default Constructor")
    void defaultConstructorTestValid() {
        Player p = new Player("Twin");
    }

    @Test
    @DisplayName("Invalid Default Constructor")
    void defaultConstructorTestInvalid() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> invalidPlayer = new Player("")),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> invalidPlayer = new Player(null))
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

    @Test
    @DisplayName("Valid Equals")
    void equalsTestValid(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(new Player("Name"), new Player("Name")),
                () -> Assertions.assertEquals(validPlayer, validPlayer.clone())
        );
    }

    @Test
    @DisplayName("Invalid Equals")
    void equalsTestInvalid(){
        Assertions.assertAll(
                () -> Assertions.assertNotEquals(new Player("Name"), new Player("Nombre")),
                () -> Assertions.assertNotEquals(validPlayer, new Player("Cerny")),
                () -> Assertions.assertNotEquals(validPlayer, null)
        );
    }
}

