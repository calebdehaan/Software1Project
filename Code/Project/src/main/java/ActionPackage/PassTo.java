package ActionPackage;

import javafx.util.Pair;

public class PassTo extends Action {
    private String description;
    
    PassTo(Long id) {
        this(id, "");
    }
    
    PassTo(Long id, String desc) {
        super(id);
        this.setDescription(desc);
    }
    
    @Override
    public Pair<Long, ActionEnum> updateStats() {
        return new Pair<>(playerId, ActionEnum.PASSCOMPLETE);
    }
    
    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
}
