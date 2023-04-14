package frontend;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Point;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import backend.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainScreen implements ActionListener {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel contentPane;
    private JFrame Play;
    private JFrame settings;
    private JFrame modeSelect;
    private JFrame characterSelect;
    private ArrayList<JFrame> frameList = new ArrayList<JFrame>();
    private Point resolution;

    public MainScreen(Point p) {
        resolution = p;
        mainFrame = new JFrame("Menu");

        contentPane = new JPanel();
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, (int) resolution.getX(), (int) resolution.getY());
        // mainPanel.setLayout(null);
        int xMax = mainPanel.getWidth();
        int yMax = mainPanel.getHeight();
        System.out.println(xMax + ", " + yMax);

        JButton modes = new JButton("Mode");
        modes.setActionCommand("Mode");
        modes.setBounds(xMax / 2, yMax / 2, 100, 100);
        modes.addActionListener(this);
        mainPanel.add(modes);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setActionCommand("Settings");
        settingsButton.setBounds(xMax / 2, yMax / 2, 100, 100);
        settingsButton.addActionListener(this);
        mainPanel.add(settingsButton);
        contentPane.add(mainPanel);
        mainFrame.setContentPane(contentPane);
        mainFrame.setSize((int) resolution.getX(), (int) resolution.getY());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        mainFrame.setVisible(true);
    }

    public void setPane(JPanel pane){
        contentPane.removeAll();
        contentPane.add(pane);
    }
    public void alterRes(Point p) {
        new MainScreen(p);
    }


    public void actionPerformed(ActionEvent ae) {
        String act = ae.getActionCommand();
        if (act.equals("Mode")) {
            mainFrame.setVisible(false);
            new Mode();

        } else if (act.equals("Settings")) {
            mainFrame.setVisible(false);
            new Settings();
        }
    }

    public static void main(String args[]) {
        new MainScreen(new Point(1980, 1080));
    }

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
                System.out.println("Settings res1");
                setFrame(res1);
                System.out.println("resolution"+ resolution);
                alterRes(resolution);

            } else if (act.equals("res2")) {
                setFrame(res2);
                alterRes(resolution);
            }
            else if (act.equals("res3")) {
                setFrame(res3);
                alterRes(resolution);
            }
            
        }

    }

    class Mode extends JFrame implements ActionListener {
        private JFrame modeSelect;
        private JPanel modePanel;

        public Mode() {
            modeSelect = new JFrame();
            modePanel = new JPanel();
            JButton modeSel = new JButton("VS PLAYER");
            modeSel.setBounds(100, 200, 100, 100);
            JButton modeSel2 = new JButton("VS COMPUTER");
            modeSel.setBounds(100, 200, 100, 100);

            modeSel.setActionCommand("Player");
            modeSel2.setActionCommand("Computer");

            modePanel.add(modeSel);
            modePanel.add(modeSel2);

            modeSelect.add(modePanel);

            modeSelect.setSize((int)resolution.getX(), (int)resolution.getY());
            modeSelect.setVisible(true);

        }

        public void actionPerformed(ActionEvent ae) {
            String act = ae.getActionCommand();
            if (act.equals("Player")) {
                new CharacterSelect(true);
            } else {
                new CharacterSelect(false);
            }
        }
    }

    class CharacterSelect extends MainScreen {
        private JFrame characterSelectFrame;

        public CharacterSelect(boolean b) {
            super(resolution);

            if (b) {
                // vs player
            } else {
                // vs computer

            }

        }
    }
}
                                  