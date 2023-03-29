public class ComputerPlayer extends Player{
    public ComputerPlayer(String diff, boolean placement){
        super(diff, placement);
    }
    public int getChoice(){
        return (int)(Math.random()*4);
    }
}
