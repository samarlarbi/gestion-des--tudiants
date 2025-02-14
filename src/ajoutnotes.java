import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ajoutnotes extends JPanel {
  public RoundedPanel panel;
  public JButton search;
  public JButton update;

  public ajoutnotes() {

    panel = new RoundedPanel();
    panel.setBackground(Color.WHITE);

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Setting BoxLayout with Y_AXIS
    JLabel label = new JLabel(
        "<html><h1  style=' font-size:40px '><font color='#472934'> Ajouter les notes</font></h1></html>");

    panel.add(label, BorderLayout.WEST);
    JPanel p = new JPanel();
    p.setBackground(Color.white);
    input id = new input("Id de etudiant :");

    search = new JButton("<html><center > SEARCH </center></html>");
    search.setBackground(new Color(227, 216, 221));
    id.textField3.setPreferredSize(new Dimension(100, 25));
    p.add(id.panel);
    p.add(search);

    JPanel etudiant = new JPanel();
    etudiant.setBackground(Color.white);

    input panel1 = new input("arabe :");
    input panel2 = new input("anglais :");

    input panel3 = new input("francais :");
    input panel4 = new input("math :");

    input panel5 = new input("physique :");
    input panel6 = new input("informatique  :");
    update = new JButton("<html><center color='white'> UPDATE </center></html>");
    update.setBackground(new Color(222, 224, 223));
    update.setFocusable(false);
    update.setVerticalTextPosition(SwingConstants.BOTTOM);
    update.setHorizontalTextPosition(SwingConstants.CENTER);
    update.setBackground(new Color(125, 91, 104));
    update.setPreferredSize(new Dimension(150, 45));

    update.setBorder(new LineBorder(new Color(125, 91, 104), 2));

    test t = new test();
    search.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        System.out.println("waa");
        ajoutnoteconnection notec = new ajoutnoteconnection();
        if (id.textField3.getText().toString().length() != 0) {
          Etudiant et = null;

          if (t.isInteger(id.getValue()) == false) {
            JOptionPane.showMessageDialog(null, "ID doit etre un entier");
            return;
          } else {
            et = notec.fetch(Integer.parseInt(id.getValue()));

          }
          if (et == null) {

            JOptionPane.showMessageDialog(null, "Etudiant n'exist pas.");

          } else {
            etudiant.removeAll();

            JLabel labelet = new JLabel(
                et.getNom() + "                                                " + et.getPrenom());
            etudiant.add(labelet);
            panel1.setValue(Float.toString(et.getArb()));
            panel2.setValue(Float.toString(et.getEng()));
            panel3.setValue(Float.toString(et.getFr()));
            panel4.setValue(Float.toString(et.getMath()));
            panel5.setValue(Float.toString(et.getPhy()));
            panel6.setValue(Float.toString(et.getInfo()));

            etudiant.revalidate();
            etudiant.repaint();

          }
        } else {
          JOptionPane.showMessageDialog(null, "entrer un ID");

        }
      }
    });
    update.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        System.out.println("waa");
        ajoutnoteconnection notec = new ajoutnoteconnection();

        Etudiant et = notec.fetch(Integer.parseInt(id.getValue()));

        if (Float.parseFloat(panel1.getValue()) < 0 || Float.parseFloat(panel1.getValue()) > 20 ||
            Float.parseFloat(panel2.getValue()) < 0 || Float.parseFloat(panel2.getValue()) > 20 ||
            Float.parseFloat(panel3.getValue()) < 0 || Float.parseFloat(panel3.getValue()) > 20 ||
            Float.parseFloat(panel4.getValue()) < 0 || Float.parseFloat(panel4.getValue()) > 20 ||
            Float.parseFloat(panel5.getValue()) < 0 || Float.parseFloat(panel5.getValue()) > 20 ||
            Float.parseFloat(panel6.getValue()) < 0 || Float.parseFloat(panel6.getValue()) > 20) {
          JOptionPane.showMessageDialog(null, "verifier les note !!!");
          return;

        }

        et.setArb(Float.parseFloat(panel1.getValue()));
        et.setEng(Float.parseFloat(panel2.getValue()));
        et.setFr(Float.parseFloat(panel3.getValue()));
        et.setMath(Float.parseFloat(panel4.getValue()));
        et.setPhy(Float.parseFloat(panel5.getValue()));
        et.setInfo(Float.parseFloat(panel6.getValue()));

        int x = notec.update(et);

        if (x != -1) {
          JOptionPane.showMessageDialog(null, " done  ");

        } else {
          JOptionPane.showMessageDialog(null, "Etudiant n'exist pas.");
        }
      }
    });
    panel.add(p);
    panel.add(etudiant);

    panel.add(panel1.panel, BorderLayout.CENTER);
    panel.add(panel2.panel, BorderLayout.CENTER);
    panel.add(panel3.panel, BorderLayout.CENTER);

    panel.add(panel4.panel, BorderLayout.CENTER);
    panel.add(panel5.panel, BorderLayout.CENTER);
    panel.add(panel6.panel, BorderLayout.CENTER);
    panel.add(update, BorderLayout.CENTER);

  }


}
