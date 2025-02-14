import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class adminlogin extends RoundedPanel {
    public Color primary = new Color(71, 41, 52);

    public adminlogin() {
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Set layout to vertical

        JLabel title = new JLabel("<html><h1  style='padding:15px; font-size:30px '><font color='white'> <br><br> <br>Session Administrateur</font></h1></html>");
        
        JLabel title2 = new JLabel("<html><h3  style='padding:15px; font-size:20px '><font color='#73515D'> Entre le mot-de-passe</font></h3></html>");
        

        RoundedPanel p = new RoundedPanel();
        p.setBackground(primary);
        
        JButton userButton = new JButton("<html><center color='white'  > SUBMIT </center></html>");
        userButton.setFocusable(false);
        userButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        userButton.setHorizontalTextPosition(SwingConstants.CENTER);
        userButton.setBackground(new Color(125, 91, 104));
        userButton.setPreferredSize(new Dimension(250,50));

        userButton.setBorder(new LineBorder(new Color(125, 91, 104), 2));
        JTextField motdepassuser = new JTextField();
        motdepassuser.setPreferredSize(new Dimension(300,50));


         motdepassuser.setPreferredSize(new Dimension(300,50));
       
                        userButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               if (motdepassuser.getText().toString().equals("admin") == false)
                               {
                                System.out.println(motdepassuser.getText().toString() + motdepassuser.equals("user"));
                                        JOptionPane.showMessageDialog(null, "mot de passe faux", "erreur", JOptionPane.WARNING_MESSAGE);

                               }
                               else {
                               admininterface admin = new admininterface();
                               admin.setVisible(true);
                               }
                            }
                        });
        p.add(motdepassuser);
        p.add(userButton);
        add(title);
        add(title2);
        add(p);

    }

}
