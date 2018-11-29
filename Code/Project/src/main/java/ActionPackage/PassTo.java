package ActionPackage;

public class PassTo extends Action {
	private Long catcher;

	/**
	 * Construct PassTo Action with id of thrower. Assumed to have failed the throw.
	 *
	 * @param id   id of thrower
	 * @param desc description of what happened.
	 */
	public PassTo(Long id, String desc) {
		super(id, desc);
		this.actionName = ActionEnum.PASSFAIL;
	}

	/**
	 * Construct PassTo Action with id of thrower and catcher. Assumed to have
	 * completed the throw.
	 *
	 * @param id    id of thrower
	 * @param idTwo id of cather
	 * @param desc  description of what happened.
	 */
	public PassTo(Long id, Long idTwo, String desc) {
		super(id, desc);
		this.catcher = idTwo;
		this.actionName = ActionEnum.PASSCOMPLETE;
	}

	/**
	 * Has av call ActionVisiter::accept on this
	 *
	 * @param av the ActionVisiter
	 */
	@Override
	public void visit(ActionVisitor av) {
		av.accept(this);
	}

	@Override
	public String toString() {
		return "PassTo{" + "catcher=" + (catcher != null ? catcher : "null") + ", thrower=" + playerId + ", actionName="
				+ actionName + ", description='" + description + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;

		PassTo passTo = (PassTo) o;

		return catcher != null ? catcher.equals(passTo.catcher) : passTo.catcher == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (catcher != null ? catcher.hashCode() : 0);
		return result;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	public Long getThrowerId() {
		return playerId;
	}

	public Long getCatcherId() {
		return catcher;
	}

	public boolean didComplete() {
		return this.actionName == ActionEnum.PASSCOMPLETE;
	}

}
