package ActionPackage;

public class Scored extends Action{
	Scored(Long id, String desc) {
		super(id, desc);
		this.actionName = ActionEnum.SCORE;
	}
	
	@Override
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
    @Override
    public String toString() {
        return "Scored{" +
                       "playerId=" + playerId +
                       ", actionName=" + actionName +
                       ", description='" + description + '\'' +
                       '}';
    }
    
    public void dumpStats() {
    	
    }
}
