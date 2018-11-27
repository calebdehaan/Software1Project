package DataBase;

import DataBase.utility.DominantHand;
import DataBase.utility.Height;
import DataBase.utility.Weight;
import javafx.beans.property.SimpleStringProperty;

public class StringOnlyPlayer {
	private SimpleStringProperty height;
    private SimpleStringProperty weight;
    private SimpleStringProperty age;
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty domHand;
    
    private SimpleStringProperty passes;
    private SimpleStringProperty completions;
    private SimpleStringProperty catches;
    private SimpleStringProperty scores;
    private SimpleStringProperty injured;
    private SimpleStringProperty gamesPlayed;
    
    private SimpleStringProperty completionRate;
    
    public StringOnlyPlayer(Player p) {
    	this.setHeight(new SimpleStringProperty(p.getHeight().toString()));
    	this.setWeight(new SimpleStringProperty(p.getWeight().toString()));
    	this.setAge(new SimpleStringProperty(Integer.toString(p.getAge())));
    	this.setId(new SimpleStringProperty(Long.toString(p.getId())));
    	this.setName(new SimpleStringProperty(p.getName()));
    	this.setDomHand(new SimpleStringProperty(p.getDomHand().toString()));
    	this.setPasses(new SimpleStringProperty(Integer.toString(p.getPasses())));
    	this.setCompletions(new SimpleStringProperty(Integer.toString(p.getCompletions())));
    	this.setCatches(new SimpleStringProperty(Integer.toString(p.getCatches())));
    	this.scores = new SimpleStringProperty(Integer.toString(p.getScores()));
    	this.setInjured(new SimpleStringProperty(Boolean.toString(p.getInjured())));
    	this.setGamesPlayed(new SimpleStringProperty(Integer.toString(p.getGamesPlayed())));
    	this.setCompletionRate(new SimpleStringProperty(Double.toString(p.getCompletionRate())));
    }

	public SimpleStringProperty getHeight() {
		return height;
	}

	public void setHeight(SimpleStringProperty height) {
		this.height = height;
	}

	public SimpleStringProperty getAge() {
		return age;
	}

	public void setAge(SimpleStringProperty age) {
		this.age = age;
	}

	public SimpleStringProperty getName() {
		return name;
	}

	public void setName(SimpleStringProperty name) {
		this.name = name;
	}

	public SimpleStringProperty getWeight() {
		return weight;
	}

	public void setWeight(SimpleStringProperty weight) {
		this.weight = weight;
	}

	public SimpleStringProperty getId() {
		return id;
	}

	public void setId(SimpleStringProperty id) {
		this.id = id;
	}

	public SimpleStringProperty getDomHand() {
		return domHand;
	}

	public void setDomHand(SimpleStringProperty domHand) {
		this.domHand = domHand;
	}

	public SimpleStringProperty getPasses() {
		return passes;
	}

	public void setPasses(SimpleStringProperty passes) {
		this.passes = passes;
	}

	public SimpleStringProperty getCompletions() {
		return completions;
	}

	public void setCompletions(SimpleStringProperty completions) {
		this.completions = completions;
	}

	public SimpleStringProperty getScores() {
		return scores;
	}

	public void setScores(SimpleStringProperty scores) {
		this.scores = scores;
	}

	public SimpleStringProperty getCatches() {
		return catches;
	}

	public void setCatches(SimpleStringProperty catches) {
		this.catches = catches;
	}

	public SimpleStringProperty getInjured() {
		return injured;
	}

	public void setInjured(SimpleStringProperty injured) {
		this.injured = injured;
	}

	public SimpleStringProperty getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(SimpleStringProperty gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public SimpleStringProperty getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate(SimpleStringProperty completionRate) {
		this.completionRate = completionRate;
	}
    
    
}
