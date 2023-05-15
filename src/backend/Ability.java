package backend;

public class Ability {
    int maxDmg, minDmg;
    double critChance, missChance;
    String type, name;
    Boolean effect;
    int[] DOTList;
    int[] CCList;
    int[] ShieldList;

   public Ability(String name, int minDmg, double critChance, double missChance, boolean DOT, boolean CC, boolean Shield){
        this.minDmg = minDmg;
        this.critChance = critChance;
        this.missChance = missChance;
        this.name = name;

        if(DOT){
          DOTList = DOT(minDmg, (int)(Math.random()*3));
        } else{
          DOTList = null;
        }
        if(CC){
          CCList = CC(minDmg, 1);
        } else{
          CCList = null;
        }
        if(Shield){
          ShieldList = Shield(minDmg, 1);
        } else{
          ShieldList = null;
        }
   }
   
  //  public Ability(String type2, int i, double d, double e, boolean b, boolean c, boolean f) {
  //  }

// public Ability(String type2, String string, int i, int j, double d, double e, boolean b, boolean c, boolean f) {
// }

public int[] DOT(int totaldmg, int turncount){
      return new int[]{totaldmg, turncount};
   }
   public int[] getDOT(){
    return DOTList;
   }
   public int[] Shield(int dmgAbsorb, int turn){
    return new int[]{dmgAbsorb, turn};
   }
   public int[] CC(int dmg, int turns){
    return new int[]{dmg, turns};
   }
   public int[] getCC(){
    return CCList;
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

