package ActionPackage;

import javafx.util.Pair;

public class passTo extends Action{
    
    passTo(Long input) {
        super(input);
    }

    @Override
    public String getDesc() {
        return null;
    }

    @Override
    public Pair<Long, ActionEnum> updateStats() {
        // TODO Auto-generated method
        ActionName = ActionEnum.PASSCOMPLETE;
        
        return new Pair<Long, ActionEnum>(PlayerID, ActionName);
    }

    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
}
