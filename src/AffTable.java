import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class AffTable {
    public Color primary = new Color(71, 41, 52);

    RoundedPanel panel;

    public AffTable() {

        panel = new RoundedPanel();
        panel.setBackground(Color.white);
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(102, 89, 94));

        JPanel byId = new JPanel();
        JButton sortup = new JButton("<html><h6 color=white> croissante </h6> </html>");
        JButton sortdw = new JButton("<html><h6 color=white> decroissante </h6> </html>");
        sortdw.setPreferredSize(new Dimension(55, 15));
        sortup.setPreferredSize(new Dimension(55, 15));
        input id = new input("Id de l'étudiant :");
        id.textField3.setPreferredSize(new Dimension(200, 30));
        id.label.setPreferredSize(new Dimension(100, 30));
        JButton search = new JButton("<html><center>search by id</center></html>");
        search.setBackground(new Color(222, 224, 223));
        search.setFocusable(false);

        byId.add(id.panel);
        byId.add(search);
        byId.setBackground(Color.white);
        JPanel all = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 10, 0, 0));

        JButton refrech = new JButton("<html><h5 color=white>TOUS LES ETUDIANTS </h5> </html> ");
        refrech.setFocusable(false);
        JButton csv = new JButton("export To Csv");
        refrech.setBackground(primary);
        sortdw.setFocusable(false);

        sortdw.setBackground(primary);
        JPanel a = new JPanel();
        a.setLayout(new BoxLayout(a, BoxLayout.Y_AXIS)); 
        all.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        sortup.setFocusable(false);

        sortup.setBackground(primary);

        all.add(refrech);
        a.add(sortdw);
        a.add(sortup);
        all.setLayout(new BoxLayout(all, BoxLayout.X_AXIS));
        all.add(byId);
        all.setBackground(Color.white);
        all.setPreferredSize(new Dimension(700, 50));
        panel.add(all);
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS)); 
        JPanel titre = new JPanel();
        titre.setBackground(Color.white);
        JLabel nomLabelt = new JLabel("NOM");
        nomLabelt.setPreferredSize(new Dimension(120, 50));

        JLabel prenomLabelt = new JLabel("PRENOM");

        JLabel cinLabelt = new JLabel(" CIN");
        JLabel emailLabelt = new JLabel("EMAIL");
        JLabel frLabelt = new JLabel("FRANCAIS ");
        JLabel genreLabelt = new JLabel("GENRE");
        JLabel telLabelt = new JLabel("TEL");
        JLabel idLabelt = new JLabel(" ID");
        JLabel arbLabelt = new JLabel("ARABE");
        JLabel mathLabelt = new JLabel("MATH");
        JLabel engLabelt = new JLabel(" ANGLAIS");
        JLabel infoLabelt = new JLabel("INFORMATIQUE");
        JLabel phyLabelt = new JLabel(" PHYSIQUE");

        JLabel moyennt = new JLabel(" MOYENNE");
        JLabel admist = new JLabel(" ADMIS");
        titre.add(idLabelt);

        titre.add(nomLabelt);
        titre.add(prenomLabelt);
        titre.add(cinLabelt);
        titre.add(emailLabelt);
        titre.add(genreLabelt);
        titre.add(frLabelt);
        titre.add(telLabelt);
        titre.add(arbLabelt);
        titre.add(mathLabelt);
        titre.add(engLabelt);
        titre.add(infoLabelt);
        titre.add(phyLabelt);
        titre.add(moyennt);
        titre.add(admist);
        list.add(titre);
        nomLabelt.setPreferredSize(new Dimension(120, 50));

        prenomLabelt.setPreferredSize(new Dimension(120, 50));
        cinLabelt.setPreferredSize(new Dimension(120, 50));
        emailLabelt.setPreferredSize(new Dimension(120, 50));
        frLabelt.setPreferredSize(new Dimension(120, 50));
        genreLabelt.setPreferredSize(new Dimension(120, 50));
        telLabelt.setPreferredSize(new Dimension(120, 50));
        idLabelt.setPreferredSize(new Dimension(120, 50));
        arbLabelt.setPreferredSize(new Dimension(120, 50));
        mathLabelt.setPreferredSize(new Dimension(120, 50));
        engLabelt.setPreferredSize(new Dimension(120, 50));
        infoLabelt.setPreferredSize(new Dimension(120, 50));
        phyLabelt.setPreferredSize(new Dimension(120, 50));
        moyennt.setPreferredSize(new Dimension(120, 50));
        admist.setPreferredSize(new Dimension(120, 50));

        ajoutnoteconnection notec = new ajoutnoteconnection();
        ArrayList<Etudiant> et = notec.AffID(-1);
        for (int i = 0; i < et.size(); i++) {
            Etudiant currentEtudiant = et.get(i);

            JPanel ligne = new JPanel();
            ligne.setBackground(Color.white);
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
            currentEtudiant.setMoyenne();
            currentEtudiant.setAdmis();
            JLabel moyenn = new JLabel(" " + currentEtudiant.getMoyenne());
            JLabel admis = new JLabel(" " + currentEtudiant.getAdmis());

            prenomLabel.setPreferredSize(new Dimension(120, 50));
            cinLabel.setPreferredSize(new Dimension(120, 50));
            emailLabel.setPreferredSize(new Dimension(120, 50));
            frLabel.setPreferredSize(new Dimension(120, 50));
            genreLabel.setPreferredSize(new Dimension(120, 50));
            telLabel.setPreferredSize(new Dimension(120, 50));
            idLabel.setPreferredSize(new Dimension(120, 50));
            arbLabel.setPreferredSize(new Dimension(120, 50));
            mathLabel.setPreferredSize(new Dimension(120, 50));
            engLabel.setPreferredSize(new Dimension(120, 50));
            infoLabel.setPreferredSize(new Dimension(120, 50));
            phyLabel.setPreferredSize(new Dimension(120, 50));
            moyenn.setPreferredSize(new Dimension(120, 50));
            admis.setPreferredSize(new Dimension(120, 50));

            ligne.add(idLabel);

            ligne.add(nomLabel);
            ligne.add(prenomLabel);
            ligne.add(cinLabel);
            ligne.add(emailLabel);
            ligne.add(genreLabel);

            ligne.add(frLabel);
            ligne.add(telLabel);
            ligne.add(arbLabel);
            ligne.add(mathLabel);
            ligne.add(engLabel);
            ligne.add(infoLabel);
            ligne.add(phyLabel);
            ligne.add(moyenn);
            ligne.add(admis);
            list.add(ligne);
            list.revalidate();
            list.repaint();
            ligne.setBorder(bottomBorder);

        }
        test t = new test();
        csv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajoutnoteconnection r = new ajoutnoteconnection();
                JFileChooser fileChooser = new JFileChooser();

                int result = fileChooser.showSaveDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    r.exportToCsv(filePath + ".csv");
                } else {
                    JOptionPane.showMessageDialog(null, "No file selected.");
                }
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                list.removeAll();
                ajoutnoteconnection notec = new ajoutnoteconnection();

                if (id.textField3.getText().toString().length() != 0) {

                    if (t.isInteger(id.getValue()) == false) {
                        JOptionPane.showMessageDialog(null, "ID doit etre un entier");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "entre un ID");
                    return;

                }
                Etudiant currentEtudiant = notec.fetch(Integer.parseInt(id.getValue()));
                if (currentEtudiant == null) {
                    JOptionPane.showMessageDialog(null, "Etudiant n'exist pas");
                    return;
                }
                JPanel ligne = new JPanel();
                JLabel nomLabel = new JLabel(currentEtudiant.getNom());

                nomLabel.setPreferredSize(new Dimension(120, 50));
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
                currentEtudiant.setMoyenne();
                currentEtudiant.setAdmis();
                JLabel moyenn = new JLabel(" " + currentEtudiant.getMoyenne());
                JLabel admis = new JLabel(" " + currentEtudiant.getAdmis());

                prenomLabel.setPreferredSize(new Dimension(120, 50));
                cinLabel.setPreferredSize(new Dimension(120, 50));
                emailLabel.setPreferredSize(new Dimension(120, 50));
                frLabel.setPreferredSize(new Dimension(120, 50));
                genreLabel.setPreferredSize(new Dimension(120, 50));
                telLabel.setPreferredSize(new Dimension(120, 50));
                idLabel.setPreferredSize(new Dimension(120, 50));
                arbLabel.setPreferredSize(new Dimension(120, 50));
                mathLabel.setPreferredSize(new Dimension(120, 50));
                engLabel.setPreferredSize(new Dimension(120, 50));
                infoLabel.setPreferredSize(new Dimension(120, 50));
                phyLabel.setPreferredSize(new Dimension(120, 50));

                ligne.add(idLabel);

                ligne.add(nomLabel);
                ligne.add(prenomLabel);
                ligne.add(cinLabel);
                ligne.add(emailLabel);
                ligne.add(genreLabel);

                ligne.add(frLabel);
                ligne.add(telLabel);
                ligne.add(arbLabel);
                ligne.add(mathLabel);
                ligne.add(engLabel);
                ligne.add(infoLabel);
                ligne.add(phyLabel);
                ligne.add(moyenn);
                ligne.add(admis);
                ligne.setBorder(bottomBorder);
                ligne.setBackground(Color.white);

                list.add(ligne);
                list.revalidate();
                list.repaint();

            }
        });
        refrech.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.removeAll();
                ajoutnoteconnection notec = new ajoutnoteconnection();
                ArrayList<Etudiant> et = notec.AffID(-1);
                for (int i = 0; i < et.size(); i++) {
                    Etudiant currentEtudiant = et.get(i);

                    JPanel ligne = new JPanel();
                    JLabel nomLabel = new JLabel(currentEtudiant.getNom());
                    nomLabel.setPreferredSize(new Dimension(120, 50));
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

                    prenomLabel.setPreferredSize(new Dimension(120, 50));
                    cinLabel.setPreferredSize(new Dimension(120, 50));
                    emailLabel.setPreferredSize(new Dimension(120, 50));
                    frLabel.setPreferredSize(new Dimension(120, 50));
                    genreLabel.setPreferredSize(new Dimension(120, 50));
                    telLabel.setPreferredSize(new Dimension(120, 50));
                    idLabel.setPreferredSize(new Dimension(120, 50));
                    arbLabel.setPreferredSize(new Dimension(120, 50));
                    mathLabel.setPreferredSize(new Dimension(120, 50));
                    engLabel.setPreferredSize(new Dimension(120, 50));
                    infoLabel.setPreferredSize(new Dimension(120, 50));
                    phyLabel.setPreferredSize(new Dimension(120, 50));
                    currentEtudiant.setMoyenne();
                    currentEtudiant.setAdmis();
                    JLabel moyenn = new JLabel(" " + currentEtudiant.getMoyenne());
                    JLabel admis = new JLabel(" " + currentEtudiant.getAdmis());

                    ligne.add(idLabel);

                    ligne.add(nomLabel);
                    ligne.add(prenomLabel);
                    ligne.add(cinLabel);
                    ligne.add(emailLabel);
                    ligne.add(genreLabel);

                    ligne.add(frLabel);
                    ligne.add(telLabel);
                    ligne.add(arbLabel);
                    ligne.add(mathLabel);
                    ligne.add(engLabel);
                    ligne.add(infoLabel);
                    ligne.add(phyLabel);
                    ligne.add(moyenn);
                    ligne.add(admis);

                    ligne.setBorder(bottomBorder);
                    ligne.setBackground(Color.white);

                    list.add(ligne);
                    list.revalidate();
                    list.repaint();

                }
            }
        });

        sortup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.removeAll();
                ajoutnoteconnection notec = new ajoutnoteconnection();
                ArrayList<Etudiant> et = notec.sortup(-1);
                for (int i = 0; i < et.size(); i++) {
                    Etudiant currentEtudiant = et.get(i);

                    JPanel ligne = new JPanel();
                    JLabel nomLabel = new JLabel(currentEtudiant.getNom());
                    nomLabel.setPreferredSize(new Dimension(120, 50));
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

                    prenomLabel.setPreferredSize(new Dimension(120, 50));
                    cinLabel.setPreferredSize(new Dimension(120, 50));
                    emailLabel.setPreferredSize(new Dimension(120, 50));
                    frLabel.setPreferredSize(new Dimension(120, 50));
                    genreLabel.setPreferredSize(new Dimension(120, 50));
                    telLabel.setPreferredSize(new Dimension(120, 50));
                    idLabel.setPreferredSize(new Dimension(120, 50));
                    arbLabel.setPreferredSize(new Dimension(120, 50));
                    mathLabel.setPreferredSize(new Dimension(120, 50));
                    engLabel.setPreferredSize(new Dimension(120, 50));
                    infoLabel.setPreferredSize(new Dimension(120, 50));
                    phyLabel.setPreferredSize(new Dimension(120, 50));
                    currentEtudiant.setMoyenne();
                    currentEtudiant.setAdmis();
                    JLabel moyenn = new JLabel(" " + currentEtudiant.getMoyenne());
                    JLabel admis = new JLabel(" " + currentEtudiant.getAdmis());

                    ligne.add(idLabel);

                    ligne.add(nomLabel);
                    ligne.add(prenomLabel);
                    ligne.add(cinLabel);
                    ligne.add(emailLabel);
                    ligne.add(genreLabel);

                    ligne.add(frLabel);
                    ligne.add(telLabel);
                    ligne.add(arbLabel);
                    ligne.add(mathLabel);
                    ligne.add(engLabel);
                    ligne.add(infoLabel);
                    ligne.add(phyLabel);
                    ligne.add(moyenn);
                    ligne.add(admis);

                    ligne.setBorder(bottomBorder);
                    ligne.setBackground(Color.white);

                    list.add(ligne);
                    list.revalidate();
                    list.repaint();

                }

            }
        });
        sortdw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.removeAll();
                ajoutnoteconnection notec = new ajoutnoteconnection();
                ArrayList<Etudiant> et = notec.sortdw(-1);
                for (int i = 0; i < et.size(); i++) {
                    Etudiant currentEtudiant = et.get(i);

                    JPanel ligne = new JPanel();
                    JLabel nomLabel = new JLabel(currentEtudiant.getNom());
                    nomLabel.setPreferredSize(new Dimension(120, 50));
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

                    prenomLabel.setPreferredSize(new Dimension(120, 50));
                    cinLabel.setPreferredSize(new Dimension(120, 50));
                    emailLabel.setPreferredSize(new Dimension(120, 50));
                    frLabel.setPreferredSize(new Dimension(120, 50));
                    genreLabel.setPreferredSize(new Dimension(120, 50));
                    telLabel.setPreferredSize(new Dimension(120, 50));
                    idLabel.setPreferredSize(new Dimension(120, 50));
                    arbLabel.setPreferredSize(new Dimension(120, 50));
                    mathLabel.setPreferredSize(new Dimension(120, 50));
                    engLabel.setPreferredSize(new Dimension(120, 50));
                    infoLabel.setPreferredSize(new Dimension(120, 50));
                    phyLabel.setPreferredSize(new Dimension(120, 50));
                    currentEtudiant.setMoyenne();
                    currentEtudiant.setAdmis();
                    JLabel moyenn = new JLabel(" " + currentEtudiant.getMoyenne());
                    JLabel admis = new JLabel(" " + currentEtudiant.getAdmis());

                    ligne.add(idLabel);

                    ligne.add(nomLabel);
                    ligne.add(prenomLabel);
                    ligne.add(cinLabel);
                    ligne.add(emailLabel);
                    ligne.add(genreLabel);

                    ligne.add(frLabel);
                    ligne.add(telLabel);
                    ligne.add(arbLabel);
                    ligne.add(mathLabel);
                    ligne.add(engLabel);
                    ligne.add(infoLabel);
                    ligne.add(phyLabel);
                    ligne.add(moyenn);
                    ligne.add(admis);

                    ligne.setBorder(bottomBorder);
                    ligne.setBackground(Color.white);

                    list.add(ligne);
                    list.revalidate();
                    list.repaint();

                }

            }
        });
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(700, 400)); 
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panel.add(scrollPane);
        panel.add(a, BorderLayout.SOUTH);
        panel.add(csv);

    }

    public RoundedPanel getPanel() {
        return panel;
    }
}
