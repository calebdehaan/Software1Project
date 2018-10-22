package ActionPackage;

public class Injury extends Action {
    
    Injury(Long id) {
        this(id, "");
    }
    
    Injury(Long id, String desc){
        super(id);
        this.description = desc;
        this.actionName = ActionEnum.INJURY;
    }
    
    @Override
    public String getDescription() {
        return null;
    }
    
    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
}
