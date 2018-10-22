package ActionPackage;

public class PassTo extends Action {
	Boolean complete;
    PassTo(Long id, Long idTwo, ActionEnum e, String desc, Boolean c) {
        super(id,idTwo);
        this.description = "";
        this.actionName = e;
        this.complete = c;
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
    
    @Override
    public String toString() {
        return "PassTo{" +
                       "complete=" + complete +
                       ", playerOneId=" + playerOneId +
                       ", playerTwoId=" + playerTwoId +
                       ", description='" + description + '\'' +
                       '}';
    }
}
