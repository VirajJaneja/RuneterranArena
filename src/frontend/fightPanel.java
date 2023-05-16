package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class fightPanel extends JPanel {
    private JLabel player;
    private JLabel computer;

    private ImageIcon playerCharacter;
    private ImageIcon computerCharacter;

    public fightPanel() {
        setLayout(new BorderLayout());
        setOpaque(false);
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        player = new JLabel();
        ImageIcon playerIcon = new ImageIcon("lib/GarenGreenPlayer.gif");
        
        // create an AffineTransform object to flip the image over the y-axis
        AffineTransform playerFlip = AffineTransform.getScaleInstance(1, -1);
        playerFlip.translate(0, -playerIcon.getIconHeight());
        playerIcon.setImage(playerIcon.getImage().getScaledInstance(playerIcon.getIconWidth(),
                -playerIcon.getIconHeight(), Image.SCALE_DEFAULT));
        player.setIcon(playerIcon);
        player.setHorizontalTextPosition(JLabel.CENTER);
        player.setVerticalTextPosition(JLabel.BOTTOM);
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
