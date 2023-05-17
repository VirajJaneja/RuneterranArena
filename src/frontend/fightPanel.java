package frontend;

import javax.swing.*;

import backend.CharacterWrapperSq;
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
    private JLabel computerIMG;

    private ImageIcon playerCharacter;
    private ImageIcon computerCharacter;
    private GridLayout layout;
    public static Turnstile TS;

    public fightPanel(Turnstile turnstile) {
        layout = new GridLayout(0, 2, 0, 0);
        setLayout(layout);
        TS = turnstile;
        System.out.println("h: " + this.getWidth());

        playerIMG = new JLabel();
        playerIMG.setBorder(null);
        playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(TS.battlefield.deployedCharacterOne.getName(), "Idle")));

        computerIMG = new JLabel();
        computerIMG.setIcon(new javax.swing.ImageIcon(getPathRight(TS.battlefield.deployedCharacterTwo.getName(), "Idle")));
        computerIMG.setBorder(null);

        // computerIMG.repaint();
        add(playerIMG);
        add(computerIMG);
    }
    


    public static void swapCharacter(Player player, CharacterWrapperSq charac){
        // if(player)
        if(getSide(player).equals("left")){
            playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(charac.getName(), "Idle")));
        }
        if(getSide(player).equals("right")){
            playerIMG.setIcon(new javax.swing.ImageIcon(getPathRight(charac.getName(), "Idle")));
        }
    }
    


    public static void doAction(Player player, Integer i){
        String action = getActionFromI(i);
        System.out.println(action);
        if(getSide(player).equals("left")){
            ImageIcon x = new javax.swing.ImageIcon(getPathLeft(TS.battlefield.deployedCharacterOne.getName(),action));
            playerIMG.setIcon(new javax.swing.ImageIcon(getPathLeft(TS.battlefield.deployedCharacterOne.getName(), action)));
            System.out.println(action + " " + x);
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
    }

    private static String getSide(Player player){
        System.out.println(Turnstile.playerOne);
        System.out.println(player);
        if(player == Turnstile.playerOne)
            return "left";
        return "right";
    }

    private static ImageIcon flipGIF(ImageIcon ii){
        return ii;
    }

    private static String getPathLeft(String characName, String anim){
        String result = "";
        result = "lib/animations/" + characName + "/Player/" + characName + anim+".gif";
        System.out.println(result);
        return result;
    }
    
    private static String getPathRight(String characName, String anim){
        String result = "";
        result = "lib/animations/" + characName.toLowerCase() + "/Computer/" + characName + anim+"Comp.gif";
        System.out.println(result);
        System.out.println("lib/animations/Ahri/Computer/AhriIdleComp.gif");
        return result;
    }

    private static String getActionFromI(Integer i){
        switch(i){
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
    

}
