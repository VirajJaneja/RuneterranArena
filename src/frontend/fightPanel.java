package frontend;

import javax.swing.*;

import backend.CharacterWrapperSq;
import backend.ComputerPlayer;
import backend.Player;
import backend.Turnstile;
import backend.Turnstile.Turn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class fightPanel extends JPanel {
    private static JLabel playerIMG;
    private static JLabel computerIMG;
    private JPanel animPane;
    private JScrollPane chatPane;
    private JTextArea textArea;
    private ImageIcon playerCharacter;
    private ImageIcon computerCharacter;
    private GridLayout layout;
    public static Turnstile TS;
    public gameFrame frame;
    public int height;
    public int width;
    private JTextArea chat;
    public fightPanel(Turnstile turnstile) {

        setLayout(new BorderLayout());
        chat = new JTextArea(10, getWidth());
        chat.setEditable(false);

        layout = new GridLayout(1, 2, 0, 0);

        animPane = new JPanel(layout);
        chatPane = new JScrollPane(chat);

        TS = turnstile;
        
        this.frame = TS.getGF();
        height = getHeight();
        width = getWidth();

        int prefSize = resize(sizeSML(width,height));

        playerIMG = new JLabel();
        playerIMG.setBorder(null);
        playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(TS.battlefield.deployedCharacterOne.getName(), "Idle")));
        computerIMG = new JLabel();
        computerIMG.setIcon(new javax.swing.ImageIcon(getPathRight(TS.battlefield.deployedCharacterTwo.getName(), "Idle")));
        computerIMG.setBorder(null);

        
        // computerIMG.repaint();
        // System.out.println(prefSize+", size");
        // playerIMG = reshapedLabel(computerIMG, prefSize);
        // computerIMG = reshapedLabel(computerIMG, prefSize);
        // System.out.println(playerIMG.getHeight() +"+"+playerIMG.getWidth());
        // System.out.println(computerIMG.getHeight() +"+"+playerIMG.getWidth());
     // Replace with the path to your image
        
        animPane.add(playerIMG);
        animPane.add(computerIMG);


        animPane.setVisible(true);
        add(animPane, BorderLayout.NORTH);

        chatPane.setVisible(true);
        
        add(chatPane, BorderLayout.CENTER);

    }
    
    public void updateField(String s){

        chat.append("   "+s);
        chatPane.repaint();
    }

    public String commentary(String charactername, String charactername2, String action){
       if(action.equals("swap")){
        return charactername + " has swapped in.";
       } else if(action.equals("atk")){
        return charactername + " attacks " + charactername2 + "!";
       } else if(action.equals("kill")){
        return charactername2 +" has fainted!";
       }
       return "";
    }
    

    public static void swapCharacter(Player player, CharacterWrapperSq charac){
        // if(player)
        // System.out.println("uno: " + player);
        // System.out.println(getSide(player));
        if(getSide(player).equals("left")){
            playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(charac.getName(), "Idle")));
        }
        if(getSide(player).equals("right")){
            computerIMG.setIcon(new javax.swing.ImageIcon(getPathRight(charac.getName(), "Idle")));
        }
    }
    
    public static void killCharacter(Player player, CharacterWrapperSq charac, CharacterWrapperSq nextCharac){
        // if(player)

        if(getSide(player).equals("left")){
            playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(charac.getName(), "Death")));
        }
        if(getSide(player).equals("right")){
            computerIMG.setIcon(new javax.swing.ImageIcon(getPathRight(charac.getName(), "Death")));
        }  

        Timer timer = new Timer(2100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                // System.out.println("got to event BINGO BINGO BINGO");
                // System.out.println(getSide(player));
                if(getSide(player).equals("left")){
                    playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(nextCharac.getName(), "Idle")));
                }
                if(getSide(player).equals("right")){
                    computerIMG.setIcon(new javax.swing.ImageIcon(getPathRight(nextCharac.getName(), "Idle")));
                }                
            }
        });
        timer.setRepeats(false); // Only fire once
        timer.start();

    }

    public static void doAction(Player player, Integer i){
        String action = getActionFromI(i);
        // System.out.println(action);
        if(getSide(player).equals("left")){
            // ImageIcon x = new javax.swing.ImageIcon(getPathLeft(TS.battlefield.deployedCharacterOne.getName(),action));
            playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(TS.battlefield.deployedCharacterOne.getName(), action)));
            // System.out.println(action + " " + x);
            Timer timer = new Timer(1200, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(TS.battlefield.deployedCharacterOne.getName(), "Idle")));
                    // drawImageOnIcon(new ImageIcon("lib/woodStart.png"), playerIMG.getIcon()));
                }
                
            });
            
            timer.setRepeats(false); // Only fire once
            timer.start();
            // playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(TS.battlefield.deployedCharacterOne.getName(), "idle")));

        } 
        if(getSide(player).equals("right")){
            // ImageIcon x = new javax.swing.ImageIcon(getPathRight(TS.battlefield.deployedCharacterOne.getName(),action));
            computerIMG.setIcon(new javax.swing.ImageIcon(getPathRight(TS.battlefield.deployedCharacterTwo.getName(), action)));
            // System.out.println(action + " " + x);
            Timer timer = new Timer(1200, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    computerIMG.setIcon(new javax.swing.ImageIcon(getPathRight(TS.battlefield.deployedCharacterTwo.getName(), "Idle")));
                    // drawImageOnIcon(new ImageIcon("lib/woodStart.png"), playerIMG.getIcon()));
                }
                
            });
            
            timer.setRepeats(false); // Only fire once
            timer.start();
            // playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(TS.battlefield.deployedCharacterOne.getName(), "idle")));

        } 
    }

    private static String getSide(Player player){
        // System.out.println(Turnstile.playerOne);
        // System.out.println(player);
        if(player == Turnstile.playerOne)
            return "left";
        return "right";
    }

    // private static ImageIcon flipGIF(ImageIcon ii){
    //     return ii;
    // }

    private static String getPathLeft(String characName, String anim){
        String result = "";
        result = "lib/animations/" + characName + "/Player/" + characName + anim+".gif";
        // System.out.println(result);
        return result;
    }
    
    private static String getPathRight(String characName, String anim){
        String result = "";
        result = "lib/animations/" + characName.toLowerCase() + "/Computer/" + characName + anim+"Comp.gif";
        // System.out.println(result);
        // System.out.println("lib/animations/Ahri/Computer/AhriIdleComp.gif");
        return result;
    }

    private static String getActionFromI(Integer i){
        switch(i){
            case -1:
                return "Death";
            case 0:
                return "ATK";
            case 1:
                return "Ability";
            case 2:
                return "Ult";
        }
        return "Idle";
    }

    public static void drawImageOnIcon(ImageIcon icon, Image image) {
        // Scale the image to fit the icon
        Image scaledImage = image.getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_SMOOTH);
    
        // Create a new image icon with the scaled image
        ImageIcon newIcon = new ImageIcon(scaledImage);
    
        // Set the new icon on the label
        icon.setImage(newIcon.getImage());
    }
    private int sizeSML(int x, int y){
        if(x <= 1000 ){
            return 0;
        } else if (x<=1800){
            return 1;
        }
        return 2;
    }
    private int resize(int x){
        if(x == 0){
            return 400;
        } else if (x ==1) {
            return 450;
        } else if (x==2){
            return 500;
        }
        return 100;
    }
    // public JLabel reshapedLabel(String name, int width, int height, boolean b) {
    //     name.
    //     label.setPreferredSize(new Dimension(width, height));
    //     return label;
    // }
    

    public JLabel reshapedLabel(JLabel label, int x){
        label.setPreferredSize(new Dimension(x, x));
        return label;
    }

}
