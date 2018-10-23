package ActionPackage;

public abstract class Action {
    protected Long playerId;
    protected ActionEnum actionName;
    protected String description;
    
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
    public Action(Long id) {
        this(id,"");
    }
    
    // TODO: Use private setters for input validation?
    public Action(Long id, String desc) {
        this.playerId = id;
        this.description = desc;
        this.actionName = ActionEnum.NOTHING;
    }
    
    @Override
    public String toString() {
        return "Action{" +
                       "playerId=" + playerId +
                       ", actionName=" + actionName +
                       ", description='" + description + '\'' +
                       '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Action action = (Action) o;
        
        if (!playerId.equals(action.playerId)) return false;
        if (actionName != action.actionName) return false;
        return description.equals(action.description);
    }
    
    @Override
    public int hashCode() {
        int result = playerId.hashCode();
        result = 31 * result + actionName.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
    
    public ActionEnum getActionName() {
        return this.actionName;
    }
    
    public String getDescription() {
        return description;
    }
}
