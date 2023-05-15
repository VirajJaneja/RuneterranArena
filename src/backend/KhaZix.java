package backend;

import java.awt.Point;
import java.util.ArrayList;

public class KhaZix extends CharacterWrapperSq{
    private static String region = "Void";
    private static String type = "Fighter";
    private Ability a = new Ability("Unseen Threat", 30, 0.4, 0.25, false, false, false);
    private Ability b = new Ability("Void Spike", 45, 0.2, 0.1, false, false, false);
    private Ability c = new Ability("Taste their Fear", 45, 0.5, 0.1, false, false, true);
    private Ability d = new Ability("Auto Attack", 40, 0.2, 0.1, false, false, false);
    
    public KhaZix(int diff){
        super(type, region, 80, diff);
        System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Kha'Zix";
    }



}
