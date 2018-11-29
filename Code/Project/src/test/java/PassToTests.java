import ActionPackage.PassTo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class PassToTests {
    @Test
    @DisplayName("Valid Value Constructor")
    public void defaultConstructorTestValid() {
        Assertions.assertNotNull(new PassTo(0L, "none"));
    }

    @Test
    @DisplayName("Invalid Value Constructor")
    public void defaultConstructorTestInvalid() {
        Assertions.assertThrows(NullPointerException.class, () -> new PassTo(0L, null));
    }
}
