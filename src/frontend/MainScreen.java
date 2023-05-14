package frontend;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import backend.Player;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainScreen implements ActionListener {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel contentPane;

    private Point resolution;
    private JMenuBar menuBar;

    private JMenu menu;

    public MainScreen(Point p) {
            
        resolution = p;
        mainFrame = new JFrame("Menu");
        contentPane = new JPanel();
        mainPanel = new JPanel();
        menuBar = new JMenuBar(); 
        menu = new JMenu("Settings");

        mainPanel.setBounds(0, 0, (int) resolution.getX(), (int) resolution.getY());
        // mainPanel.setLayout(null);
        int xMax = mainPanel.getWidth();
        int yMax = mainPanel.getHeight();
        System.out.println(xMax + ", " + yMax);
        
  
        // create menuitems
        JMenuItem m1 = new JMenuItem("Options");
        m1.addActionListener(this);
        m1.setActionCommand("Options");
        JMenuItem m2 = new JMenuItem("Help");
        m2.addActionListener(this);
        m2.setActionCommand("Help");

        menu.add(m1);
        menu.add(m2);
        menu.setBounds(100, 100, xMax, yMax);
        menuBar.add(menu);
  
        JButton modes = new JButton("Mode");
        modes.setActionCommand("Mode");
        modes.setBounds(xMax / 2, yMax / 2, 100, 100);
        modes.addActionListener(this);
        mainPanel.add(modes);

        mainPanel.add(menuBar);
        contentPane.add(mainPanel);

        mainFrame.setContentPane(contentPane);
        mainFrame.setSize((int) resolution.getX(), (int) resolution.getY());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



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
        if (act.equals("Mode")) {
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
        new MainScreen(new Point(1980, 1080));
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

        public Mode() {
            
            modeSelect = new JFrame();
            modePanel = new JPanel();

            JButton modeSel2 = new JButton("VS COMPUTER");

            JMenuBar menuBar = new JMenuBar();
            JMenu menus= new JMenu("Settings");
            JMenuItem m1 = new JMenuItem("Options");
            m1.addActionListener(this);
            m1.setActionCommand("Options");
            JMenuItem m2 = new JMenuItem("Help");
            m2.addActionListener(this);
            m2.setActionCommand("Help");

            menus.add(m1);
            menus.add(m2);
            menuBar.add(menus);

            modeSel2.addActionListener(this);
            modeSel2.setActionCommand("Computer");
            modePanel.add(modeSel2);   
            modePanel.add(menuBar);

            modePanel.setVisible(true);
            modeSelect.add(modePanel);
            modeSelect.setSize((int)resolution.getX(), (int)resolution.getY());
            modeSelect.setVisible(true);
        }

        public void actionPerformed(ActionEvent ae) {
            String act = ae.getActionCommand();
            System.out.println(ae);
            if (act.equals("Computer")) {
                modeSelect.setVisible(false);
                new DifficultySelect();
            } else if(act.equals("Options")){
                modeSelect.setVisible(false);
                new Settings();
            }
        }
    }
    class DifficultySelect extends JFrame implements ActionListener {
        private JFrame diffFrame;
        private JPanel diffPanel;

        public DifficultySelect(){
            diffFrame = new JFrame();
            diffPanel = new JPanel();

            JButton diffOne = new JButton("EASY");
            JButton diffTwo = new JButton("MEDIUM");
            JButton diffThree = new JButton("HARD");

            JMenuBar menuBar = new JMenuBar();
            JMenu menus= new JMenu("Settings");
            JMenuItem m1 = new JMenuItem("Options");
            m1.addActionListener(this);
            m1.setActionCommand("Options");
            JMenuItem m2 = new JMenuItem("Help");
            m2.addActionListener(this);
            m2.setActionCommand("Help");

            menus.add(m1);
            menus.add(m2);
            menuBar.add(menus);

            diffOne.addActionListener(this);
            diffOne.setActionCommand("EASY");
            diffPanel.add(diffOne);   

            diffTwo.addActionListener(this);
            diffTwo.setActionCommand("MEDIUM");
            diffPanel.add(diffTwo); 

            diffThree.addActionListener(this);
            diffThree.setActionCommand("HARD");
            diffPanel.add(diffThree); 


            diffPanel.add(menuBar);

            diffPanel.setVisible(true);
            diffFrame.add(diffPanel);
            diffFrame.setSize((int)resolution.getX(), (int)resolution.getY());
            diffFrame.setVisible(true);

        }



        public void actionPerformed(ActionEvent e) {
            String act = e.getActionCommand();
            if(act.equals("EASY")){
                diffFrame.setVisible(false);
                new CharacterSelect(0);
            } else if(act.equals("MEDIUM")){
                new CharacterSelect(1);
            } else if(act.equals("HARD")){
                diffFrame.setVisible(false);
                new CharacterSelect(2);
            } else if(act.equals("Options")){
                diffFrame.setVisible(false);
                new Settings();
            }
        }
    }
    class CharacterSelect extends JFrame implements ActionListener {
        private JFrame characterFrame;
        private JPanel characterPanel;
        private choicePanel select;
        private JPanel characterVsCompPanel;
        private ArrayList<JButton> characters = new ArrayList<JButton>();
        private ArrayList<Image> characterImages = new ArrayList<Image>();

        public CharacterSelect(int i) {
            characters.add(new JButton("Garen"));
            characters.add(new JButton("Ashe"));
            characters.add(new JButton("Ahri"));

            System.out.println(i);
            // vs computer
            characterFrame = new JFrame("Character Select");
            characterVsCompPanel = new JPanel();

                JPanel charaOne = new JPanel();
                charaOne.setSize((int)(resolution.getX()/3), (int)resolution.getY());
                charaOne.setLocation(0, 0);

                JPanel charaTwo = new JPanel();
                charaTwo.setSize((int)(resolution.getX()/3), (int)(resolution.getY()));
                charaTwo.setLocation((int)(resolution.getX()*(1/3)), 0);

                JPanel charaThree = new JPanel();
                charaThree.setSize((int)(resolution.getX()/3), (int)(resolution.getY()));
                charaThree.setLocation(((int)resolution.getX()*(2/3)), 0);
;               
                characterVsCompPanel.add(charaOne);
                characterVsCompPanel.add(charaTwo);
                characterVsCompPanel.add(charaThree);
                
                characters.get(0).addActionListener(this);  
                characters.get(0).setActionCommand("Garen");
 
                characters.get(1).addActionListener(this);
                characters.get(1).setActionCommand("Ashe");

                characters.get(2).addActionListener(this);
                characters.get(2).setActionCommand("Ahri");

                for(int i = 0; i<characters.size(); i++){
                    characterVsCompPanel.add(characters.get(i));
                }
                
                characterFrame.add(characterVsCompPanel);
                characterFrame.setVisible(true);
                //garen, ashe, ahri
            }
            public void actionPerformed(ActionEvent e) {
            
            }
    }
}
                                  