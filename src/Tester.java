public class Tester{
    public static void main(String[] args){
        RunRuneterranArena game = new RunRuneterranArena();
        System.out.println(game.CharReg.CHARACTERS.get(0).getHealth());
        System.out.println(game.CharReg.CHARACTERS.get(0).getAbility(0).getCritChance());
        System.out.println(game.CharReg.CHARACTERS.get(0).getAbility(0).getEffect());
    }
}
