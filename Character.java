
import java.util.ArrayList;

public class Character {
    ArrayList<Ability> abilitySet;
    String region, diff;
    Ability a,b,c,d;
    double health;
    double hard = 2.5;
    double medium = 1.5;
    double easy = 0.5;
    public Character(String region, String diff, Ability a, Ability b, Ability c, Ability d, double health){
        this.region = region;
        abilitySet = new ArrayList<Ability>(4);  
        setAbilities(a,b,c,d);  

        if(diff.equals("easy")){
            this.health = health*easy;
        }
        else if(diff.equals("hard")){
            this.health = health*hard;
        }
        else if(diff.equals("medium")){
            this.health = health;
        }
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
    public void setHealth(double b){
        this.health = b;
    }
}
