package backend;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
public class Player {

    private ArrayList<CharacterWrapperSq> playerRoster;
    private int currentCharacter;
    public static int nextTurn;
    public static int pointsCounter;
    public static int skillPoints;
    

    public Player(int teamSize, ArrayList<CharacterWrapperSq> characs){
        currentCharacter = 0;
        playerRoster = characs;
        skillPoints = 0;
    }

    public void swapCharacter(int i){
        currentCharacter = i;
    }
    public CharacterWrapperSq getCharacter(int i){
        return playerRoster.get(i);
    }
    public CharacterWrapperSq getCurrentCharacter(){
        return playerRoster.get(currentCharacter);
    }
    public void addCharacter(CharacterWrapperSq chara){
        playerRoster.add(chara);
    }
    public int getSize(){
        return playerRoster.size();
    }
    public ArrayList<CharacterWrapperSq> getRoster(){
        return playerRoster;
    }
    public void setNextTurn(int i){
        nextTurn = i;
    }
    public Integer getNextTurn(){
        return nextTurn;
    }
    public void setCharacter(CharacterWrapperSq charac, int oldIndex){
        playerRoster.set(oldIndex, charac);
    }
    
}
