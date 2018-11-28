package DataBase.utility;

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
    
    public Height(String input) throws NumberFormatException{
        String tokens[] = input.trim().split(",");
        this.majorUnit = Integer.valueOf(tokens[0]);
        this.minorUnit = Integer.valueOf(tokens[1]);
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
    
    @Override
    public String toString() {
        return majorUnit + "." + minorUnit + " " + units;
    }

    @Override
    public boolean equals(Object that){
        if(that instanceof Height){
            return this.majorUnit == ((Height) that).majorUnit
                    && this.minorUnit == ((Height) that).minorUnit
                    && this.units == ((Height) that).units;
        }

        return false;
    }
}
