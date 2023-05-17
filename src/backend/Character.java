package backend;

import backend.Ability;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import java.awt.Image;

public class Character {
    private ArrayList<Ability> abilitySet;
    private String type, region, level;
    private Ability a,b,c,d;
    private int health;
    private int maxHp;
    private final double Bronze = 0.5;
    private final double Silver = 1;
    private final double Gold = 2.5;
    private Image sprite;



    public Character(){
        this.region = "placeholder";
        this.maxHp = health;
    }
    public Character(String Inputtype, String region, Image image, int health){
        type = Inputtype;
        this.region = region;
        abilitySet = new ArrayList<Ability>(4);
        this.sprite = image;
        setHealth(level, health);
        this.maxHp = health;
    }

    public Character(String Inputtype, String region, int hp, int diff){
        type = Inputtype;
        this.region = region;
        this.abilitySet = new ArrayList<Ability>(4);

        difficultyManagement(diff);
        setHealth(level, hp);
        this.maxHp = health;
        System.out.println("Base Health: " + hp+"\nMaxHP: "+ maxHp);
    }
    
    public void difficultyManagement(int diff){
        switch(diff){
            case 0: 
            level = "Bronze";

            case 1: 
            level = "Silver";

            case 2: 
            level = "Gold";

            default: 
                level = "Silver";
        }
    }
    public void setHealth(String level, int baseHp){
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
    public int getMaxHealth(){
        return maxHp;
    }
    public boolean getStatus(){
        if(getHealth()<=0)
            return false;
        return true;
    }
    
    public void setLevel(String lvl){
        level = lvl;
    }
    public String getName(){
        return "";
    }
    public ImageIcon getIcon(String s){
        if(s.equals("icon")){
            return getIcon();
        } else if(s.equals("basicATKicon")){
            return getBasicAttackIcon();
        } else if(s.equals("AB1icon")){
            return getAbilityIcon();
        } else if(s.equals("ultIcon")){
            return getUltIcon();
        }
        return null;
    }

    public String getAnimation(String s){
        if(s.equals("basicATKanim")){
            return getBasicATKAnim();
        } else if(s.equals("ABanim")){
            return getAbilityAnim();
        } else if(s.equals("ultAnim")){
            return getUltAnim();
        } else if(s.equals("deathAnim")){
            return getDeathAnim();
        } else if(s.equals("idleAnim")){
            return getIdleAnim();
        } else if(s.equals("spawnAnim")){
            return getSpawnAnim();
        }
        return null;

    }

    public ImageIcon getIcon(){
        return null;
    }
    public ImageIcon getBasicAttackIcon(){
        return null;
    }
    public ImageIcon getAbilityIcon(){
        return null;
    }
    public ImageIcon getUltIcon(){
        return null;
    }
    public String getBasicATKAnim(){
        return null;
    }
    public String getUltAnim(){
        return null;
    }
    public String getAbilityAnim(){
        return null;
    }
    public String getIdleAnim(){
        return null;
    }
    public String getDeathAnim(){
        return null;
    }
    public String getSpawnAnim(){
        return null;
    }
}