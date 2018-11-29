package ActionPackage;

public class Penalty extends Action {
	public Penalty(Long id) {
		super(id);
	}

	public Penalty(Long id, String desc) {
		super(id, desc);
	}

	@Override
	public void visit(ActionVisitor av) {
		super.visit(av);
	}
}
