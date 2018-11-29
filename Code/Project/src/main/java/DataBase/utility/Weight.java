package DataBase.utility;

public class Weight {
	Unit units;
	double weight;

	public Weight(Unit units, double weight) {
		this.units = units;
		this.weight = weight;
	}

	public Weight(double weight) {
		this(Unit.Metric, weight);
	}

	public Unit getUnits() {
		return units;
	}

	public void setUnits(Unit units) {
		this.units = units;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return String.valueOf(weight) + " " + String.valueOf(units);
	}

	@Override
	public boolean equals(Object that) {
		if (that instanceof Weight) {
			return ((Weight) that).getWeight() == this.getWeight()
					&& ((Weight) that).getUnits().equals(this.getUnits());
		}

		return false;
	}
}
