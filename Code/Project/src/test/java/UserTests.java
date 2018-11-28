import DataBase.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public class UserTests {
    private User user1, user2;

    @BeforeAll
    public void setup(){
        user1 = User.getInstance();
        user2 = User.getInstance();
    }


    @Test
    @DisplayName("Get Instance")
    public void getInstance() {
        Assertions.assertAll(
                () -> Assertions.assertNotNull(User.getInstance()), // Creates instance
                () -> Assertions.assertNotNull(User.getInstance()), // Returns same instance
                () -> Assertions.assertEquals(User.getInstance(), User.getInstance()),
                () -> Assertions.assertSame(user2, user1) // Same obj
        );
    }

    @Test
    @DisplayName("Valid Equals")
    public void equalsValid(){
        Assertions.assertEquals(user1, user2);
    }

    @Test
    @DisplayName("Invalid Equals")
    public void equalsInvalid(){
        Assertions.assertThrows(Exception.class, () -> user1.equals(null));
    }

    @Test
    @DisplayName("Valid Clone")
    public void cloneValid(){
        Assertions.assertSame(user1, user1.clone());
    }

    @Test
    @DisplayName("Invalid Clone")
    public void cloneInvalid(){
        Assertions.assertNotSame(user1, null);
    }



}
