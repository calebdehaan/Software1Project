package ActionPackage;

import javafx.util.Pair;

public class PassTo extends Action {
    
    PassTo(Long id, ActionEnum e) {
        super(id);
        this.description = "";
        this.actionName = e;
    }
    
    PassTo(Long id, String desc) {
        super(id);
        this.description = desc;
    }
    
    @Override
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public Pair<Long, ActionEnum> updateStats() {
        return new Pair<Long, ActionEnum>(playerId, ActionEnum.PASSCOMPLETE);
    }
    
    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
}
