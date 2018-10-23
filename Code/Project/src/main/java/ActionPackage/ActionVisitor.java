package ActionPackage;

import DataBase.Player;

import java.util.Map;

public class ActionVisitor {
    Map<Long, Player> roster;
    
    public ActionVisitor(Map<Long, Player> team) {
        this.roster = team;
    }
    
    public Player getPlayer(Long id){
        return this.roster.values().stream().filter(player -> player.getId() == id).findFirst().orElse(null);
    }
    
    
    public void accept(Action a) {
        System.out.println(a.getDescription());
    }
    
    public void accept(PassTo a) {
        if(a.actionName == ActionEnum.PASSCOMPLETE){
            this.getPlayer(a.getCatcherId()).incrementCatch();
            this.getPlayer(a.getThrowerId()).incrementCompletions();
        } else {
            this.getPlayer(a.getCatcherId()).incrementThrows();
        }
    }
    
    public void accept(Injury a) {
        this.getPlayer(a.playerId).setInjured(true);
        this.getPlayer(a.playerId).setInjuries(this.getPlayer(a.playerId).getInjuries());
    }
    
    public void accept(Scored a) {
        a.dumpStats();
    }
}
