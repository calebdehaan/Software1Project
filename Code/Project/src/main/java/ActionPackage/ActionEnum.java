package ActionPackage;

public enum ActionEnum {
    NOTHING(0),
    PASSCOMPLETE(1),
    PASSFAIL(2),
    Injury(3);
    
    int ID;
    
    private ActionEnum(int id) {
        ID = id;
    }
}
