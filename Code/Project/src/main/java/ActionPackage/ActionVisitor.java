package ActionPackage;

public class ActionVisitor {
    public void accept(Action a) {
        System.out.println(a.getDescription());
    }
    
    public void accept(PassTo a) {
        
    }
    
    public void accept(Injury a){
    
    }
}
