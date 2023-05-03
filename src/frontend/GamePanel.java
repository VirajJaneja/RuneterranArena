package frontend;

import backend.Turnstile;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.*;

public class GamePanel extends JPanel {
    int height;
    int width;
    Turnstile TurnStile;
    public static choicePanel cPane;
    static teamPanel tPane;
    static fightPanel fPane;
    JButton settingsButton;


    public GamePanel(int h, int w, Turnstile baseTS) {
        TurnStile = baseTS;
        height = h;
        width = w;

        cPane = initCP();
        tPane = initTP();
        fPane = initFP();
        JButton settingsButton = new JButton("Settings");
        settingsButton.setActionCommand("Settings");
    }
    public GamePanel(Point p){
        height = p.y;
        width = p.x;
        System.out.println(width);

        cPane = new choicePanel();
        tPane = new teamPanel();
        fPane = new fightPanel();
        JButton settingsButton = new JButton("Settings");
        settingsButton.setActionCommand("Settings");
    }

    public static GamePanel initGP(GamePanel gp){
        int width = gp.width;
        int height = gp.height;

        int cpX = (int)(.30 * width);
        int cpY = (int)(.80 * height);
        int tpX = (int)(1 * width);
        int tpY = (int)(.05 * height);
        int fpX = (int)(.70 * width);
        int fpY = (int)(.80 * height);



        switch(height){
            case 520:
                int[] hwVals = {0, 0, 0, 0, 0, 0};
                break;
            case 880:
                int[] hwVals = {0, 0, 0, 0, 0, 0};
                break;
            case 1240:
                int[] hwVals = {0, 0, 0, 0, 0, 0};
                break;
            default:
                int[] hwVals = {0, 0, 0, 0, 0, 0};
                break;
        }
        // cpX, cpY, tpX, tpY, fpX, fpY



        System.out.println(height + " ooga booga");


        cPane.setPreferredSize(new Dimension(hwVals[0], hwVals[1]));
        tPane.setPreferredSize(new Dimension(hwVals[2], hwVals[3]));
        fPane.setPreferredSize(new Dimension(hwVals[4], hwVals[5]));



        GridBagConstraints gbc = new GridBagConstraints();

        gp.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridx = 0;  
        gbc.gridy = 0;  
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gp.add(tPane, gbc);
        gbc.gridx = 0;  
        gbc.gridy = 1;  
        gbc.gridwidth = 2;
        gbc.gridwidth = 1;
        gp.add(fPane, gbc);
        gbc.gridx = 2;  
        gbc.gridy = 1;  
        gp.add(cPane, gbc);

        return gp;
    }

    private choicePanel initCP(){
        choicePanel cPane = new choicePanel();
        return cPane;
    }

    private teamPanel initTP(){
        teamPanel tPane = new teamPanel();
        return tPane;
    }
    
    private fightPanel initFP(){
        fightPanel fPane = new fightPanel();
        return fPane;
    }


}
