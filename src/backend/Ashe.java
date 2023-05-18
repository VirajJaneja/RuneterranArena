package backend;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ashe extends CharacterWrapperSq{
    private static String region = "Demacian";
    private static String type = "Marksman";
    private Ability a = new Ability("Frost Arrow", 30, 0.4, 0.25, false, false, false);
    private Ability b = new Ability("Ice Volley", 45, 0.2, 0.1, false, false, false);
    private Ability c = new Ability("Piercing Cold", 45, 0.2, 0.1, false, false, true);
    private Ability d = new Ability("Auto Attack", 40, 0.2, 0.1, false, false, false);
    private ImageIcon characterIcon = new ImageIcon("lib/icons/abilities/ashe icon.png");
    private ImageIcon basickATKIcon = new ImageIcon("lib/icons/abilities/ashe basicATK.png");
    private ImageIcon abilityIcon = new ImageIcon("lib/icons/abilities/ashe AB1.png");
    private ImageIcon ultIcon = new ImageIcon("lib/icons/abilities/ashe ult.png");
    
    private ImageIcon basickAtkAnim = new ImageIcon("lib/animations/Ashe/AsheBasicATK.gif");
    private ImageIcon ABAnim =  new ImageIcon("lib/animations/Ashe/AsheABility.gif");
    private ImageIcon ultAnim =  new ImageIcon("lib/animations/Ashe/AsheUlt.gif");
    private ImageIcon deathAnim =  new ImageIcon("lib/animations/Ashe/AsheDeathAnim.gif");
    private ImageIcon idleAnim =  new ImageIcon("lib/animations/Ashe/AsheIdle.gif");
    

    
    public Ashe(int diff){
        super(type, region, 80, diff);
        // System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Ashe";
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
        return null;
    }




}
