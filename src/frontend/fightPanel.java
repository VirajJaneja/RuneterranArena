package frontend;
import java.awt.GridLayout;

import javax.swing.*;

public class fightPanel extends JPanel{
    private JLabel player;
    private JLabel computer;
    private GridLayout layout;

    public fightPanel(){
        layout = new GridLayout(0, 2, 0, 0);
        setLayout(layout);

        player = new JLabel();
        player.setIcon(new javax.swing.ImageIcon("lib/GarenGreenPlayer.gif"));

        computer = new JLabel();
        computer.setIcon(new javax.swing.ImageIcon("lib/GarenGreenComputer.gif"));
        add(player);
        add(computer);
    }

    public static void main(String[] args){
    }
}
