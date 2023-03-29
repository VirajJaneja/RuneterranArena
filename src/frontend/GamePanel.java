package frontend;

import backend.Turnstile;
import javax.swing.*;

public class GamePanel extends JPanel {
    int height;
    int width;
    Turnstile TurnStile;

    public GamePanel(int h, int w, Turnstile baseTS) {
        TurnStile = baseTS;
        height = h;
        width = w;
    }
}
