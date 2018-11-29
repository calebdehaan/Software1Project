package DataBase;

import java.util.*;

public class Team {
	private Map<Long, Player> roster = new TreeMap<Long, Player>();
	private Map<Long, Player> alumniRoster = new TreeMap<Long, Player>();
	private List<User> adminPrivileges = new ArrayList<User>();
	private String teamName;

	/**
	 * Adds player p to the roster
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
	 * Removes player p from the roster and adds them to the alumni-roster
	 *
	 * @param p p
	 * @return player p
	 */
	public Player removePlayer(Player p) {
		Objects.requireNonNull(p);

		if (roster.containsValue(p)) {
			roster.remove(p.getId());
			alumniRoster.put(p.getId(), p);
		}

		return p;
	}

	/**
	 * Returns the player on the roster with id "id". Null otherwise.
	 *
	 * @param id the id of the desired player
	 * @return the player on the roster with id "id". Null otherwise.
	 */
	public Player getPlayer(Long id) {
		return this.roster.values().stream().filter(player -> player.getId() == id).findFirst().orElse(null);
	}

	/**
	 * Adds user ad to the list of users with admin privileges
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
	 * Removes user ad from list of users with admin privileges
	 *
	 * @param ad ad
	 * @return User ad
	 */
	public User removeAdmin(User ad) {
		Objects.requireNonNull(ad);
		adminPrivileges.remove(ad);
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
	 *
	 * @return deep copy of the roster
	 */
	public Map<Long, Player> getRoster() {
		Map<Long, Player> deepCopy = new TreeMap<Long, Player>();

		for (Player p : roster.values()) {
			deepCopy.putIfAbsent(p.getId(), p.clone());
		}

		return deepCopy;
	}

	/**
	 * Factory Method implementation, allows for extension into new types of games
	 *
	 * @param ghFactory the GameHandlerFactory
	 * @return Gamehandler
	 */
	public GameHandler newGame(GameHandlerFactory ghFactory) {
		return ghFactory.newGame(roster);
	}
}
