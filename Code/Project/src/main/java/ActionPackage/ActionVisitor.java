package ActionPackage;

public class ActionVisitor {
    public void accept(Action a) {
        System.out.println(a.getDescription());
    }
    
    public void accept(PassTo a) {
        // Player passed
        if(a.actionName == ActionEnum.PASSCOMPLETE){
        
        } else {
        
        }
    }
    
    public void accept(Injury a) {
        // Player was injured
    }
    
    public void accept(Scored a) {
        a.dumpStats();
    }
}
