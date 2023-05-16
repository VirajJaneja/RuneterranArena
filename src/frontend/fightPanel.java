package frontend;

import javax.swing.*;
import java.awt.*;

public class fightPanel extends JPanel {
    private JLabel player;
    private JLabel computer;

    public fightPanel() {
        setLayout(new BorderLayout());
        setOpaque(false);
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        player = new JLabel();
        player.setIcon(new ImageIcon("lib/GarenGreenPlayer.gif"));
        player.setPreferredSize(new Dimension(700, 250));
        centerPanel.add(player);

        add(centerPanel, BorderLayout.CENTER);

        JPanel eastPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        computer = new JLabel();
        computer.setIcon(new ImageIcon("lib/GarenGreenComputer.gif"));
        computer.setPreferredSize(new Dimension(500, 250));
        eastPanel.add(computer);

        add(eastPanel, BorderLayout.EAST);
    }
}
