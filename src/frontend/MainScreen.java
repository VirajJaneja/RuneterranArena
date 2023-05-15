package frontend;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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
            modeSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            diffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
        private int maxTeamSize = 3;
        private int characterCount = 0;
        private ArrayList<JButton> characters = new ArrayList<JButton>();
        private ArrayList<JLabel> characterImages = new ArrayList<JLabel>();
        private ArrayList<JLabel> classLabel = new ArrayList<JLabel>();
        private GridLayout layout;
        private JLabel characterList;
        private boolean[] characterBoolean = new boolean[7];
        private ArrayList<Character> playerCharacter = new ArrayList<Character>();
        private ArrayList<Character> computerCharacter = new ArrayList<Character>();



        public CharacterSelect(int diff) {
            difficulty = diff;
            for(int i= 0; i<7; i++){
                characters.add(new JButton("Add to Team"));
            }

            characters.add(new JButton("Resolve"));
            
           
            characters.get(0).setFont(new Font("Arial", Font.BOLD, 14));
            characters.get(0).setBorder(BorderFactory.createTitledBorder("Garen - Fighter"));
    
            characters.get(1).setFont(new Font("Arial", Font.BOLD, 14));
            characters.get(1).setBorder(BorderFactory.createTitledBorder("Ashe - Marksman"));

            characters.get(2).setFont(new Font("Arial", Font.BOLD, 14));
            characters.get(2).setBorder(BorderFactory.createTitledBorder("Ahri - Mage"));

            characters.get(3).setFont(new Font("Arial", Font.BOLD, 14));
            characters.get(3).setBorder(BorderFactory.createTitledBorder("Taric - Fighter"));

            characters.get(4).setFont(new Font("Arial", Font.BOLD, 14));
            characters.get(4).setBorder(BorderFactory.createTitledBorder("Jinx - Marksman"));

            characters.get(5).setFont(new Font("Arial", Font.BOLD, 14));
            characters.get(5).setBorder(BorderFactory.createTitledBorder("Kha'Zix - Fighter"));

            characters.get(6).setFont(new Font("Arial", Font.BOLD, 14));
            characters.get(6).setBorder(BorderFactory.createTitledBorder("Malzahar - Mage"));


            characters.get(characters.size()-1).setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            // vs computer
            characterFrame = new JFrame("Character Select");
            characterPanel = new JPanel();

            layout = new GridLayout(3, 7, 20, 0);
            characterPanel.setLayout(layout);



            JLabel GarenLabel = new JLabel();
            GarenLabel.setIcon(new javax.swing.ImageIcon("lib/garen icon.png"));
            //GarenLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));


            JLabel AsheLabel = new JLabel();
            AsheLabel.setIcon(new javax.swing.ImageIcon("lib/ashe icon.png"));
           // AsheLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

            JLabel AhriLabel = new JLabel();
            AhriLabel.setIcon(new javax.swing.ImageIcon("lib/ahri icon.png"));
            //AhriLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

            JLabel TaricLabel = new JLabel();
            TaricLabel.setIcon(new javax.swing.ImageIcon("lib/taric icon.png"));
            //TaricLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

            JLabel JinxLabel = new JLabel();
            JinxLabel.setIcon(new javax.swing.ImageIcon("lib/jinx icon.png"));
            //JinxLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

            JLabel KhaLabel = new JLabel();
            KhaLabel.setIcon(new javax.swing.ImageIcon("lib/kha icon.png"));
            //KhaLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

            JLabel MalzLabel = new JLabel();
            MalzLabel.setIcon(new javax.swing.ImageIcon("lib/malzahar icon.png"));
            //MalzLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
           

            characters.get(0).addActionListener(this);  
            characters.get(0).setActionCommand("Garen");
 
            characters.get(1).addActionListener(this);
            characters.get(1).setActionCommand("Ashe");

            characters.get(2).addActionListener(this);
            characters.get(2).setActionCommand("Ahri");

            characters.get(3).addActionListener(this);
            characters.get(3).setActionCommand("Taric");

            characters.get(4).addActionListener(this);
            characters.get(4).setActionCommand("Jinx");

            characters.get(5).addActionListener(this);
            characters.get(5).setActionCommand("Kha'Zix");

            characters.get(6).addActionListener(this);
            characters.get(6).setActionCommand("Malzahar");
            
            //input more characters

            
            characters.get(characters.size()-1).addActionListener(this);
            characters.get(characters.size()-1).setActionCommand("Resolve");

            characterImages.add(GarenLabel);
            characterImages.add(AsheLabel);
            characterImages.add(AhriLabel);
            characterImages.add(TaricLabel);
            characterImages.add(JinxLabel);
            characterImages.add(KhaLabel);
            characterImages.add(MalzLabel);
            
            for(int i = 0; i<layout.getColumns(); i++){
                characterPanel.add(characterImages.get(i));
            }
            for(int i = 0; i<layout.getColumns(); i++){
                characterPanel.add(characters.get(i));
            }

            characterPanel.add(new JLabel());
            characterPanel.add(new JLabel());
            characterPanel.add(new JLabel());
            
            
            //resolve index
            characterPanel.add(characters.get(characters.size()-1));
        
            characterPanel.add(new JLabel());
            characterPanel.add(new JLabel());
            characterPanel.add(new JLabel());

            setButton();
            characterFrame.add(characterPanel);
            characterFrame.setSize((int)resolution.getX(), (int)resolution.getY());
            characterFrame.setVisible(true);
            
            //garen, ashe, ahri
            }

            public JLabel updateTeam(){
                String list = "";

                for(int i= 0; i<characters.size(); i++){
                    list+=characters.get(i).getName() + " - ";
                }
                
                return characterList;
            }
            

            public void actionPerformed(ActionEvent e) {
                String act = e.getActionCommand();
                if(characterCount < maxTeamSize){
                    if(act.equals("Garen")){
                        characterBoolean[0] = !characterBoolean[0];
                        setButton();

                    }
                    else if(act.equals("Ashe")){
                        characterBoolean[1] = !characterBoolean[1];
                        setButton();
    
                    } else if(act.equals("Ahri")){

                        characterBoolean[2] = !characterBoolean[2];
                        setButton();
    
                    } else if(act.equals("Taric")){
                        
                        characterBoolean[3] = !characterBoolean[3];
                        setButton();
    
                    } else if(act.equals("Jinx")){
                        
                        characterBoolean[4] = !characterBoolean[4];
                        setButton();
    
                    } 
                    else if(act.equals("Kha'Zix")){
                        
                        characterBoolean[5] = !characterBoolean[5];
                        setButton();
    
                    } 
                    else if(act.equals("Malzahar")){
                        
                        characterBoolean[6] = !characterBoolean[6];
                        setButton();
    
                    } 

                    else if(act.equals("Resolve")){
                        characters.get(characters.size()-1).setText("Please select 3 characters minimum.");
                    }

                } else if (characterCount == maxTeamSize){
                    ArrayList<Integer> posTrue = new ArrayList<Integer>();
                    for(int i= 0; i<characterBoolean.length; i++){
                        if(characterBoolean[i])
                            posTrue.add(i);
                    }
                    for(int i= 0; i<posTrue.size(); i++){
                        switch(posTrue.get(i)){
                            case 0:
                                playerCharacter.add(new Garen(difficulty));
                                break;
                            case 1:
                                playerCharacter.add(new Ashe(difficulty));
                                break;
                            case 2: 
                                playerCharacter.add(new Ahri(difficulty));
                                break;
                            case 3: 
                                playerCharacter.add(new Taric(difficulty));
                                break;
                            case 4: 
                                playerCharacter.add(new Jinx(difficulty));
                                break;
                            case 5: 
                                playerCharacter.add(new KhaZix(difficulty));
                                break;
                            case 6:
                                playerCharacter.add(new Malzahar(difficulty));
                            default:
                                break;
                        }
                    }
                    new Turnstile(new Player(playerCharacter.size(), playerCharacter), new Player(playerCharacter.size(), playerCharacter));
                    
                } 

            }
            public void setButton(){
                for(int i = 0; i< characterBoolean.length; i++){
                    if(characterBoolean[i] == true){
                        characters.get(i).setBackground(new Color(219,38,38));
                        characters.get(i).setText("Added to Team");
                    }
                    else if(characterBoolean[i] == false){
                        characters.get(i).setBackground(new Color(50,205,50));
                        characters.get(i).setText("Add to Team");
                    }
                }
            }
    }
    
}
                                  