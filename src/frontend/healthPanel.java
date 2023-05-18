package frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class healthPanel extends JFrame {
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton updateButton;
    private JPanel mainPanel;

    public healthPanel() {
        setTitle("Scrollable Text Area Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);

        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add new text to the text area
                textArea.append("New update!\n");
                // Scroll to the bottom of the text area
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
        });

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(scrollPane);
        mainPanel.add(updateButton);

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new healthPanel();
            }
        });
    }
}
