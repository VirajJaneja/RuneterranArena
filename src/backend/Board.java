package backend;

import java.lang.annotation.Target;

import org.omg.CORBA.ARG_IN;

public class Board {
    public static Player playerOne;
    static CharacterWrapperSq deployedCharacterOne;
    static CharacterWrapperSq deployedCharacterTwo;
    public static Player playerTwo;
    public static int P1CPos;
    public static int P2CPos;

    public Board(Player playerUno, Player playerDos){
        playerOne = playerUno;
        playerTwo = playerDos;
        deployedCharacterOne = playerOne.getCharacter(0);
        deployedCharacterTwo = playerTwo.getCharacter(0);
        P1CPos = 0;
        P2CPos = 0;
    }


    public static boolean makeMove(int i, Player aggressor, Player idlePlayer){
        // System.out.println("PLEASE WORK FOR THE LOVE OF GOD");
        CharacterWrapperSq target;
        CharacterWrapperSq targetter;
        if(aggressor.equals(playerOne)){
            target = deployedCharacterOne;
            targetter = deployedCharacterTwo;
        } else {
            targetter = deployedCharacterOne;
            target = deployedCharacterTwo;
        }
        System.out.println(deployedCharacterOne.getName());
        // System.out.println("here");
        switch(i){
            case 0:
            case 1:
            case 2:
                dealDamage(target, (int)(calculateDamage(target, targetter, target.getAbility(i))));
            case 3:
            case 13:
            case 23:
            case 33:
            case 43:
                swapCharacters(aggressor, target, getCharacPos(aggressor), (i-3)/10);
                System.out.println("do smth");
                break;
        }
        System.out.println(deployedCharacterOne.getName());
        return false;
    }

    public static void dealDamage(CharacterWrapperSq target, int damage){
        damage = (int) damage;
        target.updateHealth(target.getHealth()-damage);
    }

    private static double calculateDamage(CharacterWrapperSq target, CharacterWrapperSq targetter, Ability a){
        double baseDMG = a.minDmg;
        double result = baseDMG;
        if(Math.random()<=a.critChance)
            result += baseDMG*.5;
        if(doesCounter(targetter, target))
            result += baseDMG*.25;
        if(Math.random()<a.missChance)
            result =0;
        return result;

    }

    // private static CharacterWrapperSq getCharacter(Player player){
    //     if(player.equals(playerOne)){
    //         return deployedCharacterOne;
    //     } else {
    //         return deployedCharacterTwo;
    //     }
    // }

    private static int getCharacPos(Player player){
        if(player.equals(playerOne)){
            return P1CPos;
        } else {
            return P2CPos;
        }
    }

    private static void swapCharacters(Player player, CharacterWrapperSq charac, int old, int newIndex){
        player.setCharacter(charac, old);
        if(player.equals(playerOne)){
            deployedCharacterOne = player.getCharacter(newIndex);
            P1CPos = newIndex;
        } else {
            deployedCharacterTwo = player.getCharacter(newIndex);
            P2CPos = newIndex;
        }
    }


//    public void updateCharacter(playerNum){
//
//    }


    private static boolean doesCounter(CharacterWrapperSq aggressor, CharacterWrapperSq target){
        String type1 = aggressor.getType();
        String type2 = aggressor.getType();

        if(type1.equals("Mage") && type2.equals("Fighter"))
            return true;
        if(type1.equals("Fighter") && type2.equals("Ranger"))
            return true;
        if(type1.equals("Ranger") && type2.equals("Mage"))
            return true;
        return false;
    }

    public String gameOver(){
        boolean statusTOne = allDead(playerOne);
        boolean statusTTwo = allDead(playerTwo);
        if(statusTOne && statusTTwo)
            return "Draw";
        if(statusTTwo)
            return "Player 2 Wins";
        if(statusTOne)
            return "Player 1 Wins";
        return "Ongoing";
    }

    private boolean allDead(Player player){
        int counter = 0;
        for(int i = 0; i<player.getSize();i++){
            if(player.getCharacter(i).getHealth() <= 0)
                counter++;
        }
        if(counter == 3)
            return true;
        return false;
    }

}