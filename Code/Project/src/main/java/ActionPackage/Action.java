package ActionPackage;

import javafx.util.Pair;

public abstract class Action {
    protected ActionEnum actionName = ActionEnum.NOTHING;
    protected Long playerId;
    protected String description;
    
    public Pair<Long, ActionEnum> updateStats() {
        return new Pair<Long,ActionEnum>(playerId, actionName);
    }
    
    public void visit(ActionVisitor av) {
        av.accept(this);
    }
    
    public Action(Long id) {
        this(id, "");
    }
    
    public Action(Long id, String desc){
        this.setPlayerId(id);
        this.setDescription(desc);
    }
    
    public Long getPlayerId() {
        return playerId;
    }
    
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Action{" +
                       "actionName=" + actionName +
                       ", playerId=" + playerId +
                       ", description='" + description + '\'' +
                       '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Action action = (Action) o;
        
        if (actionName != action.actionName) return false;
        if (!playerId.equals(action.playerId)) return false;
        return description.equals(action.description);
    }
    
    @Override
    public int hashCode() {
        int result = actionName.hashCode();
        result = 31 * result + playerId.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
