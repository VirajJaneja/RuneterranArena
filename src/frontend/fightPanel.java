package frontend;

import javax.swing.*;

import backend.CharacterWrapperSq;
import backend.Player;
import backend.Turnstile;
import backend.Turnstile.Turn;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class fightPanel extends JPanel {
    private static JLabel playerIMG;
    private JLabel computerIMG;

    private ImageIcon playerCharacter;
    private ImageIcon computerCharacter;
    private GridLayout layout;
    Turnstile TS;

    public fightPanel(Turnstile turnstile) {
        layout = new GridLayout(0, 2, 0, 0);
        setLayout(layout);
        TS = turnstile;

        playerIMG = new JLabel("hello");
        playerIMG.setIcon(new javax.swing.ImageIcon(getPath(TS.battlefield.deployedCharacterOne.getName(), "Idle")));

        computerIMG = new JLabel();
        computerIMG.setIcon(flipVertically(new javax.swing.ImageIcon(getPath(TS.battlefield.deployedCharacterTwo.getName(), "Idle"))));
        computerIMG.repaint();
        add(playerIMG);
        add(computerIMG);

        

    }
    


    public static void swapCharacter(Player player, CharacterWrapperSq charac){
        // if(player)
        if(getSide(player).equals("left")){
            
            playerIMG.setIcon(new javax.swing.ImageIcon(getPath(charac.getName(), "Idle")));
        }
    }

    public static void doAction(Player player){
        if(getSide(player).equals("left")){
            
        } 
    }

    private static String getSide(Player player){
        if(player.equals(Turnstile.playerOne))
            return "left";
        return "right";
    }

    private static ImageIcon flipGIF(ImageIcon ii){
        return ii;
    }

    private static String getPath(String characName, String anim){
        String result = "";
        result = "lib/animations/" + characName.toLowerCase() + "/" + characName + anim+".gif";
        return result;
    }
    
    public static ImageIcon flipVertically(ImageIcon icon) {
        int width = icon.getIconWidth();
        int height = icon.getIconHeight();
    
        // Create a BufferedImage to hold the flipped image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    
        // Get the graphics context of the image
        Graphics2D g2d = image.createGraphics();
    
        // Flip the image vertically using an AffineTransform object
        AffineTransform transform = AffineTransform.getScaleInstance(1, -1);
        transform.translate(0, -height);
        g2d.drawImage(icon.getImage(), transform, null);
        g2d.dispose();
    
        // Create a new ImageIcon from the flipped image
        return new ImageIcon(image);
    }
    

}
