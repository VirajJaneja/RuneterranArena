package backend;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
public class Player {

    private ArrayList<Character> playerRoster;
    private int currentCharacter;
    private Point point;
    

    public Player(int teamSize, ArrayList<Character> characs){
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
    public void addCharacter(Character chara){
        playerRoster.add(chara);
    }
    public int getSize(){
        return playerRoster.size();
    }
}
