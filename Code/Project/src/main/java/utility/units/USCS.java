package utility.units;

public class USCS implements Unit {
    private int feet;
    private int inches;
    private int yards;
    private double pounds;
    
    public int getFeet() {
        return feet;
    }
    
    public void setFeet(int feet) {
        this.feet = feet;
    }
    
    public int getInches() {
        return inches;
    }
    
    public void setInches(int inches) {
        this.inches = inches;
    }
    
    public int getYards() {
        return yards;
    }
    
    public void setYards(int yards) {
        this.yards = yards;
    }
    
    public double getPounds() {
        return pounds;
    }
    
    public void setPounds(double pounds) {
        this.pounds = pounds;
    }
}
