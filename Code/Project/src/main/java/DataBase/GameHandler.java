package DataBase;

import ActionPackage.Action;
import ActionPackage.ActionVisitor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class GameHandler {
    private Map<Long, Player> playerList;
    private Deque<Action> stack = new ArrayDeque<Action>();
    
    GameHandler(Map<Long, Player> roster) {
        playerList = roster;
    }
    
    public void newAction(Action a) {
        stack.add(a);
    }
    
    /**
     * Removes last action completed from the stack.
     *
     * @param a
     */
    public void undo(Action a) {
        stack.removeLast();
    }
    
    /**
     * Calculates stats from the actions done throughout the game.
     */
    public void recordAll() {
        ActionVisitor visitor = new ActionVisitor(playerList);
        
        while (!stack.isEmpty()) {
            stack.getFirst().visit(visitor);
            stack.removeFirst();
        }
    }
}
