import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userinterface extends JFrame {
    public Color primary = new Color(71, 41, 52);


    public userinterface() {
       setMinimumSize(new Dimension(1100, 600));

       JButton minimizeButton = new JButton("<html><h2 color=black  style='padding:10px; font-size:20px ;font-family:Arial Rounded MT Bold'>- </h2> </html>");
       
               minimizeButton.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       setExtendedState(JFrame.ICONIFIED);
                   }
               });
               JButton closeButton = new JButton("<html><h3 color=black  style='padding:10px ; font-size:20px ;font-family:Arial Rounded MT Bold'> x </h3> </html>");
               closeButton.setBackground(Color.white);
               closeButton.setFocusable(false);
               
               
               closeButton.setBorder(null);
       
               
               minimizeButton.setBackground(Color.white);
               minimizeButton.setFocusable(false);
               minimizeButton.setBorder(null);
       
               closeButton.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       dispose();
                   }
               });
               JPanel bar = new JPanel();
               bar.add(minimizeButton);
       
               bar.add(closeButton);
       
               bar.setBackground(Color.white);       
        RoundedPanel panel = new RoundedPanel();
        setResizable(false);

        panel.setBackground(Color.white);
        JPanel list = new JPanel();
        list.setBackground(primary);
        list.setPreferredSize(new Dimension(300, 0));
        list.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(102, 89, 94));

        JButton ajou = new JButton("<html> <font color='white'>Saisir un etudiant </font>  </html>");
        ajou.setFocusable(false);
        ajou.setBackground(primary);
        ajou.setBorder(bottomBorder);
        ajou.setPreferredSize(new Dimension(300, 50));
        ajou.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton saisirnote = new JButton("<html> <font color='white'>Saisir les note </font>  </html>");
        saisirnote.setFocusable(false);
        saisirnote.setBackground(primary);
        saisirnote.setBorder(bottomBorder);
        saisirnote.setPreferredSize(new Dimension(300, 50));
        saisirnote.setHorizontalTextPosition(SwingConstants.CENTER);

        ajoutEtud Ajou = new ajoutEtud();

        panel.add(Ajou.panel, BorderLayout.CENTER);
        list.add(ajou);

        list.add(saisirnote);
        ajoutnotes notepanel = new ajoutnotes();

        saisirnote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(notepanel.panel);
                panel.revalidate();
                panel.repaint();
            }
        });
        ajou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();


                panel.add(Ajou.panel);
                panel.revalidate();
                panel.repaint();
            }
        });
       add(list, BorderLayout.WEST);
      add(panel);

        setLocationRelativeTo(null);
        getContentPane().setBackground(primary);

    };

   

}
