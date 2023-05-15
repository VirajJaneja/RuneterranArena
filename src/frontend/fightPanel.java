package frontend;
import javax.swing.*;

public class fightPanel extends JPanel{
    private JLabel player;
    private JLabel computer;

    public fightPanel(){

        player = new JLabel();
        player.setIcon(new javax.swing.ImageIcon("lib/GarenGreenPlayer.gif"));
        add(player);
    }

    public static void main(String[] args){
    }
}
