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
    Icon icons[] = new Icon[4];
    public static Boolean turn;
    private static String nextTurnValue;


    choicePanel() {
        turn = false;
        nextTurnValue = "";
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


    private void initButtons(){
        setupButton(basicATK, "Basic Attack");
        setupButton(abilityOne, "Ability 1");
        setupButton(ult, "Ultimate");
        setupButton(swapCharac, "Swap");
        // confirmButtonSetup();
    }

    private void setupButton(JButton b, String s){
        b.setFont(new Font("Serif", Font.BOLD, 30));
	    b.setBackground(new Color(29, 38, 44));
        b.setForeground(new Color(138, 158, 160));
        b.setBorder(BorderFactory.createTitledBorder(s));
	    b.setOpaque(true);
	    b.setActionCommand(s);
	    b.addActionListener(this);
        // b.setAlignmentX(CENTER_ALIGNMENT);
    }

    private void confirmButtonSetup(boolean turn){
        confirm.setFont(new Font("Serif", Font.BOLD, 30));
	    confirm.setBackground(new Color(79, 88, 94));
        confirm.setForeground(new Color(138, 158, 160));
        confirm.setOpaque(true);
        confirm.setActionCommand("");
	    if(turn){
            confirm.setActionCommand("confirm");
        }
        confirm.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eventName = e.getActionCommand();
        System.out.println(turn);
        nextTurnValue = eventName;
    }

    


}
