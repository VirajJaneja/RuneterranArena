package frontend;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;


public class teamPanel extends JPanel{
    private Image backgroundImage;

    public teamPanel() {
        // Load the background image
        backgroundImage = new ImageIcon("lib/c46ac69720c0e93e1aa9ca9182027cd7.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
