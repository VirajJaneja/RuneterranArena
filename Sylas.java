
public class Sylas extends Character{
    static String region = "Demacian";
    static Ability a = new Ability(region, "q", 2, 3, 0.2, 0.1, false);
    static Ability b = new Ability(region, "w", 2, 3, 0.2, 0.1, false);
    static Ability c = new Ability(region, "e", 2, 3, 0.2, 0.1, false);
    static Ability d = new Ability(region, "r", 2, 3, 0.2, 0.1, false);

    public Sylas(){
        super(region, a, b, c, d);
    }


}
