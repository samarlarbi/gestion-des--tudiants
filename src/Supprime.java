import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Supprime {
  public Color primary = new Color(71, 41, 52);

  public RoundedPanel panel;
  int x=-1;

  public Supprime() {
    panel = new RoundedPanel();
    panel.setBackground(Color.white);
    RoundedPanel container = new RoundedPanel();
    container.setBackground(Color.white);
    input id = new input("Id de etudiant :");
    JButton search2 = new JButton("<html><center > SEARCH </center></html>");
    JButton supp = new JButton("<html><center color='white' > Suprimer </center></html>");
    supp.setFocusable(false);
    supp.setBackground(primary);
    supp.setPreferredSize(new Dimension(200,50));
    container.add(id.panel);
    container.add(search2);
   
    JPanel ligne = new JPanel();
    ligne.setBackground(Color.white);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
    test t= new test();

    supp.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        if(x!=-1){
          ajoutnoteconnection notec = new ajoutnoteconnection();

          notec.sup(x);
          ligne.removeAll();
          
       
          ligne.revalidate();
          ligne.repaint();
        }
        else{
                           JOptionPane.showMessageDialog(null, "entre un ID");

  }}});
          search2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ligne.removeAll();
                ajoutnoteconnection notec = new ajoutnoteconnection();

                if (id.textField3.getText().toString().length()!=0)
                {
  
                  if (t.isInteger(id.getValue())==false)
                  {                   JOptionPane.showMessageDialog(null, "ID doit etre un entier");
                  return;
                }
            }
            else{
                                 JOptionPane.showMessageDialog(null, "entre un ID");
                                 return;

            }
                Etudiant currentEtudiant = notec.fetch(Integer.parseInt(id.getValue()));
              if (currentEtudiant == null)
              {
                JOptionPane.showMessageDialog(null, "Etudiant n'exist pas");
return;
              }
              x=Integer.parseInt(id.getValue());
                JLabel nomLabel = new JLabel(currentEtudiant.getNom());

                    nomLabel.setPreferredSize(new Dimension(100, 50));
                    JLabel prenomLabel = new JLabel(" " + currentEtudiant.getPrenom());
                    JLabel cinLabel = new JLabel(" " + currentEtudiant.getCin());
                    JLabel emailLabel = new JLabel(" " + currentEtudiant.getEmail());
                    JLabel frLabel = new JLabel(" " + currentEtudiant.getFr());
                    JLabel genreLabel = new JLabel("" + currentEtudiant.getGenre());
                    JLabel telLabel = new JLabel(" " + currentEtudiant.getTel());
                    JLabel idLabel = new JLabel(" " + currentEtudiant.getID());
                    JLabel arbLabel = new JLabel("" + currentEtudiant.getArb());
                    JLabel mathLabel = new JLabel("" + currentEtudiant.getMath());
                    JLabel engLabel = new JLabel(" " + currentEtudiant.getEng());
                    JLabel infoLabel = new JLabel("" + currentEtudiant.getInfo());
                    JLabel phyLabel = new JLabel(" " + currentEtudiant.getPhy());

                    prenomLabel.setPreferredSize(new Dimension(50, 50));
                    cinLabel.setPreferredSize(new Dimension(120, 50));
                    emailLabel.setPreferredSize(new Dimension(120, 50));
                    frLabel.setPreferredSize(new Dimension(50, 50));
                    genreLabel.setPreferredSize(new Dimension(50, 50));
                    telLabel.setPreferredSize(new Dimension(120, 50));
                    idLabel.setPreferredSize(new Dimension(50, 50));
                    arbLabel.setPreferredSize(new Dimension(50, 50));
                    mathLabel.setPreferredSize(new Dimension(50, 50));
                    engLabel.setPreferredSize(new Dimension(50, 50));
                    infoLabel.setPreferredSize(new Dimension(50, 50));
                    phyLabel.setPreferredSize(new Dimension(50, 50));

                    ligne.add(nomLabel);
                    ligne.add(prenomLabel);
                    ligne.add(cinLabel);
                    ligne.add(emailLabel);
                    ligne.add(frLabel);
                    ligne.add(genreLabel);
                    ligne.add(telLabel);
                    ligne.add(idLabel);
                    ligne.add(arbLabel);
                    ligne.add(mathLabel);
                    ligne.add(engLabel);
                    ligne.add(infoLabel);
                    ligne.add(phyLabel);
                    ligne.setBackground(Color.white);

                    
                    ligne.revalidate();
                    ligne.repaint();

                
            }
        });

        JScrollPane scrollPane = new JScrollPane(ligne);
        scrollPane.setPreferredSize(new Dimension(700,100));                       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                   scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
               panel.setBorder(BorderFactory.createEmptyBorder(30, 10, 0, 0));

    panel.add(container,BorderLayout.NORTH);
    panel.add(scrollPane,BorderLayout.NORTH);

    panel.add(supp,BorderLayout.NORTH);
  }
}
