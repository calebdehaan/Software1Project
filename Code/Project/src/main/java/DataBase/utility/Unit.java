package DataBase.utility;

public enum Unit {
    Metric, USCS;


    @Override
    public String toString() {
        switch(this){
            case Metric: return "Metric";
            case USCS: return "USCS";
            default: return "Error";
        }
    }
}
