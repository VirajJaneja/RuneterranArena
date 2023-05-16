package backend;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Garen extends CharacterWrapperSq{
    private static String region = "Demacian";
    private static String type = "Fighter";
    private Ability a = new Ability("Decisive Strike", 40, 0.15, 0.2, false, false, false);
    private Ability b = new Ability("Courage", 35, 3, 0.2, false, false, true);
    private Ability c = new Ability("Justice", 65, 3, 0.2, false, false, false);
    private Ability d = new Ability("Auto Attack", 25, 0.15, 0.2, false, false, false);
    
    public Garen(int diff){
        super(type, region, 120, diff);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Garen";
    }
    
    public ImageIcon getIcon(){
        return new ImageIcon("lib/placeholder");
    }


}