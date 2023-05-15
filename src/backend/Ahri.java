package backend;

import java.awt.Point;
import java.util.ArrayList;

public class Ahri extends CharacterWrapperSq{
    private static String region = "Ionian";
    private static String type = "Mage";
    private Ability a = new Ability("Spirit Orb", 40, 0.2, 0.2, false, false, false);
    private Ability b = new Ability("Fox Fire", 35, 0.35, 0.2, false, false, false);
    private Ability c = new Ability("Charm", 30, 0.2, 0.2, false, false, true);
    private Ability d = new Ability("Auto Attack", 20, 0.2, 0.2, false, false, false);
    
    public Ahri(int diff){
        super(type, region, 100, diff);
        System.out.println(type + "," + region);
        setAbilities(a, b, c, d);
    }
    public String getName(){
        return "Ahri";
    }
    
    public static void main(String[] arg){
        ArrayList<Character> testCharacter = new ArrayList<Character>();
        testCharacter.add(new Garen(0));
        testCharacter.add(new Ahri(0));
        
        Player player1 = new Player(1, testCharacter);
        Player player2 = new Player(1, testCharacter);
        Board board = new Board(player1, player2);
        Turnstile turnstile = new Turnstile(board);
    }


}

