package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

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
                while(!(nextTurn<=skillPoints)){
                    nextTurn = (int)(Math.random()*3);
                };

            case 1:
                if(skillPoints == 0)
                    nextTurn = 0;
                else
                    nextTurn = 1;
                break;
            case 2:
                if(getCurrentCharacter().getHealth()<50){
                    if(skillPoints>2)
                        nextTurn = 2;
                    else
                        nextTurn = 0;
                } else if(skillPoints == 0)
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
        // Timer timer = new Timer(2100, new ActionListener() {

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         // TODO Auto-generated method stub
        //         throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        //     }
            
        // });

        // System.out.println(skillPoints + "I AM HERE");

        return nextTurn;
        
    }
    
}
