package DataBase;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import ActionPackage.*;
import javafx.util.Pair;

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
        Pair<Long, ActionEnum> temp;
        while(!stack.isEmpty()) {
            temp = stack.getFirst().updateStats();
            
            //Add to the database from here.
            //Use the Long of the pair to find the player in playerList
            //Use the enum to figure out what happened to that player
            
            stack.removeFirst();
        }
    }
}
