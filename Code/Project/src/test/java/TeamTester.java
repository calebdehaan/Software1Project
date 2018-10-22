import static org.junit.jupiter.api.Assertions.assertThrows;

import DataBase.Player;
import DataBase.Team;
import DataBase.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TeamTester {
    protected Team theTeam = null;

    @BeforeEach
    void init() {
        theTeam = new Team();
    }

    @Test
    void addNewPlayer(Player p) {
        theTeam.addPlayer(p);
    }

    @Test
    void addNullPlayer(Player p) {
        assertThrows(NullPointerException.class, () -> {
            theTeam.addPlayer(null);
        });
    }

    @Test
    void removePlayer(Player p) {
        theTeam.removePlayer(p);
    }

    @Test
    void removeNull() {
        assertThrows(NullPointerException.class, () -> {
            theTeam.removePlayer(null);
        });
    }

    @Test
    void addNewAdmin(User ad) {
        theTeam.addAdmin(ad);
    }
    
    @Test
    void addNullAdmin() {
        theTeam.addAdmin(null);
    }
}
