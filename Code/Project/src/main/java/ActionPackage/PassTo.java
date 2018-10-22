package ActionPackage;

public class PassTo extends Action {
	Boolean complete;
    PassTo(Long id, ActionEnum e, String desc, Boolean c) {
        super(id);
        this.description = "";
        this.actionName = e;
        this.complete = c;
        this.description = desc;
    }
    
    @Override
    public String getDescription() {
        return this.description;
    }
    
    public void updateStats() {
    	if(this.actionName.equals(ActionEnum.PASSCOMPLETE)) {
    		
    	}
    }
    
    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
}
