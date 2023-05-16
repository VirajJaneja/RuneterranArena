package frontend;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    ArrayList<JButton> teamButtons;
    // public static Boolean turn;
    // private static String nextTurnValue;


    choicePanel(Turnstile turnstile2, Player Givenplayer) {
        teamButtons = new ArrayList<>();
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
        for(JButton b: teamButtons){
            b.setBackground(new Color(255, 255, 255));
        }
    }

    private void initButtons(){
        for(int i = 0; i<player.getSize();i++){
            teamButtons.add(new JButton(player.getCharacter(i).getName()));
            setupButton(teamButtons.get(i), player.getCharacter(i).getName());
        }
        setupButton(basicATK, "Basic Attack");
        setupButton(abilityOne, "Ability 1");
        setupButton(ult, "Ultimate");
        setupButton(swapCharac, "swap");
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

    public void addSwapButtons(choicePanel cp){
        for(int i = 0; i<player.getSize();i++){
            teamButtons.get(i).setActionCommand((i*10)+3+"");
            cp.add(teamButtons.get(i));
        }
        swapRotate("cancel");
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

    public void swapRotate(String swap){
        if(swap.equals("swap")){
            basicATK.setVisible(false);
            abilityOne.setVisible(false);
            ult.setVisible(false);
            swapCharac.setActionCommand("cancel");
            for(JButton b: teamButtons){
                b.setVisible(true);
            }
        }
        if(swap.equals("cancel")){
            basicATK.setVisible(true);
            abilityOne.setVisible(true);
            ult.setVisible(true);
            swapCharac.setActionCommand("swap");
            for(JButton b: teamButtons){
                b.setVisible(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eventName = e.getActionCommand();
        System.out.println(eventName);
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
            case "cancel":
                swapRotate(eventName);
                break;
            case "swap":
                swapRotate(eventName);
                break;
            case "Confirm":
                resetButtons();
                Turnstile.moveTurn();
                break;
            case "3":
            case "13":
            case "23":
            case "33":
            case "43":
                player.setNextTurn(Integer.parseInt(eventName));
                resetButtons();
                teamButtons.get((Integer.parseInt(eventName)-3)/10).setBackground(new Color(29,67,71));
                break; 
        }
        // System.out.println(TurnStile.playerOne.nextTurn);
    }
}
