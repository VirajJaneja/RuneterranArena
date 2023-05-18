package backend;

import frontend.MainScreen;

import java.awt.Point;
import java.util.ArrayList;

import frontend.*;

public class RunRuneterranArena {

    public static void main(String[] args) {
        ArrayList<CharacterWrapperSq> testCharacter = new ArrayList<CharacterWrapperSq>();

        ArrayList<CharacterWrapperSq> characs = new ArrayList<CharacterWrapperSq>();
        ArrayList<CharacterWrapperSq> characs1 = new ArrayList<CharacterWrapperSq>();

        // characs.add(new Ahri(1));
        // characs.add(new Ahri(2));
        // characs.add(new Ahri(0));
        characs.add(new Garen(1));
        System.out.println(characs.size());
        characs.add(new Jinx(1));


        System.out.println(characs.get(0).getMaxHealth());
        System.out.println(characs.get(1).getMaxHealth());
        System.out.println(characs.get(2).getMaxHealth());
        characs1.add(new KhaZix(1));
        // characs.add(new Malzahar(2));
        characs.add(new Taric(1));

        characs1.add(new Ashe(1));
        characs1.add(new Ahri(1));

        // for(int i =0; i<characs.size(); i++){
        //     System.out.println(characs.get(i).getIcon("icon"));
        //     System.out.println(characs.get(i).getIcon("basicATKicon"));
        //     System.out.println(characs.get(i).getIcon("AB1icon"));
        //     System.out.println(characs.get(i).getIcon("ultIcon"));
        // }

        // characs.get(1).setHealth("Bronze", 0);
        // characs.get(0).setHealth("Bronze", 3);


        
        Player player1 = new Player(characs.size(), characs1);
        Player player2 = new Player(characs.size(), characs);
        ComputerPlayer compPlayer = new ComputerPlayer(2, characs);

        // System.out.println(characs.size() + " " + characs1.size());

        Turnstile turnstile = new Turnstile(player1, compPlayer);

        

        // gameFrame mf = new gameFrame(new Point(1980, 1080));
        // mf.mainFrame.getContentPane().removeAll();
        // mf.mainFrame.getContentPane().add(gm);
    }
}
