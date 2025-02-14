import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

 public class  Home {
    public Color primary = new Color(71, 41, 52);
    public JFrame mainFrame = new JFrame() ;
    public JFrame getMainFrame() {
        return mainFrame;
    }
    public Home() {
        
        
        mainFrame.setTitle("Swing App");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(1100, 600));
        mainFrame.setResizable(false);

        mainFrame.setLocationRelativeTo(null); 
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,0));
        
        panel.setBackground(primary);
        JButton minimizeButton = new JButton("<html><h2 color=white  style='padding:10px; font-size:20px ;font-family:Arial Rounded MT Bold'>- </h2> </html>");

        minimizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        JButton closeButton = new JButton("<html><h3 color=white  style='padding:10px ; font-size:20px ;font-family:Arial Rounded MT Bold'> x </h3> </html>");
        closeButton.setBackground(primary);
        closeButton.setFocusable(false);
        
        
        closeButton.setBorder(null);

        
        minimizeButton.setBackground(primary);
        minimizeButton.setFocusable(false);
        minimizeButton.setBorder(null);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
        JPanel bar = new JPanel();
        bar.add(minimizeButton);

        bar.add(closeButton);

        bar.setBackground(primary);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
       
        JLabel label = new JLabel("<html> <h1><center color='white'> <br> <br> <br> <br> <br>BIENVENU !  </center> </h1> <h3> <font color=#775D67> ACCEDER EN TAND QUE  </font> </h3></html>");
        panel.add(label);

        JButton adminButton = new JButton("<html><center color='white' > session Administrateur </center></html>");
        adminButton.setFocusable(false);
        adminButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        adminButton.setHorizontalTextPosition(SwingConstants.CENTER);
        adminButton.setBackground(primary);
        adminButton.setPreferredSize(new Dimension(200, 40));
        adminButton.setBorder(new LineBorder(new Color(125, 91, 104), 2));

        JButton userButton = new JButton("<html><center color='white' > session Utilisateur </center></html>");
        userButton.setFocusable(false);
        userButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        userButton.setHorizontalTextPosition(SwingConstants.CENTER);
        userButton.setBackground(primary);
        userButton.setBorder(new LineBorder(new Color(125, 91, 104), 2));

        
        loginuser panel2 = new loginuser();
        panel2.setBackground(primary);

panel.add(panel2);
        userButton.setPreferredSize(new Dimension(200, 40));
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();

               loginuser lu = new loginuser();
                lu.setBackground(primary);


                panel2.add(lu, BorderLayout.CENTER);
                panel2.revalidate();
                panel2.repaint();
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();

               adminlogin la = new adminlogin();

               la.setBackground(primary);


                panel2.add(la, BorderLayout.CENTER);
                panel2.revalidate();
                panel2.repaint();
            }
        });
        panel.add(userButton);
        panel.add(adminButton);

        mainFrame.getContentPane().setBackground(primary);

        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.getContentPane().add(panel, BorderLayout.WEST);
        mainFrame.getContentPane().add(panel2);


    }
    public static void main(String[] args) {
    
        Home page =  new Home();
        
        page.getMainFrame().setVisible(true);

}
    

    
}

