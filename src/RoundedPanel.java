import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {
    private int borderRadius = 80;

    public RoundedPanel() {
        setOpaque(false); 
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, width +400, height - 1, borderRadius, borderRadius));

        super.paintComponent(g2);
        g2.dispose();
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rounded Panel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            RoundedPanel roundedPanel = new RoundedPanel();
            roundedPanel.setBackground(Color.lightGray);

            JLabel label = new JLabel("This is a rounded panel.");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            roundedPanel.add(label);

            frame.getContentPane().add(roundedPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
