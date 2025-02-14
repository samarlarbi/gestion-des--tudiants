import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

class ajoutEtud extends JPanel {
  public RoundedPanel panel;
  public JButton ADD;
  public String nom;
  public String prenom;
  public String dte;
  public String email;
  public String cin;
  public String tel;
  public String genre;

  public ajoutEtud() {

    panel = new RoundedPanel();
    panel.setBackground(Color.WHITE);

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JLabel label = new JLabel(
        "<html><h1  style=' font-size:40 '><font color='#472934'> Saisir un etudiant</font></h1></html>");

    panel.add(label, BorderLayout.WEST);

    input panel1 = new input("NOM :");
    input panel2 = new input("PRNOM :");

    input panel3 = new input("DATE DE NAISSANCE :");
    input panel4 = new input("CIN :");

    input panel5 = new input("NUM TEL  :");
    input panel6 = new input("EMAIL  :");
    JPanel buttons = new JPanel();
    buttons.setBackground(Color.WHITE);
    JButton ADD = new JButton("<html><center color='white' > SUBMIT </center></html>");
    ADD.setFocusable(false);
    ADD.setVerticalTextPosition(SwingConstants.BOTTOM);
    ADD.setHorizontalTextPosition(SwingConstants.CENTER);
    ADD.setBackground(new Color(125, 91, 104));
    ADD.setPreferredSize(new Dimension(150, 50));

    ADD.setBorder(new LineBorder(new Color(125, 91, 104), 2));
    JButton RETOUR = new JButton("<html><center color=#472934 > RETOUR </center></html>");
    RETOUR.setFocusable(false);
    RETOUR.setVerticalTextPosition(SwingConstants.BOTTOM);
    RETOUR.setHorizontalTextPosition(SwingConstants.CENTER);
    RETOUR.setBackground(new Color(207, 200, 203));
    RETOUR.setPreferredSize(new Dimension(150, 50));

    RETOUR.setBorder(new LineBorder(new Color(125, 91, 104), 2));

    JPanel panelGenre = new JPanel();
    panelGenre.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

    JLabel genderLabel = new JLabel("Select Gender:");
    genderLabel.setPreferredSize(new Dimension(200, 30));
    panelGenre.setBackground(Color.WHITE);

    String[] Gendre = { "HOMME", "FEMME" };
    JComboBox selectionComboBox = new JComboBox<>(Gendre);
    panelGenre.add(genderLabel, BorderLayout.WEST);
    panelGenre.add(selectionComboBox);
    test t = new test();
    ADD.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        nom = panel1.getValue();
        prenom = panel2.getValue();
        dte = panel3.getValue();
        email = panel6.getValue();
        cin = panel4.getValue();
        tel = panel5.getValue();
        genre = String.valueOf(selectionComboBox.getSelectedItem());
        if (nom.toString().length() == 0 || prenom.toString().length() == 0 || dte.toString().length() == 0
            || email.toString().length() == 0 || cin.toString().length() == 0 || tel.toString().length() == 0
            || genre.toString().length() == 0) {
          JOptionPane.showMessageDialog(null, "les champs est OBLIGATOIRE !");
          return;

        }
        if (email.contains("@") == false) {
          JOptionPane.showMessageDialog(null, "Email invalide !");
          return;
        }
        if (t.isInteger(tel) == false) {
          JOptionPane.showMessageDialog(null, "TEL invalide !");
          return;

        }
        if (t.isValidDateFormat(dte) == false) {
          JOptionPane.showMessageDialog(null, "date invalide !");
          return;
        }
        System.out.println("waa");
        Etudiantconnection etucon = new Etudiantconnection();
        int test = etucon.Ajouter(new Etudiant(nom, prenom, email, tel, dte, genre, cin, 0, 0, 0, 0, 0, 0, 0));
        if (test >= 0) {
          JOptionPane.showMessageDialog(null, "Étudiant ajouté avec succès !");
        } else {
          JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'étudiant.");
        }
      }
    });
    panel.add(panel1.panel);
    panel.add(panel2.panel);
    panel.add(panel3.panel);
    panel.add(panelGenre);

    panel.add(panel4.panel);
    panel.add(panel5.panel);
    panel.add(panel6.panel);
    buttons.add(ADD);
    // buttons.add(RETOUR);
    panel.add(buttons);

  }

}
