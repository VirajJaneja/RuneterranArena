package frontend;

import backend.Turnstile;
import backend.Turnstile.Turn;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.*;

public class GamePanel extends JPanel {
    int height;
    int width;
    Turnstile TurnStile;
    public static choicePanel cPane;
    public static teamPanel tPane;
    public static fightPanel fPane;
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
    public GamePanel(Point p, Turnstile turnstile){
        height = p.y;
        width = p.x;
        // System.out.println(width);
        TurnStile = turnstile;
        cPane = initCP();
        tPane = initTP();
        fPane = initFP();
        JButton settingsButton = new JButton("Settings");
        settingsButton.setActionCommand("Settings");
        // System.out.println(cPane.getWidth() + " here");
        // if(height == 1080)
        //     System.out.println(cPane.getResponse());;
    }

    public GamePanel(Point p){
        height = p.y;
        width = p.x;
        // System.out.println(width);

        cPane = initCP();
        tPane = initTP();
        fPane = initFP();
        JButton settingsButton = new JButton("Settings");
        settingsButton.setActionCommand("Settings");
        // System.out.println(cPane.getWidth() + " here");
        // if(height == 1080)
        //     System.out.println(cPane.getResponse());;
    }

    public static GamePanel initGP(GamePanel gp){
        int width = gp.width;
        int height = gp.height;


        int cpX = (int)(.30 * width);
        int cpY = (int)(.85 * height);
        int tpX = (int)(1 * width);
        int tpY = (int)(.15 * height);
        int fpX = (int)(.70 * width);
        int fpY = (int)(.85 * height);




        cPane.setPreferredSize(new Dimension(cpX, cpY));
        tPane.setPreferredSize(new Dimension(tpX, tpY));
        fPane.setPreferredSize(new Dimension(fpX, fpY));

        cPane.setBackground(new Color(221, 232, 96));
        tPane.setBackground(new Color(06, 18, 23));
        fPane.setBackground(new Color(191, 191, 191));


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
        choicePanel cPane = new choicePanel(TurnStile, TurnStile.playerOne);
        cPane.addSwapButtons(cPane);
        cPane.setLayout(new BoxLayout(cPane, BoxLayout.Y_AXIS));
        int spacing = 35; // Adjust the spacing as desired
        // setBorder(BorderFactory.createEmptyBorder(spacing, 0, 0, 0));
        cPane.add(Box.createVerticalStrut(spacing));
        cPane.add(cPane.basicATK);
        cPane.add(cPane.abilityOne);
        cPane.add(cPane.ult);
        cPane.add(cPane.swapCharac);
        cPane.add(cPane.confirm);
        cPane.add(cPane.skillPointsLabel);
        cPane.add(cPane.warningLabel);
        
        return cPane;
    }

    private teamPanel initTP(){
        teamPanel tPane = new teamPanel(TurnStile);
        return tPane;
    }
    
    private fightPanel initFP(){
        fightPanel fPane = new fightPanel(TurnStile);
        fPane.setBackground(new Color(191, 191, 191));
        return fPane;
    }
    
}
