package backend;

import java.util.ArrayList;

public class ComputerPlayer extends Player{
    private int difficulty;
    public ComputerPlayer(int teamSize, ArrayList<CharacterWrapperSq> characs) {
        super(teamSize, characs);
        this.difficulty = difficulty;
    }
    public Integer getNextTurn(){
        System.out.println(skillPoints + " I AM HERE");
        switch(difficulty){
            case 0:
                if(skillPoints == 0)
                    nextTurn = 0;
                else
                    nextTurn = 1;
                break;
            default:
                if(skillPoints == 0)
                    nextTurn = 0;
                else
                    nextTurn = 1;
                break;
        }
        System.out.println(skillPoints + "I AM HERE");

        return nextTurn;
        
    }
    
}
