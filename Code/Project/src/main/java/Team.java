import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Team {
		if(roster.contains(p.getID())) {
    Map<Long,Player> roster = new TreeMap<Long,Player>();
    Map<Long,Player> alumniRoster = new TreeMap<Long,Player>();
    List<User> adminPrivileges = new ArrayList<User>();
    String teamName;

    /**
     * 
     * @param player p
     */
    public void addPlayer(Player p) {
        Objects.requireNonNull(p);
        
        if( alumniRoster.contains(p.getID()) ) {
            roster.add(p.getID() , p );            
        }
    }

    /**
     * 
     * @param player p
     * @return player p
     */
    public Player removePlayer(Player p) {
        Objects.requireNonNull(p);

        if (roster.contains(p)) {
            roster.remove(p);
            alumniRoster.add(p);
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
        
        if(adminPrivileges.contains(ad)) {
            adminPrivileges.remove(ad);
        }
        
        return ad;
    }
}
