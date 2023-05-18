package backend;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class KhaZix extends CharacterWrapperSq{
    private static String region = "Void";
    private static String type = "Mage";
    private Ability a = new Ability("Unseen Threat", 35, 0.2, 0.2, false, false, false);
    private Ability b = new Ability("Void Spike", 45, 0.2, 0.2, false, false, false);
    private Ability c = new Ability("Taste their Fear", 60, 0.1, 0.1, false, false, true);
    private Ability d = new Ability("Auto Attack", 40, 0.2, 0.1, false, false, false);
    private ImageIcon characterIcon = new ImageIcon("lib/icons/abilities/khazix icon.png");
    private ImageIcon basickATKIcon = new ImageIcon("lib/icons/abilities/khazix basicATK.png");
    private ImageIcon abilityIcon = new ImageIcon("lib/icons/abilities/khazix AB1.png");
    private ImageIcon ultIcon = new ImageIcon("lib/icons/abilities/khazix ult.png");
    private ImageIcon basickAtkAnim = new ImageIcon("lib/animations/Kha/KhaATK.gif");
    private ImageIcon ABAnim = new ImageIcon("lib/animations/Kha/KhaAbility.gif");
    private ImageIcon ultAnim = new ImageIcon("lib/animations/Kha/KhaUlt.gif");
    private ImageIcon deathAnim = new ImageIcon("lib/animations/Kha/KhaDeath.gif");
    private ImageIcon idleAnim = new ImageIcon("lib/animations/Kha/KhaIdle.gif");
    private ImageIcon spawnAnim = new ImageIcon("lib/animations/Kha/KhaIdle.gif");
    
    public KhaZix(int diff){
        super(type, region, 100, diff);
        // System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Kha'Zix";
    }
    public ImageIcon getIcon(String s, boolean b){
        if(s.equals("icon")){
            return getCharacterIcon(b);
        } else if(s.equals("basicATKicon")){
            return getBasicAttackIcon(b);
        } else if(s.equals("AB1icon")){
            return getAbilityIcon(b);
        } else if(s.equals("ultIcon")){
            return getUltIcon(b);
        }
        return null;
    }

    public ImageIcon getAnimation(String s, boolean b){
        if(s.equals("basicATKanim")){
            return getBasicATKAnim(b);
        } else if(s.equals("ABanim")){
            return getAbilityAnim(b);
        } else if(s.equals("ultAnim")){
            return getUltAnim(b);
        } else if(s.equals("deathAnim")){
            return getDeathAnim(b);
        } else if(s.equals("idleAnim")){
            return getIdleAnim(b);
        } else if(s.equals("spawnAnim")){
            return getSpawnAnim(b);
        }
        return null;

    }

    public ImageIcon getCharacterIcon(boolean b){
        return characterIcon;
    }
    public ImageIcon getBasicAttackIcon(boolean b){
        return basickATKIcon;
    }
    public ImageIcon getAbilityIcon(boolean b){
        return abilityIcon;
    }
    public ImageIcon getUltIcon(boolean b){
        return ultIcon;
    }
    public ImageIcon getBasicATKAnim(boolean b){
        return basickAtkAnim;
    }
    public ImageIcon getUltAnim(boolean b){
        return ultAnim;
    }
    public ImageIcon getAbilityAnim(boolean b){
        return ABAnim;
    }
    public ImageIcon getIdleAnim(boolean b){
        return idleAnim;
    }
    public ImageIcon getDeathAnim(boolean b){
        return deathAnim;
    }
    public ImageIcon getSpawnAnim(boolean b){
        return spawnAnim;
    }




}
