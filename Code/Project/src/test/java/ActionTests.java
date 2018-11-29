import ActionPackage.Injury;
import ActionPackage.PassTo;
import ActionPackage.Penalty;
import ActionPackage.Scored;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ActionTests {
	@ParameterizedTest
	@DisplayName("Valid Equals")
	@CsvSource({ "0, none", "0, nada", "2147483647, A really awfully long string of unnecessary characters", })
	public void equalsTestValid(long id, String desc) {
		Assertions.assertAll(() -> Assertions.assertEquals(new Injury(id, desc), new Injury(id, desc)),
				() -> Assertions.assertEquals(new PassTo(id, desc), new PassTo(id, desc)),
				() -> Assertions.assertEquals(new Scored(id, desc), new Scored(id, desc)),
				() -> Assertions.assertEquals(new Penalty(id, desc), new Penalty(id, desc)));
	}

	@ParameterizedTest
	@DisplayName("Invalid Equals")
	@CsvSource({ "-1, something", "1," })
	public void equalsTestInvalid(long id, String desc) {
		Assertions.assertAll(
				() -> Assertions.assertThrows(Exception.class,
						() -> Assertions.assertEquals(new Injury(id, desc), new Injury(id, desc))),
				() -> Assertions.assertThrows(Exception.class,
						() -> Assertions.assertEquals(new PassTo(id, desc), new PassTo(id, desc))),
				() -> Assertions.assertThrows(Exception.class,
						() -> Assertions.assertEquals(new Scored(id, desc), new Scored(id, desc))),
				() -> Assertions.assertThrows(Exception.class,
						() -> Assertions.assertEquals(new Penalty(id, desc), new Penalty(id, desc))));
	}
}
