import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admininterface extends JFrame {
    public Color primary = new Color(71, 41, 52);

    private JFrame window;

    public admininterface() {

        window = new JFrame();

    
               JButton closeButton = new JButton("<html><h3 color=black  style='font-size:15px ;padding-right:10px;font-family:Arial Rounded MT Bold'> x </h3> </html>");
               closeButton.setBackground(Color.white);
               closeButton.setFocusable(false);
               
               
               closeButton.setBorder(null);
       
               
               closeButton.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       // Close the frame when the button is clicked
                       window.dispose();
                   }
               });
               JPanel bar = new JPanel();
       
               bar.add(closeButton, BorderLayout.WEST);
       bar.setPreferredSize(new Dimension(20,50));
               bar.setBackground(Color.white);
        RoundedPanel panel = new RoundedPanel();

        panel.setBackground(Color.white);
        JPanel list = new JPanel();
        list.setBackground(primary);
        list.setPreferredSize(new Dimension(300, 0));
        list.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(102, 89, 94));

        JButton ajout = new JButton("<html> <font color='white'>Ajouter Un Etudiant </font>  </html>");
        ajout.setFocusable(false);
        ajout.setBackground(primary);
        ajout.setBorder(bottomBorder);
        ajout.setPreferredSize(new Dimension(300, 50));
        ajout.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton saisirnote = new JButton("<html> <font color='white'>Saisir les note d ' un etudiant</font>  </html>");
        saisirnote.setFocusable(false);
        saisirnote.setBackground(primary);
        saisirnote.setBorder(bottomBorder);
        saisirnote.setPreferredSize(new Dimension(300, 50));
        saisirnote.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton Affiche = new JButton("<html> <font color='white'>Affiche les etudiants</font>  </html>");
        Affiche.setFocusable(false);
        Affiche.setBackground(primary);
        Affiche.setBorder(bottomBorder);
        Affiche.setPreferredSize(new Dimension(300, 50));
        Affiche.setHorizontalTextPosition(SwingConstants.CENTER);
        JButton Supprimer = new JButton("<html> <font color='white'>Suprime etudiant</font>  </html>");
        Supprimer.setFocusable(false);
        Supprimer.setBackground(primary);
        Supprimer.setBorder(bottomBorder);
        Supprimer.setPreferredSize(new Dimension(300, 50));
        Supprimer.setHorizontalTextPosition(SwingConstants.CENTER);
        ajoutEtud Ajou = new ajoutEtud();

        panel.add(Ajou.panel, BorderLayout.CENTER);
        list.add(ajout);

        list.add(saisirnote);
        list.add(Affiche);
        list.add(Supprimer);

        saisirnote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                ajoutnotes notepanel = new ajoutnotes();
                panel.setLayout(new FlowLayout()); 

                panel.add(notepanel.panel, BorderLayout.EAST);
                panel.revalidate();
                panel.repaint();

            }
        });
        Supprime sup = new Supprime();

        Supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.setLayout(new FlowLayout()); 

                panel.add(sup.panel, BorderLayout.CENTER);
                panel.revalidate();
                panel.repaint();

            }
        });

        ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();


                panel.add(Ajou.panel, BorderLayout.EAST);

                panel.revalidate();
                panel.repaint();

                

            }
        });

        Affiche.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                AffTable table = new AffTable();

                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
                panel.add(table.getPanel(), BorderLayout.EAST);
                panel.revalidate();
                panel.repaint();
            }
        });
        window.getContentPane().setBackground(primary);

        window.add(list, BorderLayout.WEST);
        window.add(panel, BorderLayout.CENTER);

        window.setMinimumSize(new Dimension(1100, 600));
        window.setLocationRelativeTo(null); 
    };

    public void show() {
        window.setVisible(true);

    }

    public static void main(String[] args) {
        admininterface a = new admininterface();
        a.show();
    }

}
