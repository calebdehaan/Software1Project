import ActionPackage.Penalty;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class PenaltyTests {
	@Test
	@DisplayName("Valid Value Constructor")
	public void defaultConstructorTestValid() {
		Assertions.assertNotNull(new Penalty(0L, "none"));
	}

	@Test
	@DisplayName("Invalid Value Constructor")
	public void defaultConstructorTestInvalid() {
		Assertions.assertThrows(NullPointerException.class, () -> new Penalty(0L, null));
	}
}
