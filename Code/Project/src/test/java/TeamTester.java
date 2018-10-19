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
	void removePlayer(Player p) {
		theTeam.removePlayer(p);
	}
	
	@Test
	void removeNull(){
		theTeam.removePlayer(null);
	}
}
