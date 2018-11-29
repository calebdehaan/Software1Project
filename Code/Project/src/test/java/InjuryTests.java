import ActionPackage.Injury;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class InjuryTests {
    @Test
    @DisplayName("Valid Value Constructor")
    public void defaultConstructorTestValid(){
        Assertions.assertNotNull(new Injury(0L, "none"));
    }

    @Test
    @DisplayName("Invalid Value Constructor")
    public void defaultConstructorTestInvalid(){
        Assertions.assertThrows(NullPointerException.class, ()-> new Injury(0L, null));
    }
}
