package frontend;

import javax.swing.JFrame;
import javax.swing.*;
public class htestframe {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowFrame();
    });
}
    private static void createAndShowFrame() {
        healthPanel panel = new healthPanel();
        healthPanel.Frame frame = panel.new Frame(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}

