package frontend;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import backend.Turnstile;

public class choicePanel extends JPanel implements ActionListener{
    int height;
    int width;
    Turnstile TurnStile;
    JButton[] abilities = {};
    JButton basicATK;
    JButton abilityOne;
    JButton ult;
    JButton swapCharac;


    choicePanel() {
        basicATK = new JButton("Basic Attack");
        abilityOne = new JButton("Ability 1");
        ult = new JButton("Ability 2");
        swapCharac = new JButton("Swap Character");
        initButtons();
    }


    private void initButtons(){
        basicATK.setFont(new Font("Serif", Font.PLAIN, 30));
	    basicATK.setBackground(Color.red);
	    basicATK.setOpaque(true);
	    basicATK.setActionCommand("Easy");
	    basicATK.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eventName = e.getActionCommand();
    }

}
