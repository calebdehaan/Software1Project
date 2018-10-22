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
        Action currAction;
        ActionEnum actionName;
        
        while(!stack.isEmpty()) {
            currAction = stack.getFirst();
            actionName = currAction.getActionName();
            
            if(actionName.equals(ActionEnum.PASSCOMPLETE)) {
            	playerList.get(currAction.getThrowerId()).incrementCompletions();
            	playerList.get(currAction.getCatcherId()).incrementCatch();
            }
            else if(actionName.equals(ActionEnum.PASSFAIL)) {
            	playerList.get(currAction.getThrowerId()).incrementThrows();
            }
            else if(actionName.equals(ActionEnum.SCORE) || actionName.equals(ActionEnum.INJURY)) {
            	currAction.visit(new ActionVisitor());
            }
            
            //Add to the database from here.
            //Use the Long of the pair to find the player in playerList
            //Use the enum to figure out what happened to that player
            
            stack.removeFirst();
        }
        
        // Push data?
    }
}
