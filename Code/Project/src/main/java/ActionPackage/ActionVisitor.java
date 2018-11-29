package ActionPackage;

import DataBase.Player;

import java.util.Map;

// Visitor
public class ActionVisitor {
    private Map<Long, Player> roster;
    
    public ActionVisitor(Map<Long, Player> team) {
        this.roster = team;
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
     * Default accept function. Should never be called.
     *
     * @param a the action
     */
    public void accept(Action a) {
        System.out.println(a.getDescription());
    }
    
    /**
     * Increments the catch count for the catcher and completed pass count for the thrower.
     *
     * @param a the action
     */
    public void accept(PassTo a) {
        if (a.actionName == ActionEnum.PASSCOMPLETE) {
            this.getPlayer(a.getCatcherId()).incrementCatch();
            this.getPlayer(a.getThrowerId()).incrementCompletions();
        } else {
            this.getPlayer(a.getCatcherId()).incrementThrows();
        }
    }
    
    /**
     * Increments the injury count for the player specified by "a". Also sets injured status to true.
     *
     * @param a the action
     */
    public void accept(Injury a) {
        Player p = this.getPlayer(a.playerId);
        p.setInjured(true);
    }
    
    /**
     * Instructs a to push stats to database.
     *
     * @param a
     */
    public void accept(Scored a) {
        a.dumpStats();
    }
}
