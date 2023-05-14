package backend;

import frontend.MainScreen;

import java.awt.Point;
import java.util.ArrayList;

import frontend.*;

public class RunRuneterranArena {

    public static void main(String[] args) {
        Ability ab1 = ;
        Ability ab2 = ;
        Ability ab3 = ; 
        Ability[] abilities = {};
        ArrayList<Character> characs = new ArrayList<>();
        Player player1 = new Player("Bronze", characs);
        Player player2 = new Player("Bronze", characs);
        Board board = new Board(player1, player2);
        Turnstile turnstile = new Turnstile(board);

        gameFrame mf = new gameFrame(new Point(1980, 1080));
        // mf.mainFrame.getContentPane().removeAll();
        // mf.mainFrame.getContentPane().add(gm);
    }
}
