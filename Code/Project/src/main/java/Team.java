import java.util.ArrayList;
import java.util.List;

public class Team {
	List<Player> roster = new ArrayList<Player>();
	List<Player> alumniRoster = new ArrayList<Player>();
	List<User> adminPriveleges = new ArrayList<User>();
	String teamName;
	
	public void addPlayer(Player p) {
		roster.add(p);
	}
	
	public Player removePlayer(Player p) {
		if(roster.contains(p.getID())) {
			roster.remove(p);
		}
	}
}
