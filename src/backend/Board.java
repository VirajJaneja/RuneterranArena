package backend;

public class Board {
    public Player playerOne;
    public Player playerTwo;

    public Board(Player playerUno, Player playerDos){
        playerOne = playerUno;
        playerTwo = playerDos;

    }


    public boolean makeMove(int i, Player aggressor, Player idlePlayer){

        switch(i){
            case 0:
                dealDamage(idlePlayer, aggressor, aggressor.getCurrentCharacter().getAbility(0).maxDmg);
                return true;
            case 1:
                dealDamage(idlePlayer, aggressor, aggressor.getCurrentCharacter().getAbility(1).maxDmg);
                return true;
            case 2:
                dealDamage(idlePlayer, aggressor, aggressor.getCurrentCharacter().getAbility(2).maxDmg);
                return true;
            case 3:
                dealDamage(idlePlayer, aggressor, aggressor.getCurrentCharacter().getAbility(3).maxDmg);
                return true;
        }
        return false;
    }

    public void dealDamage(Player target, Player aggressor, int damage){
        if(doesCounter(aggressor.getCurrentCharacter(), target.getCurrentCharacter()))
            damage *= 1.5;
        damage = (int) damage;
        target.getCurrentCharacter().updateHealth(aggressor.getCurrentCharacter().getHealth()-damage);
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
        for(int i = 0; i<3;i++){
            if(player.getCharacter(i).getHealth() <= 0)
                counter++;
        }
        if(counter == 3)
            return true;
        return false;
    }


}