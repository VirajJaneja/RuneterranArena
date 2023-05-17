package backend;

import java.awt.Point;

import frontend.gameFrame;

public class Turnstile {
    public static Board battlefield;
    public static Player playerOne;
    static Player playerTwo;
    static double turnCounter;
    static Turn turn;
    static boolean gameOver;
    static gameFrame gf;
    public Turnstile(Player pOne, Player pTwo){
        turn = Turn.P1Turn;
        turnCounter =0;
        playerOne = pOne;
        playerTwo = pTwo;
        gameOver = false;
        battlefield = new Board(playerOne, playerTwo, gf.gp.fPane);
        gf = new gameFrame(new Point(1080, 520), this);
        for(int i=0;i<pOne.getSize();i++){
            System.out.println(pOne.getCharacter(i).getName());
        }
        System.out.println(playerOne);
        System.out.println(playerTwo);
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
                else if(!(turnCounter<1)){
                    Board.makeMove(playerTwo.getNextTurn(), playerTwo, playerOne);
                    // System.out.println("broken");
                }
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
                    // System.out.println("broken");
                }
            }
        };
    
        public abstract void run();
    }

    public static void moveTurn(){
        Turn nextStep = Turn.P1Turn;
        if(turn == Turn.P1Turn){
            nextStep = Turn.P2Turn;
            gf.gp.cPane.setConfirmButtonPresence(0);
        }
        if(turn == Turn.P2Turn){
            nextStep = Turn.P1Turn;
            nextStep.run();
            gf.gp.cPane.setConfirmButtonPresence(1);
        }
        System.out.println(turn);
        if(!gameOver){
            nextStep.run();
            // System.out.println("here");
            turn = nextStep;
            // turn.run();
        }
        // System.out.println(turn);
    }
    public static void finishGame(){
        gf.mainFrame.dispose();
    }
}
