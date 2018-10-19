import utility.DominantHand;

public class Player {
    private int height;
    private int weight;
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
    
    
    // Constructors //
    public Player(String name) {
        this(name, -1, DominantHand.Right);
    }
    
    public Player(String name, int age) {
        this(name, age, DominantHand.Right);
    }
    
    public Player(String name, int age, DominantHand hand) {
        this.setName(name);
        this.setAge(age);
        this.setDomHand(hand);
        this.setId(this.hashCode());
    }
    
    // Utility Functions //
    
    /**
     * Simulates a player passing to another player.
     *
     * @param p           The receiving player
     * @param didComplete True if the pass was received by the intended player, otherwise false
     */
    public void passTo(Player p, boolean didComplete) {
        this.passes++;
        if (didComplete) { // TODO: Pass completion logic in here or seperate?
            p.catches++;
        }
    }
    
    
    
    
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
}
