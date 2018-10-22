package ActionPackage;

public class Injury extends Action {
    
    Injury(Long id) {
        this(id, "");
    }
    
    Injury(Long id, String desc){
        super(id);
        this.setDescription(desc);
        this.actionName = ActionEnum.Injury;
    }
    
    @Override
    public String getDesc() {
        return description;
    }
    
    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
}
