package backend;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.ActionEvent;

import frontend.gameFrame;

public class Turnstile {
    public static Board battlefield;
    public static Player playerOne;
    static Player playerTwo;
    static double turnCounter;
    static Turn turn;
    static boolean gameOver;
    public static gameFrame gf;
    public Turnstile(Player pOne, Player pTwo){
        turn = Turn.P1Turn;
        turnCounter =0;
        playerOne = pOne;
        playerTwo = pTwo;
        gameOver = false;
        battlefield = new Board(playerOne, playerTwo, gf.gp.fPane);
        gf = new gameFrame(new Point(1080, 520), this);
        for(int i=0;i<pOne.getSize();i++){
            // System.out.println(pOne.getCharacter(i).getName());
        }
        // System.out.println(playerOne);
        // System.out.println(playerTwo);
    }

    public enum Turn {
        P1Turn {
            @Override
            public void run() {
                // System.out.println("here1");
                if(!(battlefield.gameOver().equals("Ongoing"))){
                    gameOver = true;
                    // System.out.println("herez");
                }
                else {
                    Board.makeMove(playerTwo.getNextTurn(), playerTwo, playerOne);
                    gf.gp.tPane.repaint();
                    if(!(battlefield.gameOver().equals("Ongoing"))){
                        finishGame(battlefield.gameOver());
                    }
                    // System.out.println("broken");
                }
                gf.gp.cPane.setConfirmButtonPresence(1);
            }
        },
        P2Turn {
            @Override
            public void run() {
                // System.out.println("here2");
                if(!(battlefield.gameOver().equals("Ongoing"))){
                    gameOver = true;
                    // System.out.println("here");
                    
                }
                else{
                    Board.makeMove(playerOne.getNextTurn(), playerOne, playerTwo);
                    gf.gp.tPane.repaint();
                    if(!(battlefield.gameOver().equals("Ongoing"))){
                        finishGame(battlefield.gameOver());
                    }
                    // System.out.println("broken");
                    moveTurn();

                }
            }
        };
    
        public abstract void run();
    }

    public static void moveTurn(){
        // Turn nextStep = Turn.P1Turn;
        if(turn == Turn.P1Turn){
            turn = Turn.P2Turn;
            turn.run();
            gf.gp.cPane.setConfirmButtonPresence(0);
        }
        if(turn == Turn.P2Turn){
            // System.out.println("this one right here");
            turn = Turn.P1Turn;
            turn.run();
            gf.gp.cPane.setConfirmButtonPresence(1);
        }
        // System.out.println(turn);
        if(!gameOver){
            // turn.run();
            // System.out.println("here");
            turn = turn;
            // turn.run();
        }
        // System.out.println(turn);
        // System.out.println("whole loop");
    }


    public static void finishGame(String s){
        gf.mainFrame.dispose();
    }
    public Player getPlayer(boolean b){
        if(b)
            return playerOne;
        return playerTwo;
    }
    public gameFrame getGF(){
        return gf;
    }
}
