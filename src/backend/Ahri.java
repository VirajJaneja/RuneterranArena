package backend;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ahri extends CharacterWrapperSq{
    private static String region = "Ionian";
    private static String type = "Mage";
    private Ability a = new Ability("Spirit Orb", 40, 0.2, 0.2, false, false, false);
    private Ability b = new Ability("Fox Fire", 35, 0.35, 0.2, false, false, false);
    private Ability c = new Ability("Charm", 30, 0.2, 0.2, false, false, true);
    private Ability d = new Ability("Auto Attack", 20, 0.2, 0.2, false, false, false);
    private ImageIcon characterIcon = new ImageIcon("lib/icons/abilities/ahri icon.png");
    private ImageIcon basickATKIcon = new ImageIcon("lib/icons/abilities/ahri basicATK.png");
    private ImageIcon abilityIcon = new ImageIcon("lib/icons/abilities/ahri AB1.png");
    private ImageIcon ultIcon = new ImageIcon("lib/icons/abilities/ahri ult.png");

    private ImageIcon basickAtkAnim = new ImageIcon("lib/animations/Ahri/AhriATK.gif");
    private ImageIcon ABAnim =  new ImageIcon("lib/animations/Ahri/AhriAbility.gif");
    private ImageIcon ultAnim =  new ImageIcon("lib/animations/Ahri/AhriUltAnim.gif");
    private ImageIcon deathAnim =  new ImageIcon("lib/animations/Ahri/AhriDeath.gif");
    private ImageIcon idleAnim =  new ImageIcon("lib/animations/Ahri/AhriNewIdle.gif");
    
    public Ahri(int diff){
        super(type, region, 100, diff);
        // System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Ahri";
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
        return idleAnim;
    }


}

