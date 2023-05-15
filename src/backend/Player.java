package backend;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
public class Player {

    private ArrayList<CharacterWrapperSq> playerRoster;
    private int currentCharacter;
    public static int nextTurn;
    public static int pointsCounter;
    

    public Player(int teamSize, ArrayList<CharacterWrapperSq> characs){
        currentCharacter = 0;
        playerRoster = characs;
    }

    public void swapCharacter(int i){
        currentCharacter = i;
    }
    public Character getCharacter(int i){
        return playerRoster.get(i);
    }
    public Character getCurrentCharacter(){
        return playerRoster.get(currentCharacter);
    }
    public void addCharacter(CharacterWrapperSq chara){
        playerRoster.add(chara);
    }
    public int getSize(){
        return playerRoster.size();
    }
    public void setNextTurn(int i){
        nextTurn = i;
    }
    public Integer getNextTurn(){
        return nextTurn;
    }
}
