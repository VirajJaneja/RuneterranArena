package frontend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import backend.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainScreen implements ActionListener {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JFrame Play;
    private JFrame settings;
    private JFrame modeSelect;
    private JFrame characterSelect;
    private ArrayList<JFrame> frameList= new ArrayList<JFrame>();

    public MainScreen() {

        mainFrame = new JFrame("Menu");
        

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 800, 800);
        //mainPanel.setLayout(null);
        int xMax = mainPanel.getWidth();
        int yMax = mainPanel.getHeight();
        System.out.println(xMax +", "+ yMax);

        JButton modes = new JButton("Mode");
        modes.setActionCommand("Mode");
        modes.setBounds(xMax/2, yMax/2,100,100);
        modes.addActionListener(this);
        mainPanel.add(modes);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setActionCommand("Settings");
        settingsButton.setBounds(xMax/2, yMax/2,100,100);
        settingsButton.addActionListener(this);
        mainPanel.add(settingsButton);
        

        mainFrame.add(mainPanel);
        mainFrame.setSize(800, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String act = ae.getActionCommand();
        if(act.equals("Mode")){
            mainFrame.setVisible(false);
            new Mode();

        } else if(act.equals("Settings")){
            mainFrame.setVisible(false);
            new Settings();
        }
    }

    public static void main(String args[]) {
        new MainScreen();
    }

    class Settings extends MainScreen{
        private JFrame settingsFrame;
            public Settings(){
                settingsFrame = new JFrame();
            }

    }

    class Mode extends MainScreen{
        private JFrame modeSelect;
        private JPanel modePanel;
        public Mode(){

            modeSelect = new JFrame();
            modePanel = new JPanel();
        
            JButton modeSel = new JButton("VS PLAYER");
            modeSel.setBounds(100, 200, 100, 100);
            JButton modeSel2 = new JButton("VS COMPUTER");
            modeSel.setBounds(100, 200, 100, 100);

            modeSel.setActionCommand("Player");
            modeSel2.setActionCommand("Computer");
            
            modeSel.addActionListener(this);
            modeSel2.addActionListener(this);
            modePanel.add(modeSel);
            modePanel.add(modeSel2);
            
            modeSelect.setSize(800, 800);
            modeSelect.add(modePanel);
            modeSelect.setVisible(true);

        }
        public void actionPerformed(ActionEvent ae) {
            String act = ae.getActionCommand();
            if(act.equals("Player")){
                new CharacterSelect(true);
            }
            else{
                new CharacterSelect(false);
            }

    }
    class CharacterSelect extends MainScreen{
        private JFrame characterSelectFrame;
        public CharacterSelect(boolean b){
            if(b){

            } 
            else{

            }

        }
    }
}
    
}

   
