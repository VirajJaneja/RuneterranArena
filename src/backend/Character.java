package backend;

import backend.Ability;

import java.util.ArrayList;
import java.awt.Image;

public class Character {
    private ArrayList<Ability> abilitySet;
    private String type, region, level;
    private Ability a,b,c,d;
    private int health;
    private final double Bronze = 0.5;
    private final double Silver = 1;
    private final double Gold = 2.5;
    private Image sprite;

    public Character(String Inputtype, String region, Image image, double health){
        type = Inputtype;
        this.region = region;
        abilitySet = new ArrayList<Ability>(4);
        this.sprite = image;
        setHealth(level, health);
    }

    public Character(String Inputtype, String region, int hp, int diff){
        type = Inputtype;
        this.region = region;
        this.abilitySet = new ArrayList<Ability>(4);
        difficultyManagement(diff);
        setHealth(level, hp);
    }
    
    public void difficultyManagement(int diff){
        switch(diff){
            case 0: level = "Bronze";
            case 1: level = "Silver";
            case 2: level = "Gold";
            default: level = "Silver";
        }
    }
    public void setHealth(String level, double baseHp){
        if(level.equals("Bronze")){
            this.health = (int)(baseHp * Bronze);
        }
        else if(level.equals("Silver")){
            this.health = (int)(baseHp * Silver);
        }
        else if(level.equals("Gold")){
            this.health = (int)(baseHp * Gold);
        }
    }

    public void updateHealth(int b){
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
    public String getType(){return type;}

    public int getHealth(){
        return health;
    }
    public void setLevel(String lvl){
        level = lvl;
    }
}