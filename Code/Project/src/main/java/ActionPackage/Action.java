package ActionPackage;
import javafx.util.Pair;

public class Action {
    protected ActionEnum ActionName = ActionEnum.NOTHING;
    protected Long PlayerID;
    public String getDesc() {return null;}
    public Pair<Long, ActionEnum> updateStats() {return null;}
    public void visit(ActionVisitor av) {av.accept(this);}
    
    Action(Long input){
        PlayerID = input;
    }
}
