
public class Ability {
    int maxDmg, minDmg;
    double critChance, missChance;
    String type, name;
    Boolean effect;
    
   public Ability(String type, String name, int a, int b, double c, double d, boolean effect){
        this.maxDmg = a;
        this.minDmg = b;
        this.critChance = c;
        this.missChance = d;
        this.type = type;
        this.name = name;
        if(effect){

        }
   }
}

