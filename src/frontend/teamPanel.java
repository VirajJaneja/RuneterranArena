package frontend;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import backend.Turnstile;


public class teamPanel extends JPanel{
    private Image backgroundImage;

    
    public teamPanel(Turnstile ts) {
        // Load the background image
        backgroundImage = new ImageIcon("lib/league template 2.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
