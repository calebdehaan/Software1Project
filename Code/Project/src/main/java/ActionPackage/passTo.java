package ActionPackage;

import javafx.util.Pair;

public class PassTo extends Action{
	Boolean complete;
    
    PassTo(Long input, ActionEnum e) {
        super(input);
        this.ActionName = e;
    }

    @Override
    public String getDesc() {
        return null;
    }

    @Override
    public Pair<Long, ActionEnum> updateStats() {
        ActionName = ActionEnum.PASSCOMPLETE;
        
        return new Pair<Long, ActionEnum>(PlayerID, ActionName);
    }

    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
    public Boolean checkComplete() {
    	return complete;
    }
    
}
