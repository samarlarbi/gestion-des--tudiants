import javax.swing.*;
import java.awt.*;

public class StyledButtonExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Styled Button Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton styledButton = new JButton("Styled Button");
            styledButton.setPreferredSize(new Dimension(200, 50));
            styledButton.setBackground(Color.RED);
            styledButton.setForeground(Color.WHITE);
            styledButton.setFocusPainted(false);
            styledButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding
            styledButton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.BLACK, 2), // Outer border
                    BorderFactory.createEmptyBorder(5, 15, 5, 15) // Inner padding
            ));

            frame.getContentPane().add(styledButton, BorderLayout.CENTER);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
