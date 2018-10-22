package ActionPackage;

public class ScoreOccured extends Action{
	ScoreOccured(Long id, ActionEnum n, String desc) {
		super(id);
		this.actionName = n;
		this.description = desc;
	}
	
	@Override
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
    public void dumpStats() {
    	
    }
}
