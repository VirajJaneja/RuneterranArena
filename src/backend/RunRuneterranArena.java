package backend;

import frontend.MainScreen;

import java.awt.Point;
import java.util.ArrayList;

import frontend.*;

public class RunRuneterranArena {

    public static void main(String[] args) {
        ArrayList<CharacterWrapperSq> testCharacter = new ArrayList<CharacterWrapperSq>();

        ArrayList<CharacterWrapperSq> characs = new ArrayList<CharacterWrapperSq>();
        characs.add(new Garen(2));
        System.out.println(characs.size());
        characs.add(new Jinx(2));
        characs.add(new KhaZix(2));
        characs.add(new Malzahar(2));
        characs.add(new Taric(2));

        
        Player player1 = new Player(characs.size(), characs);
        Player player2 = new Player(characs.size(), characs);
        Turnstile turnstile = new Turnstile(player1, player2);

        

        // gameFrame mf = new gameFrame(new Point(1980, 1080));
        // mf.mainFrame.getContentPane().removeAll();
        // mf.mainFrame.getContentPane().add(gm);
    }
}
