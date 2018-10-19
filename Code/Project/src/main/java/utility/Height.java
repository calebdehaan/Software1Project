package utility;

public class Height {
    private Unit units;
    
    // Assumed to be metric
    private int majorUnit, minorUnit;
    
    
    public Height(int majorUnit, int minorUnit){
        this(Unit.Metric, majorUnit, minorUnit);
    }
    
    public Height(Unit units, int major, int minor){
        this.units = units;
        this.setMajorUnit(major);
        this.setMinorUnit(minor);
    }
    
    public Unit getUnits() {
        return units;
    }
    
    public void setUnits(Unit units) {
        this.units = units;
    }
    
    public int getMajorUnit() {
        return majorUnit;
    }
    
    public void setMajorUnit(int majorUnit) {
        this.majorUnit = majorUnit;
    }
    
    public int getMinorUnit() {
        return minorUnit;
    }
    
    public void setMinorUnit(int minorUnit) {
        this.minorUnit = minorUnit;
    }
}
