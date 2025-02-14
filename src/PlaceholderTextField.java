import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceholderTextField extends JTextField {
    private String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
        setForeground(Color.GRAY); // Set default color for the placeholder text
        setText(placeholder); // Set the placeholder text initially

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText(""); // Clear the text field when focused
                    setForeground(Color.BLACK); // Change text color to black when focused
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(placeholder); // Restore the placeholder text if no input provided
                    setForeground(Color.GRAY); // Change text color to gray when not focused
                }
            }
        });
    }

   

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("PlaceholderTextField Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PlaceholderTextField textField = new PlaceholderTextField("Enter your text here...");
            frame.getContentPane().add(textField, BorderLayout.CENTER);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
