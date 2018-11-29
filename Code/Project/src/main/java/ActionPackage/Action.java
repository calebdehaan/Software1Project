package ActionPackage;

import java.util.Objects;

public abstract class Action {
    protected Long playerId;
    protected ActionEnum actionName;
    protected String description;
    
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
    protected Action(Long id) {
        this(id,"");
    }

    protected Action(Long id, String desc) {
        this.setId(id);
        this.description = Objects.requireNonNull(desc);
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

    private void setId(Long id){
        if(id != null && id >= 0){
            this.playerId = id;
        }
    }

    public Long getId() {
    	return this.playerId;
    }
    
    public ActionEnum getActionName() {
        return this.actionName;
    }
    
    public String getDescription() {
        return description;
    }
}
