package backend;

import frontend.MainScreen;

import java.awt.Point;
import java.util.ArrayList;

import frontend.*;

public class RunRuneterranArena {

    public static void main(String[] args) {
        ArrayList<Character> testCharacter = new ArrayList<Character>();
        ArrayList<Character> characs = new ArrayList<>();
        characs.add(new Garen(0));
        Player player1 = new Player(characs.size(), characs);
        Player player2 = new Player(characs.size(), characs);
        Turnstile turnstile = new Turnstile(player1, player2);

        

        // gameFrame mf = new gameFrame(new Point(1980, 1080));
        // mf.mainFrame.getContentPane().removeAll();
        // mf.mainFrame.getContentPane().add(gm);
    }
}
