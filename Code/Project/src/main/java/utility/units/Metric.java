package utility.units;

public class Metric implements Unit {
    private int meters;
    private int centimeters;
    private double kilograms;
    
    public int getMeters() {
        return meters;
    }
    
    public void setMeters(int meters) {
        this.meters = meters;
    }
    
    public int getCentimeters() {
        return centimeters;
    }
    
    public void setCentimeters(int centimeters) {
        this.centimeters = centimeters;
    }
    
    public double getKilograms() {
        return kilograms;
    }
    
    public void setKilograms(double kilograms) {
        this.kilograms = kilograms;
    }
}
