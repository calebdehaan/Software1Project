package ActionPackage;

public enum ActionEnum {
    NOTHING(0),
    PASSCOMPLETE(1),
    PASSFAIL(2),
    INJURY(3),
    SCORE(4);
    
    private int ID;
    ActionEnum(int id) {
        ID = id;
    }
    
    public int getID() {
        return ID;
    }
}
