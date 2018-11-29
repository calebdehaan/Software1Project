package ActionPackage;

public class Injury extends Action {

	public Injury(Long id, String desc) {
		super(id, desc);
		this.actionName = ActionEnum.INJURY;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void visit(ActionVisitor av) {
		av.accept(this);
	}

	@Override
	public String toString() {
		return "Injury{" + "playerId=" + playerId + ", actionName=" + actionName + ", description='" + description
				+ '\'' + '}';
	}
}
