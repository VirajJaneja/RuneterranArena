package frontend;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.*;

import backend.Turnstile;
import backend.CharacterWrapperSq;

public class teamPanel extends JPanel{
    private Image backgroundImage;
    private ArrayList<ImageIcon> playerImageList = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> compImageList = new ArrayList<ImageIcon>();
    
    private ArrayList<JLabel> allLabel = new ArrayList<JLabel>();
    //private ArrayList<JLabel> compLabel = new ArrayList<JLabel>();

    private ArrayList<String> fractionList = new ArrayList<String>();
    private ArrayList<JLabel> hpList = new ArrayList<JLabel>();
    private ArrayList<CharacterWrapperSq> playerList = new ArrayList<CharacterWrapperSq>();
    private ArrayList<CharacterWrapperSq> compList = new ArrayList<CharacterWrapperSq>();
    public teamPanel(Turnstile ts) {
        // Load the background image
        int prefSize = 40;
        playerList = ts.getPlayer(true).getRoster();
        compList = ts.getPlayer(false).getRoster();

        backgroundImage = new ImageIcon("lib/league template 2.png").getImage();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //first row panel

        JPanel row1Panel = new JPanel();
        row1Panel.setLayout(new BoxLayout(row1Panel, BoxLayout.X_AXIS));

        //
        JPanel row2Panel = new JPanel();
        row2Panel.setLayout(new BoxLayout(row2Panel, BoxLayout.X_AXIS));

        for(int i= 0; i<playerList.size(); i++){
            //imageList.add(new javax.swing.ImageIcon("lib/icons/pfps/garen icon.png"));
            playerImageList.add(new ImageIcon(getImageIcon(playerList.get(i).getName())));
        }



        for(int i = 0; i<playerList.size(); i++){
            fractionList.add("("+getHealth(i) +" / "+ playerList.get(i).getMaxHealth()+")");
        }
        //     frac.setPreferredSize(new Dimension(prefSize, prefSize));
        //     row2Panel.add(frac, Box.createHorizontalGlue());
        // }
        // frac = new JLabel(new ImageIcon("lib/trans.png"));
        // frac.setPreferredSize(new Dimension(prefSize, prefSize));
        // row2Panel.add(frac, Box.createHorizontalGlue());

        for(int i = 0; i<compList.size(); i++){
            fractionList.add("("+getHealth(i) +" / "+ compList.get(i).getMaxHealth()+")");
        }
        
        
        JLabel temp;

        for(int i = 0; i<playerImageList.size(); i++){
            temp = new JLabel(playerImageList.get(i));
            temp.setPreferredSize(new Dimension(prefSize, prefSize));
            allLabel.add(temp);
            row1Panel.add(temp);
        }

        temp = new JLabel(new ImageIcon("lib/VsImage (1).png"));
        temp.setPreferredSize(new Dimension(prefSize, prefSize));
        row1Panel.add(temp);  



        //computer particulates LOL
        for(int i= 0; i<compList.size(); i++){
            //imageList.add(new javax.swing.ImageIcon("lib/icons/pfps/garen icon.png"));
            compImageList.add(new ImageIcon(getImageIcon(compList.get(i).getName())));
        }   

        for(int i = 0; i<compImageList.size(); i++){
            temp = new JLabel(compImageList.get(i));
            temp.setPreferredSize(new Dimension(prefSize, prefSize));
            allLabel.add(temp);
            row1Panel.add(temp);
        }


        for(int i = 0; i<playerImageList.size(); i++){
            temp = new JLabel(new ImageIcon("lib/trans"));
            temp.setPreferredSize(new Dimension(prefSize, prefSize));
            row2Panel.add(temp);
        }
        row2Panel.add(new JLabel(new ImageIcon("lib/trans.png")));

        for(int i = 0; i<compImageList.size(); i++){
            temp = new JLabel(new ImageIcon("lib/trans"));
            temp.setPreferredSize(new Dimension(prefSize, prefSize));
            row2Panel.add(temp);
        }

    add(row1Panel);
    add(row2Panel);
    repaint();
    }


    private String getImageIcon(String character){
        System.out.println("lib/icons/pfps/"+character.toLowerCase()+" icon.png");
        return "lib/icons/pfps/"+character.toLowerCase()+" icon.png";
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        // g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        java.awt.FontMetrics fontMetrics = g.getFontMetrics();

        for (int i = 0; i < allLabel.size(); i++) {
            JLabel label = allLabel.get(i);
            String fraction = fractionList.get(i);

            Rectangle labelBounds = label.getBounds();
            int labelX = labelBounds.x+25;
            int labelY = labelBounds.y + labelBounds.height + fontMetrics.getAscent();

            g.setColor(Color.WHITE);
            g.drawString(fraction, labelX, labelY);
        }
    }

    private int getHealth(int i){
        int health = playerList.get(i).getHealth();
        if(health < 0)
            health = 0;
        return health;
    }

}
