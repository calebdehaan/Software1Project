package DataBase;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import ActionPackage.*;

public class GameHandler {
    private Map<Long, Player> playerList;
    private Deque<Action> stack = new ArrayDeque<Action>();
    
    GameHandler(Map<Long,Player> roster){
        playerList = roster;
    }
    
    public void newAction(Action a) {
        stack.add(a);
    }
    
    public void undo(Action a) {
        stack.removeLast();
    }
    
    public void recordAll() {
        Action temp;
        while(!stack.isEmpty()) {
            temp = stack.getFirst();
            
            if(temp.getActionName().equals(ActionEnum.PASSCOMPLETE)) {
            	Long id = temp.getThrowerId();
            	playerList.get(id).incrementCompletions();
            	id = temp.getCatcherId();
            	playerList.get(id).incrementCatch();
            }
            else if(temp.getActionName().equals(ActionEnum.PASSFAIL)) {
            	Long id = temp.getThrowerId();
            	playerList.get(id).incrementThrows();
            }
            else if(temp.getActionName().equals(ActionEnum.SCORE)) {
            	temp.visit(new ActionVisitor());
            }
            
            //Add to the database from here.
            //Use the Long of the pair to find the player in playerList
            //Use the enum to figure out what happened to that player
            
            stack.removeFirst();
        }
    }
}
