package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
import frontend.MainScreen.Mode;

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
    private boolean[] characterBoolean = new boolean[6];
    private ArrayList<CharacterWrapperSq> playerCharact = new ArrayList<CharacterWrapperSq>();
    private ArrayList<CharacterWrapperSq> compChar = new ArrayList<CharacterWrapperSq>();
    private int difficulty;
    private Point resolution;
    private ImageIcon backgroundImage;
    private JLabel backgroundLabel;
    private JPanel backgroundPanel;
    private JPanel thirdPane;
    private GridLayout thirdLayout;
    private JPanel firstPane, secondPane;
    private GridLayout firstLayout;
    private GridLayout secondLayout;
    private JButton resolve;
    private Clip clip;
    public CharacterSelect(int diff, Point resolution, boolean sound) {
        System.out.println(sound);
        this.resolution = resolution;
        difficulty = diff;

       
        firstPane = new JPanel();
        firstLayout = new GridLayout(1,3);
        firstPane.setLayout(firstLayout);

        secondPane = new JPanel();
        secondLayout = new GridLayout(1,2, 30, 0);
        secondPane.setLayout(secondLayout);
        secondPane.setOpaque(false);
        thirdLayout = new GridLayout(1,3);
        thirdPane = new JPanel(thirdLayout);



        setLayout(new GridLayout(3,1));


        for(int i= 0; i<6; i++){
            characters.add(new JButton("Add to Team"));
        }        
       
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

        resolve = new JButton();
        resolve.setFont(new Font("Arial", Font.BOLD, 14));
        resolve.setBorder(BorderFactory.createTitledBorder("Confirm Your Team"));


        // vs computer
        //characterFrame = new JFrame("Character Select");
        characterPanel = new JPanel();

    
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("lib/RiftBG.jpg").getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        };
        
        setContentPane(backgroundPanel);


        JLabel GarenLabel = new JLabel();

        GarenLabel.setIcon(new javax.swing.ImageIcon("lib/icons/pfps/garen icon.png"));
        //GarenLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));


        JLabel AsheLabel = new JLabel();
        AsheLabel.setIcon(new javax.swing.ImageIcon("lib/icons/pfps/ashe icon.png"));
       // AsheLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        JLabel AhriLabel = new JLabel();
        AhriLabel.setIcon(new javax.swing.ImageIcon("lib/icons/pfps/ahri icon.png"));
        //AhriLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        JLabel TaricLabel = new JLabel();
        TaricLabel.setIcon(new javax.swing.ImageIcon("lib/icons/pfps/taric icon.png"));
        //TaricLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        JLabel JinxLabel = new JLabel();
        JinxLabel.setIcon(new javax.swing.ImageIcon("lib/icons/pfps/jinx icon.png"));
        //JinxLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        JLabel KhaLabel = new JLabel();
        KhaLabel.setIcon(new javax.swing.ImageIcon("lib/icons/pfps/KhaResize.png"));
        //KhaLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        // JLabel MalzLabel = new JLabel();
        // MalzLabel.setIcon(new javax.swing.ImageIcon("lib/malzahar icon.png"));
        // //MalzLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
       

        characters.get(0).addActionListener(this);  
        characters.get(0).setActionCommand("Garen");
        characters.get(0).setIcon(GarenLabel.getIcon());

        characters.get(1).addActionListener(this);
        characters.get(1).setActionCommand("Ashe");
        characters.get(1).setIcon(AsheLabel.getIcon());


        characters.get(2).addActionListener(this);
        characters.get(2).setActionCommand("Ahri");
        characters.get(2).setIcon(AhriLabel.getIcon());


        characters.get(3).setIcon(TaricLabel.getIcon());
        characters.get(3).addActionListener(this);
        characters.get(3).setActionCommand("Taric");

        characters.get(4).addActionListener(this);
        characters.get(4).setActionCommand("Jinx");
        characters.get(4).setIcon(JinxLabel.getIcon());

        characters.get(5).addActionListener(this);
        characters.get(5).setActionCommand("Kha'Zix");
        characters.get(5).setIcon(KhaLabel.getIcon());
        // characters.get(6).addActionListener(this);
        //characters.get(6).setActionCommand("Malzahar");
        
        //input more characters
        resolve.addActionListener(this);
        resolve.setActionCommand("Resolve");
        resolve.setText("Resolve");
        resolve.setSize(100,100);

        characterImages.add(GarenLabel);
        characterImages.add(AsheLabel);
        characterImages.add(AhriLabel);
        characterImages.add(TaricLabel);
        characterImages.add(JinxLabel);
        characterImages.add(KhaLabel);
        
        
        // for(int i = 0; i< characters.size(); i++){
        //     //firstPane.add(characterImages.get(i));
        // }
        for (int i = 0; i < 3; i++) {
            firstPane.add(characters.get(i));
        }
        
        //add(new JButton(new ImageIcon("lib/trans (1).png")));
        
        resolve.setText("Resolve");

        
        
        //add(new JButton(new ImageIcon("lib/trans (1).png")));
        for (int i = 3; i < characters.size(); i++) {
            thirdPane.add(characters.get(i));
        }

        ImageIcon back = new ImageIcon("lib/Backbutton (1).png");
        JButton backButton = createMaskedButton(back);
        backButton.setSize(back.getIconWidth(), back.getIconWidth());
        backButton.setBorder(null);
        backButton.setOpaque(false);
        backButton.addActionListener(this);
        backButton.setActionCommand("back");
        secondPane.add(backButton);
        secondPane.add(resolve);
        //for(int i = 0; i<)

        JLabel status = new JLabel("Mute");
        secondPane.add(status);
        add(firstPane);
        add(thirdPane);
        add(secondPane);

        setButton();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //playIdle(sound);
        //garen, ashe, ahri
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
    

        public JLabel updateTeam(){
            String list = "";

            for(int i= 0; i<characters.size(); i++){
                list+=characters.get(i).getName() + " - ";
            }
            
            return characterList;
        }

        private static String getPath(String characName, String icon){
            String result = "";
            result = "lib/" + characName +" "+"icon.png";
            return result;
        }
        private void playIdle(boolean b){
            String sound = "lib/SelectMusic.wav";
            if(b){
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
            
    }
        private void stopSound() {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            } else{
                clip.start();
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
        public void actionPerformed(ActionEvent e) {
            String act = e.getActionCommand();
            if (act.equals("back")) {
                setVisible(false);
                new MainScreen(new Point(600, 600));
               // stopSound();
            } else if (act.equals("mute")) {
                playSound("confirm");
               // stopSound();
            }
            else if (act.equals("Resolve")) {
                if (characterCount < 3) {
                    playSound("confirm");
                    resolve.setText("Please select at least 3 characters.");
                } else {
                    playSound("select");
                    ArrayList<Integer> posTrue = new ArrayList<Integer>();
                    for (int i = 0; i < characterBoolean.length; i++) {
                        if (characterBoolean[i]) {
                            posTrue.add(i);
                        }
                    }
                    for (int i = 0; i < posTrue.size(); i++) {
                        int pos = posTrue.get(i);
                        switch (pos) {
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
                            default:
                                break;
                        }
                    }
                    for (int i = 0; i < playerCharact.size(); i++) {
                        double rand = Math.random();
                        if (rand <= 0.16) {
                            compChar.add(new Garen(difficulty));
                        } else if (rand <= 0.32) {
                            compChar.add(new Ashe(difficulty));
                        } else if (rand <= 0.48) {
                            compChar.add(new Ahri(difficulty));
                        } else if (rand <= 0.64) {
                            compChar.add(new Taric(difficulty));
                        } else if (rand <= 0.80) {
                            compChar.add(new Jinx(difficulty));
                        } else if (rand <= 0.96) {
                            compChar.add(new KhaZix(difficulty));
                        } else if (rand <= 1) {
                            compChar.add(new Garen(difficulty));
                        }
                    }
                    for (int i = 0; i < playerCharact.size(); i++) {
                        System.out.println("COMP: " + compChar.get(i).getName());
                        System.out.println("Player: " + playerCharact.get(i).getName());
                    }
                    setButton(); // Add this line

                    setVisible(false);
                    new Turnstile(new Player(playerCharact.size(), playerCharact), new ComputerPlayer(compChar.size(), compChar));
                }
            } else if (act.equals("Garen") || act.equals("Ashe") || act.equals("Ahri") || act.equals("Taric") || act.equals("Jinx") || act.equals("Kha'Zix")) {
                playSound("confirm");
                int index = -1;
                switch (act) {
                    case "Garen":
                        index = 0;
                        break;
                    case "Ashe":
                        index = 1;
                        break;
                    case "Ahri":
                        index = 2;
                        break;
                    case "Taric":
                        index = 3;
                        break;
                    case "Jinx":
                        index = 4;
                        break;
                    case "Kha'Zix":
                        index = 5;
                        break;
                    default:
                        break;
                }
                if (index >= 0) {
                    characterBoolean[index] = !characterBoolean[index];
                    setButton();
                }
            }
        }
        

        public void setButton() {
            characterCount = 0;
            for (int i = 0; i < characterBoolean.length; i++) {
                if (characterBoolean[i]) {
                    characters.get(i).setBackground(new Color(219, 38, 38));
                    characters.get(i).setText("Added to Team");
                    characterCount++;
                } else {
                    characters.get(i).setBackground(new Color(50, 205, 50));
                    characters.get(i).setText("Add to Team");
                }
            }
            
            if (characterCount < 3) {
                resolve.setText("Please select 3 characters minimum.");
            } else {
                resolve.setText("Resolve");
            }
        }
        
    }        