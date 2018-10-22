package ActionPackage;

public abstract class Action {
    protected ActionEnum actionName = ActionEnum.NOTHING;
    protected Long playerOneId;
    protected Long playerTwoId;
    protected String description;
    
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
    public Action(Long id, Long idTwo) {
        this.playerOneId = id;
        this.playerTwoId = idTwo;
        this.description = "";
    }
    
    public Action(Long id, Long idTwo, String desc){
        this.playerOneId = id;
        this.playerTwoId = idTwo;
        this.description = desc;
    }
    
    public Long getThrowerId() {
        return playerOneId;
    }
    
    public Long getCatcherId() {
        return playerTwoId;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return "Action{" +
                       "actionName=" + actionName +
                       ", thrower id=" + playerOneId +
                       ", catcher id=" + playerTwoId +
                       ", description='" + description + '\'' +
                       '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Action action = (Action) o;
        
        if (actionName != action.actionName) return false;
        if (!playerOneId.equals(action.playerOneId)) return false;
        if (!playerTwoId.equals(action.playerTwoId)) return false;
        return description.equals(action.description);
    }
    
    @Override
    public int hashCode() {
        int result = actionName.hashCode();
        result = 31 * result + playerOneId.hashCode();
        result = 31 * result + playerTwoId.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
    
    public ActionEnum getActionName() {
    	return this.actionName;
    }
}
