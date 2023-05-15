package frontend;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import backend.Player;
import backend.Turnstile;

public class choicePanel extends JPanel implements ActionListener{
    // int height;
    // int width;
    Turnstile TurnStile;
    JButton[] abilities = {};
    static JButton basicATK;
    static JButton abilityOne;
    static JButton ult;
    static JButton swapCharac;
    static JButton confirm;
    Player player;
    Icon icons[] = new Icon[4];
    // public static Boolean turn;
    // private static String nextTurnValue;


    choicePanel(Turnstile turnstile2, Player Givenplayer) {
        TurnStile = turnstile2;
        player = Givenplayer;
        // turn = false;
        // nextTurnValue = "";
        icons[0] = new ImageIcon("E:/lib/Demacian_Justice.png");
        icons[1] = new ImageIcon("lib/Demacian_Justice.png");
        icons[2] = new ImageIcon("lib/Demacian_Justice.png");
        icons[3] = new ImageIcon("lib/Demacian_Justice.png");
        basicATK = new JButton("Basic Attack");
        abilityOne = new JButton("Ability 1");
        ult = new JButton("Ultimate");
        swapCharac = new JButton("Swap Character");
        confirm = new JButton("Confirm");
        initButtons();
    }

    private void resetButtons(){
        basicATK.setBackground(new Color(255, 255, 255));
	    abilityOne.setBackground(new Color(255, 255, 255));
	    ult.setBackground(new Color(255, 255, 255));
	    swapCharac.setBackground(new Color(255, 255, 255));
    }

    private void initButtons(){
        setupButton(basicATK, "Basic Attack");
        setupButton(abilityOne, "Ability 1");
        setupButton(ult, "Ultimate");
        setupButton(swapCharac, "Swap");
        setupButton(confirm, "None");
        setConfirmButtonPresence(1);
    }

    private void setupButton(JButton b, String s){
        b.setFont(new Font("Serif", Font.BOLD, 30));
	    b.setBackground(new Color(255, 255, 255));
        b.setForeground(new Color(138, 158, 160));
        b.setBorder(BorderFactory.createTitledBorder(s));
	    b.setOpaque(true);
	    b.setActionCommand(s);
	    b.addActionListener(this);
        // b.setAlignmentX(CENTER_ALIGNMENT);
    }

    public void setConfirmButtonPresence(Integer i) {
        confirm.setFont(new Font("Serif", Font.BOLD, 30));
        if(i == 1){
            // confirm.setBackground(new Color(79, 88, 94));
            confirm.setActionCommand("Confirm");
            confirm.setBackground(new Color(255, 255, 255));
            confirm.setVisible(true);
        } if(i == 0){
            confirm.setActionCommand("None");
            // confirm.setBackground(new Color(79, 88, 94));
            confirm.setForeground(new Color(138, 158, 160));
            confirm.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eventName = e.getActionCommand();
        // System.out.println(eventName);
        // nextTurnValue = eventName;
        switch(eventName){
            case "Basic Attack":
                player.setNextTurn(0);
                resetButtons();
                basicATK.setBackground(new Color(29,67,71));
                break;
            case "Ability 1":
                player.setNextTurn(1);
                resetButtons();
                abilityOne.setBackground(new Color(29,67,71));
                break;
            case "Ultimate":
                player.setNextTurn(2);
                resetButtons();
                ult.setBackground(new Color(29,67,71));
                break;
            case "Swap":
                player.setNextTurn(3);
                resetButtons();
                swapCharac.setBackground(new Color(29,67,71));
                break;
            case "Confirm":
                Turnstile.moveTurn();
                break;
        }
        System.out.println(TurnStile.playerOne.nextTurn);
    }
}
