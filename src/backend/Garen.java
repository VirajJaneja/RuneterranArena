package backend;
import java.awt.Point;

public class Garen extends Character{
    private static String region = "Demacian";
    private static String type = "Fighter";
    private Ability a = new Ability(region, "Decisive Strike", 2, 3, 0.2, 0.1, false);
    private Ability b = new Ability(region, "Courage", 2, 3, 0.2, 0.1, false);
    private Ability c = new Ability(region, "Justice", 2, 3, 0.2, 0.1, false);
    private Ability d = new Ability(region, "Auto Attack", 2, 3, 0.2, 0.1, false);
    
    public Garen(int diff){
        super(type, region, 120, diff);
        System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public static void main(String[] arg){
        new Garen(0);
    }


}