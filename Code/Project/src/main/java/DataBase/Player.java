package DataBase;

import DataBase.utility.DominantHand;
import DataBase.utility.Height;
import DataBase.utility.Weight;

public class Player implements Cloneable {
	private Height height;
	private Weight weight;
	private int age = -1;
	private Long id;
	private String name;
	private DominantHand domHand = DominantHand.Right;

	// Game Stats //
	private int passes = 0;
	private int completions = 0;
	private int catches = 0;
	private int scores = 0;
	private boolean injured = false;
	private int gamesPlayed = 0;

	private double completionRate = 0.0;

	// Constants //
	public static final int AGE_MIN = 10;
	public static final int AGE_MAX = 100;
	public static final long ID_MIN = 0;
	public static final long ID_MAX = 2L * Integer.MAX_VALUE + 1; // Full integer range, no negatives
	public static final Weight WEIGHT_MIN = new Weight(0);
	public static final Weight WEIGHT_MAX = new Weight(Integer.MAX_VALUE);

	// Constructors //
	public Player() {
		this(new Height(0, 0), WEIGHT_MIN, AGE_MIN, "none", DominantHand.Right);
	}

	public Player(String name) {
		this(new Height(0, 0), WEIGHT_MIN, AGE_MIN, name, DominantHand.Right);
	}

	public Player(Height height, Weight weight, int age, String name, DominantHand domHand) {
		this.setWeight(weight);
		this.setHeight(height);
		this.setAge(age);
		this.setName(name);
		this.setDomHand(domHand);
		this.setId(/* this.hashCode() */1);
	}

	// Utility Functions //
	public Player clone() {
		Player p = new Player();

		p.setWeight(weight);
		p.setHeight(height);
		p.setAge(age);
		p.setId(this.getId());
		p.setName(name);
		p.setDomHand(domHand);

		p.setInjured(injured);
		p.setGamesPlayed(gamesPlayed);
		p.setCompletions(completions);
		p.setCatches(catches);
		p.setScores(scores);
		p.setCompletionRate();

		return p;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Player player = (Player) o;

		if (age != player.age)
			return false;
		// if (id != player.id) return false;
		if (passes != player.passes)
			return false;
		if (completions != player.completions)
			return false;
		if (catches != player.catches)
			return false;
		if (scores != player.scores)
			return false;
		if (injured != player.injured)
			return false;
		if (gamesPlayed != player.gamesPlayed)
			return false;
		if (Double.compare(player.completionRate, completionRate) != 0)
			return false;
		if (!height.equals(player.height))
			return false;
		if (!weight.equals(player.weight))
			return false;
		if (!name.equals(player.name))
			return false;
		return domHand == player.domHand;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = height.hashCode();
		result = 31 * result + weight.hashCode();
		result = 31 * result + age;
		result = 31 * result + (int) (id ^ (id >>> 32));
		result = 31 * result + name.hashCode();
		result = 31 * result + domHand.hashCode();
		result = 31 * result + passes;
		result = 31 * result + completions;
		result = 31 * result + catches;
		result = 31 * result + scores;
		result = 31 * result + (injured ? 1 : 0);
		result = 31 * result + gamesPlayed;
		temp = Double.doubleToLongBits(completionRate);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Invalid Name: " + name);
		}

		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DominantHand getDomHand() {
		return domHand;
	}

	public void setDomHand(DominantHand domHand) {
		this.domHand = domHand;
	}

	public Height getHeight() {
		return height;
	}

	public void setHeight(Height height) {
		this.height = height;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		if (weight.getWeight() > WEIGHT_MAX.getWeight() || weight.getWeight() < WEIGHT_MIN.getWeight()) {
			throw new IllegalArgumentException("Invalid Weight: " + weight);
		}

		this.weight = weight;
	}

	public int getPasses() {
		return passes;
	}

	public void setPasses(int passes) {
		this.passes = passes;
	}

	public int getCatches() {
		return catches;
	}

	public void setCatches(int catches) {
		this.catches = catches;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

	public boolean isInjured() {
		return injured;
	}

	public void setInjured(boolean injured) {
		this.injured = injured;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public void incrementCatch() {
		this.catches++;
	}

	public void incrementCompletions() {
		this.incrementThrows();
		this.setCompletions(this.getCompletions() + 1);
	}

	public void incrementThrows() {
		this.passes++;
	}

	public int getCompletions() {
		return completions;
	}

	public void setCompletions(int completions) {
		this.completions = completions;
	}

	public double getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate() {
		if (this.catches == 0) {
			this.completionRate = 0;
		} else {
			this.completionRate = this.completions / (1.0 * this.catches);
		}
	}

	public Boolean getInjured() {
		return this.injured;
	}
}
