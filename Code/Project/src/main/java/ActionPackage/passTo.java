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
<<<<<<< HEAD:Code/Project/src/main/java/ActionPackage/passTo.java
        this.description = desc;
    }
    
    @Override
    public String getDescription() {
        return this.description;
=======
        this.setDescription(desc);
>>>>>>> 62517fddeb8d3346e0390aa80ecdf8fe1967d0e6:Code/Project/src/main/java/ActionPackage/PassTo.java
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
