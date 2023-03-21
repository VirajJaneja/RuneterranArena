import java.awt.Image;

public class Sylas extends Character{
    private static String region = "Demacian";
    private Ability a = new Ability(region, "q", 2, 3, 0.2, 0.1, false);
    private Ability b = new Ability(region, "w", 2, 3, 0.2, 0.1, false);
    private Ability c = new Ability(region, "e", 2, 3, 0.2, 0.1, false);
    private Ability d = new Ability(region, "r", 2, 3, 0.2, 0.1, false);
    
    public Sylas(String diff){
        super("Demacian", diff, 60);
        setAbilities(a, b, c, d);
    }


}
