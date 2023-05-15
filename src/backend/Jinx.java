package backend;

import java.awt.Point;
import java.util.ArrayList;

public class Jinx extends CharacterWrapperSq{
    private static String region = "Zaun";
    private static String type = "Marksman";
    private Ability a = new Ability("Zap Cannon", 30, 0.4, 0.25, false, false, false);
    private Ability b = new Ability("Flame Chompers", 45, 0.2, 0.1, false, false, false);
    private Ability c = new Ability("Super Mega Death Rocket!", 45, 0.2, 0.1, false, false, true);
    private Ability d = new Ability("Auto Attack", 40, 0.2, 0.1, false, false, false);
    
    public Jinx(int diff){
        super(type, region, 80, diff);
        System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Jinx";
    }



}
