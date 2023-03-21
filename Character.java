
import java.util.ArrayList;

public class Character {
    ArrayList<Ability> abilitySet;
    String region;
    Ability a,b,c,d;
    int health;
    public Character(String region, Ability a, Ability b, Ability c, Ability d){
        this.region = region;
        abilitySet = new ArrayList<Ability>(4);  
        setAbilities(a,b,c,d);     
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
}
