package frontend;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.MenuBar;
import java.awt.Point;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import backend.Player;
import backend.Turnstile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class gameFrame implements ActionListener {
    public JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel backupPane;
    private Point resolution;
    JPanel contentPane;
    GamePanel gp;
    JMenuBar menuBar;
    Turnstile turnstile;


    public gameFrame(Point p, Turnstile turnstile2) {
        turnstile = turnstile2;
        contentPane = new JPanel();
        resolution = p;
        menuBar = new JMenuBar();
        mainFrame = new JFrame("Runeterran Arena");
        gp = new GamePanel(p, turnstile);
        gp.setBounds(0, 0, (int) resolution.getX(), (int) resolution.getY());
        // mainPanel.setLayout(null);
        int xMax = gp.getWidth();
        int yMax = gp.getHeight();
        System.out.println(xMax + ", " + yMax);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setActionCommand("Settings");
        settingsButton.setBounds(xMax / 2, yMax / 2, 100, 100);
        settingsButton.addActionListener(this);
        // contentPane.setPane
        GamePanel.initGP(gp);
        mainFrame.setContentPane(contentPane);
        contentPane.add(gp);
        menuBar.add(settingsButton);
        mainFrame.setSize((int) resolution.getX(), (int) resolution.getY());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainFrame.setJMenuBar(menuBar);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }
    public void alterRes(Point p) {
        new gameFrame(p, turnstile);
    }


    public void actionPerformed(ActionEvent ae) {
        String act = ae.getActionCommand();
        if (act.equals("Settings")) {
            mainFrame.setVisible(false);
            new Settings();
        }
    }

    public void setPane(JPanel pane){
        contentPane.removeAll();
        contentPane.add(pane);
    }

    // public void disposeGF(){
    //     dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

    // }

    class Settings extends JFrame implements ActionListener {
        private JPanel settingsPanel;
        private JFrame settingsFrame;
        private final Point res1 = new Point(1280-200, 720-100);
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
        }


        public void setFrame(Point p) {
            resolution = p;
        }


        public void actionPerformed(ActionEvent e) {
            String act = e.getActionCommand();
            if (act.equals("res1")) {
                System.out.println("Settings res1");
                setFrame(res1);
                System.out.println("resolution"+ resolution);
                alterRes(resolution);
                settingsFrame.dispose();

            } else if (act.equals("res2")) {
                setFrame(res2);
                alterRes(resolution);
                settingsFrame.dispose();
            }
            else if (act.equals("res3")) {
                setFrame(res3);
                alterRes(resolution);
                settingsFrame.dispose();
            }
            
        }

    }
}
                                  