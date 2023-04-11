package backend;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
public class Player {

    private ArrayList<Character> playerRoster;
    private int currentCharacter;
    private Point point;

    public Player(String diff, boolean placement){

        if(placement){
            this.point = new Point(20,20);
        }
        else{
            this.point = new Point(80, 80);
        }
        currentCharacter = 0;
        playerRoster = new ArrayList<Character>();
    }

    
    public int getChoice(){
        Scanner obj = new Scanner(System.in);
        return Integer.parseInt(obj.nextLine());
    } 

    public void swapCharacter(int i){
        currentCharacter = i;
    }

    public Point getPoint(){
        return point;
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
