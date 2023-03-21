
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
        this.effect = effect;
        if(effect){
            //bs for later
        }
   }

   public String getType(){
     return type;
   }

   public String getName(){
     return name;
   }

   public double getCritChance(){
     return critChance;
   }

   public void setCritChance(double b){
     this.critChance = b;
   }

   public double getMissChance(){
     return missChance;
   }

   public void setMissChance(double b){
     this.missChance = b;
   }

   public boolean getEffect(){
     return effect;
   }
   public String toString(){
      return ("Name: "+ name + "\nType: "+type + "maxDmg"+ maxDmg + "\nminDmg: "+ minDmg + "\ncritRate"+ critChance + "\nmissChance: "+ missChance);  
   }
}

