
public class Board {
    public Player playerOne;
    public Player playerTwo;

    public Character[] teamOne;
    public Character[] teamTwo;

    public Character deployedCharacOne;
    public Character deployedCharacTwo;

    public Board(Player playerUno, Player playerDos){
        playerOne = playerUno;
        playerTwo = playerDos;

    }

    public void dealDamage(Character target, int damage){

        deployedCharacOne.updateHealth(deployedCharacOne.getHealth()-damage);
    }

    public void swapCharacter(int playerNum, Character charac){
        if(playerNum==1){
            deployedCharacOne = charac;
        }
        if(playerNum==2){
            deployedCharacTwo = charac;
        }
    }

//    public void updateCharacter(playerNum){
//
//    }


    private boolean doesCounter(Character aggressor, Character target){
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
}

