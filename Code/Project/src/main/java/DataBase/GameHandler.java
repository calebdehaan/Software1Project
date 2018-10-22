package DataBase;

import ActionPackage.Action;
import ActionPackage.ActionEnum;
import ActionPackage.ActionVisitor;
import ActionPackage.PassTo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

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
                PassTo pass = (PassTo) currAction;
            	playerList.get(pass.getThrowerId()).incrementCompletions();
            	playerList.get(pass.getCatcherId()).incrementCatch();
            }
            else if(actionName.equals(ActionEnum.PASSFAIL)) {
                PassTo pass = (PassTo) currAction;
            	playerList.get(pass.getThrowerId()).incrementThrows();
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
