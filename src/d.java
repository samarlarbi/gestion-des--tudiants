import javax.swing.*;
import java.awt.*;

public class d extends JFrame {

    public d() {
        // Setting up the JFrame
        setTitle("Swing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// kif nsakr l prog tetsaker(ma tb9ach tranni)
        setSize(700, 600);// size l frame
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
        setVisible(true);// twali visible
 // Center the frame on the screen

        // Creating the first panel with red background
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center-aligning the label

        // Adding a label to the first panel
        JLabel label = new JLabel("Samar");
        panel1.add(label);

        // Creating the second panel with buttons
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center-aligning the buttons

        // Adding buttons to the second panel
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        panel2.add(button1);
        panel2.add(button2);

        // Adding both panels to the frame
        getContentPane().setLayout(new GridLayout(2, 1)); // 2 rows, 1 column
        getContentPane().add(panel1);
        getContentPane().add(panel2);

        // Displaying the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new d());
    }
}
