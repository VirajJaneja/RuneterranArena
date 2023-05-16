package frontend;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

import backend.Ahri;
import backend.Ashe;
import backend.CharacterRegistry;
import backend.CharacterWrapper;
import backend.CharacterWrapperSq;
import backend.ComputerPlayer;
import backend.Garen;
import backend.Jinx;
import backend.KhaZix;
import backend.Malzahar;
import backend.Player;
import backend.Taric;
import backend.Turnstile;

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
    private ArrayList<CharacterWrapperSq> playerCharact = new ArrayList<CharacterWrapperSq>();
    private ArrayList<CharacterWrapperSq> compChar = new ArrayList<CharacterWrapperSq>();
    private int difficulty;
    private Point resolution;

    public CharacterSelect(int diff, Point resolution) {
        this.resolution = resolution;
        difficulty = diff;

        
        // playerCharact.add(new Ahri(0));
        // playerCharact.add(new Garen(0));
        // playerCharact.add(new Taric(0));
        // playerCharact.add(new KhaZix(0));
        // playerCharact.add(new Ashe(0));
        // playerCharact.add(new Jinx(0));
        // playerCharact.add(new Malzahar(0));

        for(int i= 0; i<6; i++){
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

        // characters.get(6).setFont(new Font("Arial", Font.BOLD, 14));
        // characters.get(6).setBorder(BorderFactory.createTitledBorder("Malzahar - Mage"));


        characters.get(characters.size()-1).setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // vs computer
        characterFrame = new JFrame("Character Select");
        characterPanel = new JPanel();

        layout = new GridLayout(3, 6, 20, 0);
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

        setButton();
        characterFrame.add(characterPanel);
        characterFrame.setSize((int)resolution.getX(), (int)resolution.getY());
        characterFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        
        private void playSound(String s){
            String sound = "lib/button SE.wav";
            if(s.equals("Confirm") || s.equals("None"))
                sound = "lib/Button 2 SE.wav";
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
        public void actionPerformed(ActionEvent e) {
            String act = e.getActionCommand();
            if(characterCount < maxTeamSize){
                if(act.equals("Garen")){
                    playSound("confirm");
                    characterBoolean[0] = !characterBoolean[0];
                    setButton();

                }
                else if(act.equals("Ashe")){
                    playSound("confirm");
                    characterBoolean[1] = !characterBoolean[1];
                    setButton();

                } else if(act.equals("Ahri")){
                    playSound("confirm");

                    characterBoolean[2] = !characterBoolean[2];
                    setButton();

                } else if(act.equals("Taric")){
                    playSound("confirm");
                    
                    characterBoolean[3] = !characterBoolean[3];
                    setButton();

                } else if(act.equals("Jinx")){
                    playSound("confirm");
                    
                    characterBoolean[4] = !characterBoolean[4];
                    setButton();

                } 
                else if(act.equals("Kha'Zix")){
                    playSound("confirm");
                    
                    characterBoolean[5] = !characterBoolean[5];
                    setButton();

                } 
                else if(act.equals("Malzahar")){
                    playSound("confirm");
                    
                    characterBoolean[6] = !characterBoolean[6];
                    setButton();

                } 

                else if(act.equals("Resolve")){
                    playSound("confirm");
                    characters.get(characters.size()-1).setText("Please select 3 characters minimum.");
                }

            } else if (characterCount >= maxTeamSize){
                if(act.equals("Resolve")){
                ArrayList<Integer> posTrue = new ArrayList<Integer>();
                for(int i= 0; i<characterBoolean.length; i++){
                    if(characterBoolean[i])
                        posTrue.add(i);
                }
                for(int i= 0; i<posTrue.size(); i++){
                    switch(posTrue.get(i)){
                        case 0:
                            playerCharact.add(new Garen(1));
                            break;
                        case 1:
                            playerCharact.add(new Ashe(1));
                            break;
                        case 2: 
                            playerCharact.add(new Ahri(1));
                            break;
                        case 3: 
                            playerCharact.add(new Taric(1));
                            break;
                        case 4: 
                            playerCharact.add(new Jinx(1));
                            break;
                        case 5: 
                            playerCharact.add(new KhaZix(1));
                            break;
                        case 6:
                            playerCharact.add(new Malzahar(1));
                        default:
                            break;
                    }
                }
                for(int i = 0; i<playerCharact.size(); i++){
                    double rand = Math.random();
                    if(rand>=0.15){
                        compChar.add(new Garen(difficulty));
                    } else if(rand<=0.25){
                        compChar.add(new Ashe(difficulty));
                    }else if(rand<=0.4){
                        compChar.add(new Ahri(difficulty));
                    }else if(rand<=0.5){
                        compChar.add(new Taric(difficulty));
                    }else if(rand<=0.6){
                        compChar.add(new Jinx(difficulty));
                    }else if(rand<=0.75){
                        compChar.add(new KhaZix(difficulty));
                    }else if(rand<=0.85){
                        compChar.add(new Malzahar(difficulty));
                    }else if(rand<=0.95){
                        compChar.add(new Garen(difficulty));
                    }else if(rand<=1){
                        compChar.add(new Taric(difficulty));
                    }
                }
                characterFrame.setVisible(false);
                new Turnstile(new Player(playerCharact.size(), playerCharact), new ComputerPlayer(compChar.size(), compChar));
            } if(act.equals("Garen")){
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
         } 

        }
        public void setButton(){
            characterCount = 0;
            for(int i = 0; i< characterBoolean.length; i++){
                if(characterBoolean[i] == true){
                    characters.get(i).setBackground(new Color(219,38,38));
                    characters.get(i).setText("Added to Team");
                    characterCount++;
                }
                else if(characterBoolean[i] == false){
                    characters.get(i).setBackground(new Color(50,205,50));
                    characters.get(i).setText("Add to Team");
                }
            }
        }
        // private Character getCharaValue(int i, int diff){
        //     switch(i){
        //         case 0:
        //             return new Garen(diff);
        //         case 1:
        //             return new Ashe(diff);
        //         case 2:
        //             return new Ahri(diff);
        //         case 3:
        //             return new Taric(diff);
        //         case 4:
        //             return new Jinx(diff);
        //         case 5:
        //             return new KhaZix(diff);
        //         case 6:
        //             return new Malzahar(diff);
        //     }
        // }
        
}
