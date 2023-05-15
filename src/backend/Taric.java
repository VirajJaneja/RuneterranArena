package backend;
import java.awt.Point;
import java.util.ArrayList;

public class Taric extends CharacterWrapperSq{
    private static String region = "Targon";
    private static String type = "Fighter";
    private Ability a = new Ability("Bastion", 30, 0.4, 0.25, false, false, false);
    private Ability b = new Ability("Starlight's touch", 45, 0.2, 0.1, true, false, true);
    private Ability c = new Ability("Cosmic Radiance", 45, 0.2, 0.1, false, false, true);
    private Ability d = new Ability("Auto Attack", 40, 0.2, 0.1, false, false, false);
    
    public Taric(int diff){
        super(type, region, 80, diff);
        System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Taric";
    }



}
