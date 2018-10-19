import utility.DominantHand;
import utility.Height;
import utility.Weight;

public class Player {
    private Height height;
    private Weight weight;
    private int age = -1;
    private long id;
    private String name;
    private DominantHand domHand = DominantHand.Right;
    
    // Game Stats //
    private int passes = 0;
    private int catches = 0; // TODO: Need this?
    private int scores = 0;
    private int fouls = 0;
    private int injuries = 0;
    private boolean injured = false;
    private int gamesPlayed = 0;
    
    // Constants //
    private static final int AGE_MIN = 10;
    private static final int AGE_MAX = 100;
    private static final long ID_MIN = 0;
    private static final long ID_MAX = 2L * Integer.MAX_VALUE + 1; // Full integer range
    
    // Constructors //
    public Player() {
        this(new Height(0,0), new Weight(0F), AGE_MIN, "none", DominantHand.Right);
    }
    
    public Player(String name) {
        this(new Height(0,0), new Weight(0F), AGE_MIN, name, DominantHand.Right);
    }
    
    public Player(Height height, Weight weight, int age, String name, DominantHand domHand) {
        this.setWeight(weight);
        this.setHeight(height);
        this.setAge(age);
        this.setId(this.hashCode());
        this.setName(name);
        this.setDomHand(domHand);
    }
    
    // Utility Functions //
    public Player clone(){
        Player p = new Player();
        
        p.setWeight(weight);
        p.setHeight(height);
        p.setAge(age);
        p.setId(this.getId());
        p.setName(name);
        p.setDomHand(domHand);
        
        return p;
    }
    
    
    // TODO: Validate input in setters
    // Generated //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Player player = (Player) o;
        
        if (age != player.age) return false;
        if (id != player.id) return false;
        if (!name.equals(player.name)) return false;
        return domHand == player.domHand;
    }
    
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + domHand.hashCode();
        return result;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
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
    
    public int getFouls() {
        return fouls;
    }
    
    public void setFouls(int fouls) {
        this.fouls = fouls;
    }
    
    public int getInjuries() {
        return injuries;
    }
    
    public void setInjuries(int injuries) {
        this.injuries = injuries;
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
}
