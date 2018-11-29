import ActionPackage.Scored;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class ScoredTests {
    @Test
    @DisplayName("Valid Value Constructor")
    public void defaultConstructorTestValid() {
        Assertions.assertNotNull(new Scored(0L, "none"));
    }

    @Test
    @DisplayName("Invalid Value Constructor")
    public void defaultConstructorTestInvalid() {
        Assertions.assertThrows(NullPointerException.class, () -> new Scored(0L, null));
    }
}
