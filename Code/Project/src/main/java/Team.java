import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Team {
    private Map<Long, Player> roster = new TreeMap<Long, Player>();
    private Map<Long, Player> alumniRoster = new TreeMap<Long, Player>();
    private List<User> adminPrivileges = new ArrayList<User>();
    private String teamName;

    /**
     * 
     * @param player p
     */
    public void addPlayer(Player p) {
        Objects.requireNonNull(p);

        if (alumniRoster.containsKey(p.getID())) {
            p = alumniRoster.get(p.getID());
            
            roster.putIfAbsent(p.getID(), p);
        } else {
            roster.putIfAbsent(p.getID(), p);
        }
    }

    /**
     * 
     * @param player p
     * @return player p
     */ 
    public Player removePlayer(Player p) {
        Objects.requireNonNull(p);

        if (roster.containsKey(p)) {
            roster.remove(p);
            alumniRoster.put(p.getID() , p);
        }

        return p;
    }

    /**
     * 
     * @param User ad
     */
    public void addAdmin(User ad) {
        Objects.requireNonNull(ad);

        if (!adminPrivileges.contains(ad)) {
            adminPrivileges.add(ad);
        }
    }

    /**
     * 
     * @param User ad
     * @return User ad
     */
    public User removeAdmin(User ad) {
        Objects.requireNonNull(ad);

        if (adminPrivileges.contains(ad)) {
            adminPrivileges.remove(ad);
        }

        return ad;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public GameHandler newGame() {
        return new GameHandler(roster);
    }
}
