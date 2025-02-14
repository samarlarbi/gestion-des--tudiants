import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class input {
    JPanel panel;
    String value="";
    public JTextField textField3;
public JLabel label;
    public input(String title) {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
         label = new JLabel("<html> <h3 color=##976E7D style='padding:5px' >"+title+" </h3> </html>");

        label.setPreferredSize(new Dimension(200, 30));

        panel.setBackground(Color.WHITE);
        textField3 = new JTextField();
        textField3.setPreferredSize(new Dimension(200, 30));
        panel.add(label);
        panel.add(textField3);

    }

    public String getValue() {
        value = textField3.getText();

        return value;
    }
    public void setValue(String value) {
        textField3.setText(value);
    }
}
