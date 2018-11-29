package DataBase.utility;

public enum DominantHand {
	Right, Left, Ambidextrous;

	public String toString() {
		switch (this) {
		case Right:
			return "Right";
		case Left:
			return "Left";
		case Ambidextrous:
			return "Ambidextrous";
		default:
			return "null";
		}
	}
}
