package DataBase;

import DataBase.Player;

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
        while(!stack.isEmpty()) {
            stack.getFirst().updateStats();
            stack.removeFirst();
        }
    }
}
