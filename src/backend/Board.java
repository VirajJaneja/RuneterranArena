package backend;

import java.lang.annotation.Target;

import org.omg.CORBA.ARG_IN;

import frontend.fightPanel;

public class Board {
    public static Player playerOne;
    public static CharacterWrapperSq deployedCharacterOne;
    public static CharacterWrapperSq deployedCharacterTwo;
    public static Player playerTwo;
    public static int P1CPos;
    public static int P2CPos;
    public static fightPanel fPane;
    public Object printPackage;

    public Board(Player playerUno, Player playerDos, fightPanel fp){
        fPane = fp;
        playerOne = playerUno;
        playerTwo = playerDos;
        deployedCharacterOne = playerOne.getCharacter(0);
        deployedCharacterTwo = playerTwo.getCharacter(0);
        P1CPos = 0;
        P2CPos = 0;
    }


    public static boolean makeMove(int i, Player aggressor, Player idlePlayer){
        int[] output = {0, 0, 0, 0};
        // System.out.println("CHARACS: AGGRESSOR: " + aggressor.getCurrentCharacter().getName() + " AND IDLE: " + idlePlayer.getCurrentCharacter().getName());
        // System.out.println(aggressor + " is dealing damage");
        // System.out.println("hp: " + idlePlayer.getCharacter(0).getHealth());
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
        // System.out.println(deployedCharacterOne.getName());
        // System.out.println("here");
        switch(i){
            case 0:
                aggressor.setSkillPoints(aggressor.getskillPoints()+1);
                // System.out.println(aggressor + " 's SKILLPOINTS ARE: " + aggressor.skillPoints);
                // System.out.println("adding one rn");
                dealDamage(target, (int)(calculateDamage(target, targetter, target.getAbility(i), output)));
                fPane.doAction(aggressor, i);
                if(!(target.getStatus())){
                    output[3] = 1;
                    if(!(allDead(idlePlayer))){
                        // System.out.println(target.getHealth());
                        // System.out.println(idlePlayer.getCharacter(0).getHealth() + "this right here officer");
                        fPane.killCharacter(idlePlayer, idlePlayer.getCharacter(getCharacPos(idlePlayer)), idlePlayer.getCharacter(getNextAlive(idlePlayer)));
                        swapCharacters(idlePlayer, target, getCharacPos(idlePlayer), getNextAlive(idlePlayer));
                        // System.out.println("uno: " + idlePlayer);
                        }   
                }
                break;
            case 1:
            //     System.out.println("taking 1 does " + aggressor.skillPoints);
            //     System.out.println("shouldnt be touching does " + idlePlayer.skillPoints);
            //     System.out.println("taking 1 from" + aggressor + "--------------------");
                // System.out.println("shouldnt be touching" + idlePlayer);
                aggressor.setSkillPoints(aggressor.getskillPoints()-1);
                // System.out.println("taking 1 does " + aggressor.skillPoints);
                // System.out.println("shouldnt be touching does " + idlePlayer.skillPoints);
                dealDamage(target, (int)(calculateDamage(target, targetter, target.getAbility(i), output)));
                fPane.doAction(aggressor, i);
                if(!(target.getStatus())){
                    output[3] = 1;
                    if(!(allDead(idlePlayer))){
                        // System.out.println(target.getHealth());
                        // System.out.println(idlePlayer.getCharacter(0).getHealth() + "this right here officer");
                        fPane.killCharacter(idlePlayer, idlePlayer.getCharacter(getCharacPos(idlePlayer)), idlePlayer.getCharacter(getNextAlive(idlePlayer)));
                        swapCharacters(idlePlayer, target, getCharacPos(idlePlayer), getNextAlive(idlePlayer));
                        // System.out.println("uno: " + idlePlayer);
                        }   
                }
                break;
            case 2:
                aggressor.setSkillPoints(aggressor.getskillPoints()-3);
                dealDamage(target, (int)(calculateDamage(target, targetter, target.getAbility(i), output)));
                fPane.doAction(aggressor, i);
                if(!(target.getStatus())){
                    output[3] = 1;
                    if(!(allDead(idlePlayer))){
                        // System.out.println(target.getHealth());
                        // System.out.println(idlePlayer.getCharacter(0).getHealth() + "this right here officer");
                        fPane.killCharacter(idlePlayer, idlePlayer.getCharacter(getCharacPos(idlePlayer)), idlePlayer.getCharacter(getNextAlive(idlePlayer)));
                        swapCharacters(idlePlayer, target, getCharacPos(idlePlayer), getNextAlive(idlePlayer));
                        // System.out.println("uno: " + idlePlayer);
                        }   
                }
                break;
            case 3:
            case 13:
            case 23:
            case 33:
            case 43:
                swapCharacters(aggressor, target, getCharacPos(aggressor), (i-3)/10);
                fPane.swapCharacter(aggressor, getCharacter(aggressor));
                // System.out.println("do smth");
                break;
        }
        // System.out.println(aggressor + " 's SKILLPOINTS ARE: " + aggressor.skillPoints);
        // System.out.println("this other one right here" + aggressor);
        // System.out.println("hp: " + idlePlayer.getCharacter(0).getHealth());
        // System.out.println(aggressor.skillPoints);
        // printPackage(aggressor, idlePlayer);
        for(int x: output)
            System.out.println(x);
        // fPane.updateField(getSentence(aggressor, idlePlayer, output));
        System.out.println((getSentence(aggressor, idlePlayer, output)));
        return false;
    }

