package ActionPackage;

public class ActionVisitor {
    public void accept(Action a) {
        System.out.println(a.getDesc());
        
        //Theoretically this will never run
        //Everything will have its own implemented accept function
        //This is a backup in case we have an action that doesn't have
        //an implemented accept function.
    }
    
    public void accept(passTo a) {
        
    }
}
