import DataBase.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class UserTests {

    @Test
    @DisplayName("Valid Get Instance")
    public void getInstanceValid() {
        User user1 = User.getInstance();
        User user2 = User.getInstance();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(User.getInstance()), // Creates instance
                () -> Assertions.assertNotNull(User.getInstance()), // Returns same instance
                () -> Assertions.assertEquals(User.getInstance(), User.getInstance()),
                () -> Assertions.assertSame(user2, user1) // Same obj
        );
    }



}
