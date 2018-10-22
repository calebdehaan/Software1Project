package ActionPackage;

public class ScoreOccured extends Action{
	ScoreOccured(Long id, Long idTwo, String desc) {
		super(id,idTwo);
		this.actionName = ActionEnum.SCORE;
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
