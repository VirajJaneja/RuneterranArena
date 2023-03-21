public class Tester{
    public static void main(String[] args){
        Sylas sylas = new Sylas("easy");
        System.out.println(sylas.getHealth());
        System.out.println(sylas.getAbility(0).getCritChance());
        System.out.println(sylas.getAbility(0).getEffect());
    }
}
