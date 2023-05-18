package frontend;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;

import backend.Board;
import backend.ComputerPlayer;
import backend.Garen;
import backend.Jinx;
import backend.KhaZix;
import backend.Malzahar;
import backend.Ashe;
import backend.Ahri;
import backend.Player;
import backend.Taric;
import backend.Turnstile;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import backend.Character.*;

public class endingScreen extends JFrame implements ActionListener {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel contentPane;

    private Point resolution;
    private JMenuBar menuBar;

    private JMenu menu;
    private int difficulty;
    
    private ImageIcon backgroundImage, start, buttonIcon;
    private JLabel backgroundLabel;

    public endingScreen(Point p, String verdict) {
        System.out.println("Is it alive");
        backgroundImage = new ImageIcon("lib/VictorySRC");
        ImageIcon back = new ImageIcon("lib/Backbutton (1).png");

        resolution = p;
        int width = (int) p.getX();
        int height = (int) p.getY();
        
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setSize(width, height);
        if(verdict.equals("Player 1 Wins")){
            contentPane = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image backgroundImage = new ImageIcon("lib/VictorySRC (2).png").getImage();
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                }
            };   
        } else if (verdict.equals("Player 2 Wins")) {
            contentPane = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image backgroundImage = new ImageIcon("lib/RiftBG.jpg").getImage();
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                }
            };
        }

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(width, height));
        
        JLabel label = new JLabel("Game Statistics:");
        
        contentPane.add(label, BorderLayout.NORTH);
        JButton backButton = createMaskedButton(back);
        backButton.setSize(back.getIconWidth(), back.getIconWidth());
        backButton.setBorder(null);
        backButton.setOpaque(false);
        backButton.addActionListener(this);
        backButton.setActionCommand("back");
        contentPane.add(backButton, BorderLayout.SOUTH);
        setVisible(true);

    }


    private JButton createMaskedButton(ImageIcon icon) {
        // Create a buffered image to hold the button image
        BufferedImage buttonImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buttonImage.createGraphics();

        // Draw the button image onto the buffered image
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();

        // Create a new button with the masked image
        JButton maskedButton = new JButton(new ImageIcon(createMaskedImage(buttonImage)));
        maskedButton.setContentAreaFilled(false);
        maskedButton.setBorder(null);

        return maskedButton;
    }
    private BufferedImage createMaskedImage(BufferedImage image) {
        // Create a new buffered image with transparency
        BufferedImage maskedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = maskedImage.createGraphics();

        // Create a shape based on the image bounds
        Shape shape = new Rectangle2D.Float(0, 0, image.getWidth(), image.getHeight());

        // Create an area with the shape
        Area area = new Area(shape);

        // Set the shape as the clip for the graphics object
        g2d.setClip(area);

        // Draw the original image onto the masked image, using the clip to mask it
        g2d.drawImage(image, 0, 0, null);

        g2d.dispose();

        return maskedImage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();
        if(act.equals("back")){
            setVisible(false);
            new MainScreen(resolution);
        }
    }
    public static void main(String[] args) {
        new endingScreen(new Point(1000,800), "Player 1 Wins");
    }

    
}
