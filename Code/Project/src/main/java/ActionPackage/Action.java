package ActionPackage;

public interface Action {
    String getDesc();
    void updateStats();
    void visit(ActionVisitor av);
}
