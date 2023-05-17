package frontend;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HealthPanelExample extends JFrame {

    public HealthPanelExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Health Panel Example");

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Load the image icons
        ImageIcon icon1 = loadImageIcon("lib/animations/Ahri/Computer/AhriIdleComp.gif");
        ImageIcon icon2 = loadImageIcon("lib/animations/Ahri/Player/AhriNewIdle.gif");

        // Create the labels to display the image icons
        JLabel label1 = new JLabel(icon1);
        JLabel label2 = new JLabel(icon2);

        // Set a fixed size for the JLabel components
        int desiredWidth = 100; // Adjust as needed
        int desiredHeight = 100; // Adjust as needed
        label1.setPreferredSize(new Dimension(desiredWidth, desiredHeight));
        label2.setPreferredSize(new Dimension(desiredWidth, desiredHeight));

        // Create the health bars
        JProgressBar healthBar1 = new JProgressBar();
        JProgressBar healthBar2 = new JProgressBar();

        // Create a sub-panel for the image icons
        JPanel iconsPanel = new JPanel();
        iconsPanel.setLayout(new FlowLayout());
        iconsPanel.add(label1);
        iconsPanel.add(label2);

        // Create a sub-panel for the health bars
        JPanel healthBarsPanel = new JPanel();
        healthBarsPanel.setLayout(new FlowLayout());
        healthBarsPanel.add(healthBar1);
        healthBarsPanel.add(healthBar2);

        // Add the sub-panels to the main panel
        mainPanel.add(iconsPanel, BorderLayout.CENTER);
        mainPanel.add(healthBarsPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    private ImageIcon loadImageIcon(String path) {
        try {
            // Load the image file
            Image image = ImageIO.read(getClass().getResource(path));
            // Scale the image to fit within the desired size
            int desiredWidth = 100; // Adjust as needed
            int desiredHeight = 100; // Adjust as needed
            Image scaledImage = image.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
            // Create an ImageIcon from the scaled image
            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HealthPanelExample example = new HealthPanelExample();
            example.setVisible(true);
        });
    }
}