    public static void dealDamage(CharacterWrapperSq target, int damage){
        damage = (int) damage;
        target.updateHealth(target.getHealth()-damage);
    }

    private static double calculateDamage(CharacterWrapperSq target, CharacterWrapperSq targetter, Ability a, int[] x){
        double baseDMG = a.minDmg;
        double result = baseDMG;
        if(Math.random()<=a.critChance){
            result += baseDMG*.5;
            x[2] = 1;
        }
        if(doesCounter(targetter, target))
            result += baseDMG*.25;
        if(Math.random()<a.missChance){
            result =0;
            x[1] = 1;
        }
        x[0] = (int)result;
        return result;
    }

    private static CharacterWrapperSq getCharacter(Player player){
        if(player.equals(playerOne)){
            return deployedCharacterOne;
        } else {
            return deployedCharacterTwo;
        }
    }

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

    private static boolean allDead(Player player){
        int counter = 0;
        for(int i = 0; i<player.getSize();i++){
            if(player.getCharacter(i).getHealth() <= 0)
                counter++;
        }
        if(counter >= player.getSize())
            return true;
        return false;
    }
    private static Integer getNextAlive(Player player){
        for(int i = 0;i<player.getSize();i++){
            if(player.getCharacter(i).getStatus())
                return i;
        }

        return -1;
    }
    public static void printPackage(Player aggressor, Player idle){
        System.out.println("-------------------------");
        System.out.println("aggressor: " + aggressor);
        for(int i = 0;i<aggressor.getSize();i++){
            Character c = aggressor.getCharacter(i);
            System.out.println(c + " is alive: " + c.getStatus() + " - hp is " + c.getHealth());
        }
        System.out.println();

        System.out.println("Idle: " + idle);
        for(int i = 0;i<aggressor.getSize();i++){
            Character c = idle.getCharacter(i);
            System.out.println(c + " is alive: " + c.getStatus() + " - hp is " + c.getHealth());
        }
        System.out.println("-------------------------");
    }

    private static String getSentence(Player aggressor, Player target, int[] x){
        // dmg, miss, crit, killed
        String result = "";
        result = aggressor.getName() + " " + aggressor.getCurrentCharacter().getName() + " dealt " + x[0] + " damage to " + target.getName() + " " + target.getCurrentCharacter().getName();

        if(x[1] == 1)
            result = aggressor.getName() + " " + aggressor.getCurrentCharacter().getName() + " missed their attack on " + target.getName() + " " + target.getCurrentCharacter().getName();
        if(x[2] == 1)
            result = aggressor.getName() + " " + aggressor.getCurrentCharacter().getName() + " crit for " + x[0] + " damage to " + target.getName() + " " + target.getCurrentCharacter().getName();


        if(x[3] == 1)
            result.concat(", killing it");
        return result;
    }


}