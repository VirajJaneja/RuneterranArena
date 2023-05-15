package backend;

import java.awt.Point;

import frontend.gameFrame;

public class Turnstile {
    static Board battlefield;
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
        gf = new gameFrame(new Point(1980, 1080), this);
        battlefield = new Board(playerOne, playerTwo);

    }

    public Turnstile(Board board) {
        
    }

    public enum Turn {
        P1Turn {
            @Override
            public void run() {
                if(!(battlefield.gameOver().equals("Ongoing")))
                    gameOver = true;
                else if(!(turnCounter<1)){
                    Board.makeMove(playerTwo.getNextTurn(), playerTwo, playerOne);
                }
            }
        },
        P2Turn {
            @Override
            public void run() {
                if(!(battlefield.gameOver().equals("Ongoing")))
                    gameOver = true;
                else if(!(turnCounter<1))
                    Board.makeMove(playerTwo.getNextTurn(), playerTwo, playerOne);
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
            gf.gp.cPane.setConfirmButtonPresence(1);
        }
        System.out.println(turn);
        if(!gameOver){
            System.out.println("here");
            turn = nextStep;
            // turn.run();
        }
        System.out.println(turn);
    }
    public static void finishGame(){
        gf.mainFrame.dispose();
    }
}
