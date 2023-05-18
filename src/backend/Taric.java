package backend;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Taric extends CharacterWrapperSq{
    private static String region = "Targon";
    private static String type = "Fighter";
    private Ability a = new Ability("Bastion", 30, 0.4, 0.25, false, false, false);
    private Ability b = new Ability("Starlight's touch", 45, 0.2, 0.1, true, false, true);
    private Ability c = new Ability("Cosmic Radiance", 50, 0.7, 0.01, false, false, true);
    private Ability d = new Ability("Auto Attack", 40, 0.2, 0.1, false, false, false);
    private ImageIcon characterIcon = new ImageIcon("lib/icons/abilities/taric icon.png");
    private ImageIcon basickATKIcon = new ImageIcon("lib/icons/abilities/taric basicATK.png");
    private ImageIcon abilityIcon = new ImageIcon("lib/icons/abilities/taric AB1.png");
    private ImageIcon ultIcon = new ImageIcon("lib/icons/abilities/taric ult.png");
    private ImageIcon basickAtkAnim = new ImageIcon("lib/animations/Taric/TaricATK.gif");
    private ImageIcon ABAnim = new ImageIcon("lib/animations/Taric/TaricAbility.gif");
    private ImageIcon ultAnim = new ImageIcon("lib/animations/Taric/TaricUlt.gif");
    private ImageIcon deathAnim = new ImageIcon("lib/animations/Taric/TaricDeath.gif");
    private ImageIcon idleAnim = new ImageIcon("lib/animations/Taric/TaricIdle.gif");
    private ImageIcon spawnAnim = new ImageIcon("lib/animations/Taric/TaricIdle.gif");
    
    public Taric(int diff){
        super(type, region, 130, diff);
        // System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Taric";
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
