import java.awt.Point;

public class Garen extends Character{
    private static String region = "Demacian";
    private Ability a = new Ability(region, "q", 2, 3, 0.2, 0.1, false);
    private Ability b = new Ability(region, "w", 2, 3, 0.2, 0.1, false);
    private Ability c = new Ability(region, "e", 2, 3, 0.2, 0.1, false);
    private Ability d = new Ability(region, "r", 2, 3, 0.2, 0.1, false);
    
    public Garen(String diff, Point p){
        super(region, diff, 120, p);
        setAbilities(a, b, c, d);
    }


}