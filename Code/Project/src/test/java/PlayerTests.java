import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerTests {

    @ParameterizedTest
    @DisplayName("Default Constructor")
    @CsvSource({"name, 22"})
    void playerConstructorTest(String name, int age) {

    }
}

