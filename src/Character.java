
import java.util.ArrayList;

import java.awt.Point;

import java.awt.Image;
public class Character {
    private ArrayList<Ability> abilitySet;
    private String type, region, level;
    private Ability a,b,c,d;
    private double health;
    private final double Bronze = 0.5;
    private final double Silver = 1;
    private final double Gold = 2.5;
    private Image sprite;
    private Point position;

    public Character(String type, String region, Image image, double health){
        this.region = region;
        abilitySet = new ArrayList<Ability>(4);  
        this.sprite = image;
        setHealth(level, health);
    }

    public Character(String type, String region, double health){
        this.region = region;
        this.abilitySet = new ArrayList<Ability>(4);  
        setHealth(level, health);
    }

    public void setHealth(String level, double health){
        if(level.equals("Bronze")){
            this.health = health * Bronze;
        }
        else if(level.equals("Silver")){
            this.health = health * Silver;
        }
        else if(level.equals("Gold")){
            this.health = health * Gold;
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
    public void setLevel(String lvl){
        level = lvl;
    }
}
