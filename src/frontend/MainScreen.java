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
import javax.swing.RootPaneContainer;

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

public class MainScreen implements ActionListener {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel contentPane;

    private Point resolution;
    private JMenuBar menuBar;

    private JMenu menu;
    private int difficulty;
    
    private ImageIcon backgroundImage, start, buttonIcon;
    private JLabel backgroundLabel;
    private Clip clip;

    public MainScreen(Point p) {

        resolution = p;
        mainFrame = new JFrame("Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background image
        backgroundImage = new ImageIcon("lib/RuneterraArenaBG.png");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setSize((int) resolution.getX(), (int) resolution.getY());
        mainFrame.setContentPane(backgroundLabel);

        start = new ImageIcon("lib/woodStart.png");
        Image image = start.getImage();
        Image scaledImage = image.getScaledInstance(480, 360, java.awt.Image.SCALE_SMOOTH);
        
        buttonIcon = new ImageIcon(scaledImage);
        JButton centerButton = new JButton(buttonIcon);
        centerButton.addActionListener(this);
        centerButton.setActionCommand("click");
        
        Dimension buttonSize = new Dimension(scaledImage.getWidth(null), scaledImage.getHeight(null));
        centerButton.setBorder(null); // Remove border
        centerButton.setContentAreaFilled(false); // Ensure full image display

        centerButton.setPreferredSize(buttonSize);
        centerButton.setMinimumSize(buttonSize);
        centerButton.setMaximumSize(buttonSize);
        centerButton.setSize(buttonSize);
        
        centerButton.setBounds((int) resolution.getX() / 2 - buttonSize.width / 2, (int) resolution.getY() / 2 - buttonSize.height / 2, buttonSize.width-10, buttonSize.height-10);
        mainFrame.add(centerButton);
        

        menuBar = new JMenuBar();
        menu = new JMenu("Settings");
        JMenuItem optionsMenuItem = new JMenuItem("Options");
        JMenuItem helpMenuItem = new JMenuItem("Help");
        optionsMenuItem.addActionListener(this);
        optionsMenuItem.setActionCommand("Options");
        helpMenuItem.addActionListener(this);
        helpMenuItem.setActionCommand("Help");
        menu.add(optionsMenuItem);
        menu.add(helpMenuItem);
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);

        int xval = (int) p.getX();
        int yval = (int) p.getY();
        mainFrame.setSize(xval, yval);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        playIdle(true);

    }
    private void playIdle(boolean b){
        String sound = "";

        if(b){
            sound = "lib/SRidle.wav";
        } else{
            sound = "lib/Queue.wav";
        }

        try {
            File soundFile = new File(sound);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Play the sound
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
        
    }
    private void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
    

    private void playSound(String s){
        String sound = "lib/button SE.wav";
        if(s.equals("Confirm") || s.equals("None"))
            sound = "lib/Button 2 SE.wav";
        else if(s.equals("Select"))
            sound = "lib/selectHard.wav";
        try {
            File soundFile = new File(sound);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Play the sound
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public void setPane(JPanel pane){
        contentPane.removeAll();
        contentPane.add(pane);
        mainFrame.setContentPane(pane);
    }

    public void alterRes(Point p) {
        new MainScreen(p);
    }

    public void actionPerformed(ActionEvent ae) {
        String act = ae.getActionCommand();
        if (act.equals("click")) {
            playSound("confirm");
            mainFrame.setVisible(false);
            new Mode();

        } else if (act.equals("Options")) {
            playSound("confirm");
            //mainFrame.setVisible(false);
            new Settings();
        } else if (act.equals("Help")) {
            
            //mainFrame.setVisible(false);
            System.out.println("Help frq here!");
        }
    }

    public static void main(String args[]) {
        
        new MainScreen(new Point(900, 900));
    }

    //

    class Settings extends JFrame implements ActionListener {
        private JPanel settingsPanel;
        private JFrame settingsFrame;
        // private final Point res1 = new Point(1000, 520);
        // private final Point res2 = new Point(1980-200, 1080-200);
        // private final Point res3 = new Point(2560-200, 1440-200);

        public Settings() {
            settingsPanel = new JPanel();
            settingsFrame = new JFrame("Settings");
            //Create the panel that contains the "cards".
            JButton resolution1 = new JButton("Lower Volume");
            resolution1.setBounds(100, 200, 100, 100);
            JButton resolution2 = new JButton("Increase Volume");
            resolution2.setBounds(100, 200, 100, 100);
            JButton resolution3 = new JButton("Mute");
            resolution3.setBounds(100, 200, 100, 100);

            resolution1.addActionListener(this);    
            resolution2.addActionListener(this);
            resolution3.addActionListener(this);

            resolution1.setActionCommand("low");
            resolution2.setActionCommand("high");
            resolution3.setActionCommand("mute");

            settingsPanel.add(resolution1);
            settingsPanel.add(resolution2);
            settingsPanel.add(resolution3);

            settingsFrame.setSize(300, 300);
            settingsFrame.add(settingsPanel);
            settingsFrame.setVisible(true);
            settingsFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }


        public void setFrame(Point p) {
            resolution = p;
        }


        public void actionPerformed(ActionEvent e) {
            String act = e.getActionCommand();
            if (act.equals("lower")) {
                playSound("confirm");
                
                settingsFrame.setVisible(false);

            } else if (act.equals("higher")) {
                playSound("confirm");

                
                settingsFrame.setVisible(false);
            }
            else if (act.equals("mute")) {
                playSound("confirm");

                stopSound();
                settingsFrame.setVisible(false);
            }
            
        }

    }

class Mode extends JFrame implements ActionListener {
    private JFrame modeSelect;
    private JPanel modePanel;
    ImageIcon easy, medium, hard, back;
    Image newimg;
    Image image;
    ImageIcon backgroundImage;
    JLabel backgroundLabel;
    BoxLayout layout;

    public Mode() {
        modePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw background image
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        layout = new BoxLayout(modePanel, BoxLayout.Y_AXIS);
        modePanel.setLayout(layout);

        // Load background image
        backgroundImage = new ImageIcon("lib/RiftBG.jpg");

        easy = new ImageIcon("lib/Easy.png");
        medium = new ImageIcon("lib/Medium.png");
        hard = new ImageIcon("lib/Hard.png");
        back = new ImageIcon("lib/Backbutton (1).png");

        JButton diffOne = new JButton(easy);
        diffOne.setSize(easy.getIconWidth(), easy.getIconHeight());
        diffOne.setBorder(null);
        diffOne.addActionListener(this);
        diffOne.setActionCommand("EASY");
        modePanel.add(diffOne);

        JButton diffTwo = new JButton(medium);
        diffTwo.setSize(medium.getIconWidth(), medium.getIconWidth());
        diffTwo.setBorder(null);
        diffTwo.addActionListener(this);
        diffTwo.setActionCommand("MEDIUM");
        modePanel.add(diffTwo);

        JButton diffThree = new JButton(hard);
        diffThree.setSize(hard.getIconWidth(), hard.getIconWidth());
        diffThree.setBorder(null);
        diffThree.addActionListener(this);
        diffThree.setActionCommand("HARD");
        modePanel.add(diffThree);

        // Create a masked back button
        JButton backButton = createMaskedButton(back);
        backButton.setSize(back.getIconWidth(), back.getIconWidth());
        backButton.setBorder(null);
        backButton.setOpaque(false);
        backButton.addActionListener(this);
        backButton.setActionCommand("back");
        modePanel.add(backButton);

        add(modePanel);
        pack();
        setVisible(true);
        
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        setSize(bounds.width, getHeight());
        
        // Set the frame location to the top-left corner
        setLocation(bounds.x, bounds.y);
        

        
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
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

        public void actionPerformed(ActionEvent ae) {
            String act = ae.getActionCommand();
            stopSound();
            if(act.equals("EASY")){
                playSound("Select");
                System.out.println("easy");
                setVisible(false);
                new CharacterSelect(0, resolution);
            } else if(act.equals("MEDIUM")){
                playSound("Select");
                setVisible(false);
                new CharacterSelect(1, resolution);
                System.out.println("med");
            } else if(act.equals("HARD")){
                playSound("Select");

                setVisible(false);
                new CharacterSelect(2, resolution);
                System.out.println("hard");
            } else if(act.equals("Options")){
                setVisible(false);
                new Settings();
                
            } else if(act.equals("back")){
                setVisible(false);
                new MainScreen(new Point(900, 900));
                
            }
        }
    }
}
                                  