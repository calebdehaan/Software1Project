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
     * @param p p
     */
    public void addPlayer(Player p) {
        Objects.requireNonNull(p);

        if (alumniRoster.containsKey(p.getId())) {
            p = alumniRoster.get(p.getId());
            
            roster.putIfAbsent(p.getId(), p);
        } else {
            roster.putIfAbsent(p.getId(), p);
        }
    }

    /**
     * 
     * @param p p
     * @return player p
     */ 
    public Player removePlayer(Player p) {
        Objects.requireNonNull(p);

        if (roster.containsKey(p)) {
            roster.remove(p);
            alumniRoster.put(p.getId() , p);
        }

        return p;
    }

    /**
     * 
     * @param ad ad
     */
    public void addAdmin(User ad) {
        Objects.requireNonNull(ad);

        if (!adminPrivileges.contains(ad)) {
            adminPrivileges.add(ad);
        }
    }

    /**
     * 
     * @param ad ad
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
    
    /**
     * Returns a deep copy of the roster, using player's clone function
     * @return deep copy of the roster
     */
    public Map<Long,Player> getRoster() {
        Map<Long,Player> deepCopy = new TreeMap<Long,Player>();
        
        for(Player p : roster.values() ) {
            deepCopy.putIfAbsent( p.getId() , p.clone() );
        }
        
        return deepCopy;
    }
    
    /**
     * Factory Method implementation, allows for extension into new types of games
     * @param ghFactory
     * @return Gamehandler
     */
    public GameHandler newGame(GameHandlerFactory ghFactory) {
        return ghFactory.newGame(roster);
    }
}
