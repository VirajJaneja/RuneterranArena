package backend;
import java.awt.Point;
import java.util.ArrayList;

public class Ashe extends Character{
    private static String region = "Demacian";
    private static String type = "Marksman";
    private Ability a = new Ability("Frost Arrow", 30, 0.4, 0.25, false, false, false);
    private Ability b = new Ability("Ice Volley", 45, 0.2, 0.1, false, false, false);
    private Ability c = new Ability("Piercing Cold", 45, 0.2, 0.1, false, false, true);
    private Ability d = new Ability("Auto Attack", 40, 0.2, 0.1, false, false, false);
    
    public Ashe(int diff){
        super(type, region, 80, diff);
        System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Ashe";
    }



}
