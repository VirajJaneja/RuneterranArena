package backend;

public class Turnstile {
    Board battlefield;
    Player playerOne;
    Player playerTwo;
    public Turnstile(Board board){
        battlefield = board;
        playerOne = battlefield.playerOne;
        playerTwo = battlefield.playerTwo;
    }

    public String playGame(){
        while(battlefield.gameOver().equals("Ongoing")) {
            battlefield.makeMove(battlefield.playerOne.getChoice(), playerOne, playerTwo);
            battlefield.makeMove(battlefield.playerTwo.getChoice(), playerTwo, playerOne);
        }
        return battlefield.gameOver();
    }
}
