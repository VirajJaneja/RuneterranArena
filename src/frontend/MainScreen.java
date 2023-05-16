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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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
import javax.swing.BorderFactory;
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
    


    public MainScreen(Point p) {

        resolution = p;
        mainFrame = new JFrame("Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background image
        ImageIcon backgroundImage = new ImageIcon("lib/RuneterraArenaBG.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setSize((int) resolution.getX(), (int) resolution.getY());
        mainFrame.setContentPane(backgroundLabel);

        ImageIcon start = new ImageIcon("lib/woodStart.png");
        Image image = start.getImage();
        Image scaledImage = image.getScaledInstance(480, 360, java.awt.Image.SCALE_SMOOTH);
        
        ImageIcon buttonIcon = new ImageIcon(scaledImage);
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
            mainFrame.setVisible(false);
            new Mode();

        } else if (act.equals("Options")) {
            mainFrame.setVisible(false);
            new Settings();
        } else if (act.equals("Help")) {
            mainFrame.setVisible(false);
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
        private final Point res1 = new Point(1280-200, 720-200);
        private final Point res2 = new Point(1980-200, 1080-200);
        private final Point res3 = new Point(2560-200, 1440-200);

        public Settings() {
            settingsPanel = new JPanel();
            settingsFrame = new JFrame("Settings");
            //Create the panel that contains the "cards".
            JButton resolution1 = new JButton("1280 x 720");
            resolution1.setBounds(100, 200, 100, 100);
            JButton resolution2 = new JButton("1980 x 1080");
            resolution2.setBounds(100, 200, 100, 100);
            JButton resolution3 = new JButton("2560 x 1440");
            resolution3.setBounds(100, 200, 100, 100);

            resolution1.addActionListener(this);
            resolution2.addActionListener(this);
            resolution3.addActionListener(this);

            resolution1.setActionCommand("res1");
            resolution2.setActionCommand("res2");
            resolution3.setActionCommand("res3");

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
            if (act.equals("res1")) {
                setFrame(res1);
                alterRes(resolution);
                settingsFrame.setVisible(false);

            } else if (act.equals("res2")) {
                setFrame(res2);
                alterRes(resolution);
                settingsFrame.setVisible(false);
            }
            else if (act.equals("res3")) {
                setFrame(res3);
                alterRes(resolution);
                settingsFrame.setVisible(false);
            }
            
        }

    }

    class Mode extends JFrame implements ActionListener {
        private JFrame modeSelect;
        private JPanel modePanel;
        ImageIcon easy;
        ImageIcon medium;
        ImageIcon hard;
        Image newimg;
        Image image;
        ImageIcon backgroundImage;
        JLabel backgroundLabel;
        public Mode() {
            
            modeSelect = new JFrame();
            modePanel = new JPanel();

            // backgroundImage = new ImageIcon("lib/RiftBG.jpg");
            // backgroundLabel = new JLabel(backgroundImage);
            // backgroundLabel.setSize((int) resolution.getX(), (int) resolution.getY());
            // modeSelect.setContentPane(backgroundLabel);

            easy = new ImageIcon("lib/Easy.png");
            medium = new ImageIcon("lib/Medium.png");
            hard = new ImageIcon("lib/Hard.png");
            image = easy.getImage(); // transform it 
            newimg = image.getScaledInstance(215, 50,  java.awt.Image.SCALE_SMOOTH);
            image = medium.getImage(); // transform it 
            newimg = image.getScaledInstance(215, 50,  java.awt.Image.SCALE_SMOOTH);
            image = hard.getImage(); // transform it 
            newimg = image.getScaledInstance(215, 50,  java.awt.Image.SCALE_SMOOTH);

            JButton diffOne = new JButton(easy);
            JButton diffTwo = new JButton(medium);  
            JButton diffThree = new JButton(hard);
            diffOne.setBounds((int)resolution.getX()/3, (int)resolution.getY()/3, easy.getIconWidth(), easy.getIconHeight());
            diffTwo.setBounds((int)resolution.getX()/3, (int)resolution.getY()/3-50, medium.getIconWidth(), medium.getIconHeight());
            diffThree.setBounds((int)resolution.getX()/3-200, (int)resolution.getY()/3-100, hard.getIconWidth(), hard.getIconHeight());


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

            modePanel.add(menuBar);
            diffOne.addActionListener(this);
            diffOne.setActionCommand("EASY");
            
            modePanel.add(diffOne);   

            diffTwo.addActionListener(this);
            diffTwo.setActionCommand("MEDIUM");
            modePanel.add(diffTwo); 

            diffThree.addActionListener(this);
            diffThree.setActionCommand("HARD");
            modePanel.add(diffThree); 


            modePanel.setVisible(true);
            modeSelect.add(modePanel);
            modeSelect.setSize((int)resolution.getX(), (int)resolution.getY());
            modeSelect.setVisible(true);
            modeSelect.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }


        public void actionPerformed(ActionEvent ae) {
            String act = ae.getActionCommand();
            if(act.equals("EASY")){
                modeSelect.setVisible(false);
                new CharacterSelect(0, resolution);
            } else if(act.equals("MEDIUM")){
                new CharacterSelect(1, resolution);
            } else if(act.equals("HARD")){
                modeSelect.setVisible(false);
                new CharacterSelect(2, resolution);
            } else if(act.equals("Options")){
                modeSelect.setVisible(false);
                new Settings();
            }
        }
    }
}
                                  