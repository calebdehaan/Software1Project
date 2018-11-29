package ActionPackage;

public class Catch extends Action {
	
	public Catch(Long l, String s) {
		super(l,s);
		this.actionName = ActionEnum.CATCH;
	}
	
	@Override
	public void visit(ActionVisitor av) {
        av.accept(this);
    }
	
	@Override
    public String toString() {
        return "Catch{" +
                       "catcher=" + playerId +
                       ", actionName=" + actionName +
                       ", description='" + description + '\'' +
                       '}';
    }

}
