package ActionPackage;

public class Injury extends Action {
    Injury(Long id, Long idTwo, String desc){
        super(id,idTwo);
        this.description = desc;
        this.actionName = ActionEnum.INJURY;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
}
