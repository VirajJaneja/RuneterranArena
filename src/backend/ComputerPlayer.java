package backend;

import java.util.ArrayList;

public class ComputerPlayer extends Player{
    private int difficulty;
    public ComputerPlayer(int teamSize, ArrayList<CharacterWrapperSq> characs) {
        super(teamSize, characs);
        this.difficulty = difficulty;
    }
    public void setNextTurn(){
        switch(difficulty){
            case 0:
                nextTurn = 0;
                break;
            default:
                nextTurn = (int)(Math.random()*3);
                break;
        }
        
    }
    
}
