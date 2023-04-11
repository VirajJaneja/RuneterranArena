package frontend;
import frontend.Player;

import backend.Turnstile;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JFrame screen;
    JPanel CurrentPanel;


    public MainFrame(){
        screen = new JFrame();
        screen.setSize(500, 600);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        CurrentPanel = new GamePanel(500, 500, new Turnstile());
        screen.setVisible(true);

    }
}
