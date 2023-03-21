
import java.util.ArrayList;
import java.awt.Image;

public class Character {
    private ArrayList<Ability> abilitySet;
    private String region, diff;
    private Ability a,b,c,d;
    private double health;
    private final double easy = 0.5;
    private final double medium = 1;
    private final double hard = 2.5;
    private Image sprite;

    public Character(String region, String diff, Image image, double health){
        this.region = region;
        abilitySet = new ArrayList<Ability>(4);  
        this.sprite = image;
        setHealth(diff, health);
    }

    public Character(String region, String diff, double health){
        this.region = region;
        this.abilitySet = new ArrayList<Ability>(4);  
        setHealth(diff, health);
    }

    public void setHealth(String diff, double health){
        if(diff.equals("easy")){
            this.health = health * easy;
        }
        else if(diff.equals("medium")){
            this.health = health * medium;
        }
        else if(diff.equals("hard")){
            this.health = health * hard;
        }
    }

    public void updateHealth(double b){
        this.health = b;
    }

    public void setAbilities(Ability a, Ability b, Ability c, Ability d){
        addAbility(a);
        addAbility(b);
        addAbility(c);
        addAbility(d);
    }

    public void addAbility(Ability a){
        abilitySet.add(a);
    }

    public String getRegion(){
        return region;
    }
    public Ability getAbility(int i){
        return abilitySet.get(i);
    }
    public double getHealth(){
        return health;
    }
}
