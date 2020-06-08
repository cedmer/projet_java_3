package game;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class fenetre {
    private JPanel Paneljeu;
    private JPanel Choixjoueur;
    private JPanel QCMPanel;
    private JPanel RCPanel;
    private JPanel VFPanel;
    private JPanel j1;
    private JPanel j2;
    private JPanel j3;
    private JPanel j4;
    private JTextArea joueur1;
    private JTextArea joueur2;
    private JTextArea joueur3;
    private JTextArea joueur4;
    private JButton validerjoueur;
    private JButton QCMValider;
    private JButton QCMVrai;
    private JButton QCMFaux;
    private JRadioButton Reponse1;
    private JRadioButton reponse2;
    private JRadioButton reponse3;
    private JTextArea RCreponse;
    private JButton RCValider;
    private JLabel QCMjoueur;
    private JLabel QCMQuestion;
    private JLabel RCQuestion;
    private JLabel RCjoueur;
    private JLabel VFJoueur;
    private JLabel VFQuestion;
    private JLabel RCTheme;
    private JLabel VFTheme;
    private JLabel QCMTheme;
    private JLabel QCMNiveau;
    private JLabel VFNiveau;
    private JLabel RCNiveau;
    private JPanel Score;
    private JLabel Score_titre;
    private JLabel joueurpremier;
    private JLabel joueurdeuxieme;
    private JLabel joueurtroisieme;
    private JLabel joueurdernier;
    private JLabel score1;
    private JLabel score2;
    private JLabel score3;
    private JLabel score4;
    private JButton phaseSuivante;
    private JPanel Paneljoueurjouer;
    private JButton commencer;
    private JLabel Joueurplay;
    private JPanel Choixtheme;
    private JLabel Choixthemetitre;
    private JRadioButton theme1;
    private JRadioButton theme2;
    private JRadioButton theme3;
    private JRadioButton theme4;
    private JRadioButton theme5;
    private JRadioButton theme6;
    private JRadioButton theme7;
    private JRadioButton theme8;
    private JRadioButton theme9;
    private JRadioButton theme10;
    private JButton Choisir;
    private QCM qcm1;
    private Question q1;
    private ListeQuestions listetheme1 = new ListeQuestions();
    private ListeQuestions listetheme2;
    private ListeQuestions listetheme3;
    private ListeQuestions listetheme4;
    private ListeQuestions listetheme5;
    private ListeQuestions listetheme6;
    private ListeQuestions listetheme7;
    private ListeQuestions listetheme8;
    private ListeQuestions listetheme9;
    private ListeQuestions listetheme10;

    private JFrame f = new JFrame("jeu");

    private JFrame frame = new JFrame();

    private Themes t = new Themes();
    private ArrayList<String> listjoueur = new ArrayList<String>();
    private int Phase = 0;

    public fenetre() {
        validerjoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (joueur1.getText().equals("") || (joueur2.getText().equals("")) || (joueur3.getText().equals("")) || (joueur4.getText().equals(""))) {
                    JOptionPane.showMessageDialog(frame, "Veuiller choisir votre pseudo");
                } else {
                    Joueur j1 = new Joueur();
                    j1.Saisir(joueur1.getText());
                    Joueur j2 = new Joueur();
                    j2.Saisir(joueur2.getText());
                    Joueur j3 = new Joueur();
                    j3.Saisir(joueur3.getText());
                    Joueur j4 = new Joueur();
                    j4.Saisir(joueur4.getText());
                    EnsJoueurs J = new EnsJoueurs();
                    J.add(j1);
                    J.add(j2);
                    J.add(j3);
                    J.add(j4);
                    listjoueur.add(j1.getNom());
                    listjoueur.add(j2.getNom());
                    listjoueur.add(j3.getNom());
                    listjoueur.add(j4.getNom());
                    Collections.shuffle(listjoueur);//pour mélanger l'odre de jeu des joueurs
                    Phase = 1;

                    test(listetheme1);


                }

            }
        });
        QCMValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        RCValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        QCMVrai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        QCMFaux.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        phaseSuivante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        commencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Choisir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        Paneljeu = new JPanel();
        Paneljeu.setLayout(new GridBagLayout());
        Choixjoueur = new JPanel();
        Choixjoueur.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Paneljeu.add(Choixjoueur, gbc);
        j1 = new JPanel();
        j1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Choixjoueur.add(j1, gbc);
        j1.setBorder(BorderFactory.createTitledBorder(null, "Joueur 1", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        j2 = new JPanel();
        j2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Choixjoueur.add(j2, gbc);
        j2.setBorder(BorderFactory.createTitledBorder(null, "Joueur 2 ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        j3 = new JPanel();
        j3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Choixjoueur.add(j3, gbc);
        j3.setBorder(BorderFactory.createTitledBorder(null, "Joueur 3", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        j4 = new JPanel();
        j4.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Choixjoueur.add(j4, gbc);
        j4.setBorder(BorderFactory.createTitledBorder(null, "Joueur 4", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        joueur2 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Choixjoueur.add(joueur2, gbc);
        joueur1 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Choixjoueur.add(joueur1, gbc);
        joueur3 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Choixjoueur.add(joueur3, gbc);
        joueur4 = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Choixjoueur.add(joueur4, gbc);
        validerjoueur = new JButton();
        validerjoueur.setText("Valider");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Choixjoueur.add(validerjoueur, gbc);
        QCMPanel = new JPanel();
        QCMPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Paneljeu.add(QCMPanel, gbc);
        QCMjoueur = new JLabel();
        QCMjoueur.setText("Joueur");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(QCMjoueur, gbc);
        QCMQuestion = new JLabel();
        QCMQuestion.setText("Question : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(QCMQuestion, gbc);
        Reponse1 = new JRadioButton();
        Reponse1.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(Reponse1, gbc);
        reponse2 = new JRadioButton();
        reponse2.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(reponse2, gbc);
        reponse3 = new JRadioButton();
        reponse3.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(reponse3, gbc);
        QCMTheme = new JLabel();
        QCMTheme.setText("Theme");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(QCMTheme, gbc);
        QCMNiveau = new JLabel();
        QCMNiveau.setText("Niveau");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(QCMNiveau, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Theme :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Joueur :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Niveau :");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Question : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(label4, gbc);
        QCMValider = new JButton();
        QCMValider.setText("Valider");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        QCMPanel.add(QCMValider, gbc);
        RCPanel = new JPanel();
        RCPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Paneljeu.add(RCPanel, gbc);
        RCjoueur = new JLabel();
        RCjoueur.setText("Joueur");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(RCjoueur, gbc);
        RCQuestion = new JLabel();
        RCQuestion.setText("Question");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(RCQuestion, gbc);
        RCreponse = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        RCPanel.add(RCreponse, gbc);
        RCValider = new JButton();
        RCValider.setText("Valider");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RCPanel.add(RCValider, gbc);
        RCTheme = new JLabel();
        RCTheme.setText("Theme");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(RCTheme, gbc);
        RCNiveau = new JLabel();
        RCNiveau.setText("Niveau");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(RCNiveau, gbc);
        VFPanel = new JPanel();
        VFPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Paneljeu.add(VFPanel, gbc);
        VFJoueur = new JLabel();
        VFJoueur.setText("Joueur");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFJoueur, gbc);
        QCMVrai = new JButton();
        QCMVrai.setText("Vrai");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        VFPanel.add(QCMVrai, gbc);
        QCMFaux = new JButton();
        QCMFaux.setText("Faux");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        VFPanel.add(QCMFaux, gbc);
        VFQuestion = new JLabel();
        VFQuestion.setText("Question");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFQuestion, gbc);
        VFTheme = new JLabel();
        VFTheme.setText("Theme");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFTheme, gbc);
        VFNiveau = new JLabel();
        VFNiveau.setText("Niveau");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFNiveau, gbc);
        Score = new JPanel();
        Score.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Paneljeu.add(Score, gbc);
        Score_titre = new JLabel();
        Score_titre.setText("Score");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Score.add(Score_titre, gbc);
        joueurpremier = new JLabel();
        joueurpremier.setText("Joueur");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Score.add(joueurpremier, gbc);
        joueurdeuxieme = new JLabel();
        joueurdeuxieme.setText("Joueur");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Score.add(joueurdeuxieme, gbc);
        joueurtroisieme = new JLabel();
        joueurtroisieme.setText("Joueur");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Score.add(joueurtroisieme, gbc);
        joueurdernier = new JLabel();
        joueurdernier.setText("Joueur");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Score.add(joueurdernier, gbc);
        score1 = new JLabel();
        score1.setText("score 1");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Score.add(score1, gbc);
        score2 = new JLabel();
        score2.setText("score 2");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Score.add(score2, gbc);
        score3 = new JLabel();
        score3.setText("score 3");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Score.add(score3, gbc);
        score4 = new JLabel();
        score4.setText("score 4");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Score.add(score4, gbc);
        phaseSuivante = new JButton();
        phaseSuivante.setText("Phase suivante");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Score.add(phaseSuivante, gbc);
        Paneljoueurjouer = new JPanel();
        Paneljoueurjouer.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Paneljeu.add(Paneljoueurjouer, gbc);
        commencer = new JButton();
        commencer.setText("Commencer");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Paneljoueurjouer.add(commencer, gbc);
        Joueurplay = new JLabel();
        Joueurplay.setText("Joueur machin a toi de jouer");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Paneljoueurjouer.add(Joueurplay, gbc);
        Choixtheme = new JPanel();
        Choixtheme.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Paneljeu.add(Choixtheme, gbc);
        Choixthemetitre = new JLabel();
        Choixthemetitre.setText("Choisir 3 themes");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(Choixthemetitre, gbc);
        theme1 = new JRadioButton();
        theme1.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme1, gbc);
        theme2 = new JRadioButton();
        theme2.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme2, gbc);
        theme3 = new JRadioButton();
        theme3.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme3, gbc);
        theme4 = new JRadioButton();
        theme4.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme4, gbc);
        theme5 = new JRadioButton();
        theme5.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme5, gbc);
        theme6 = new JRadioButton();
        theme6.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme6, gbc);
        theme7 = new JRadioButton();
        theme7.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme7, gbc);
        theme8 = new JRadioButton();
        theme8.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme8, gbc);
        theme9 = new JRadioButton();
        theme9.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme9, gbc);
        theme10 = new JRadioButton();
        theme10.setText("RadioButton");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(theme10, gbc);
        Choisir = new JButton();
        Choisir.setText("Choisir ces themes");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Choixtheme.add(Choisir, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return Paneljeu;
    }

    public void init() {
        f.setContentPane(Choixjoueur);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setPreferredSize(new Dimension(300, 300));
        f.pack();
        f.setVisible(true);

        qcm1 = new QCM("oui ou non ? ", "oui", "non", "peut-etre", "oui");
        q1 = new Question(t.getListThemes().get(0), 1, qcm1);
        listetheme1.AjouterQuestion(q1);


    }

    public void test(ListeQuestions l) {
    	QCMQuestion.setText(listetheme1.getListQuestionstheme().get(0).QCMtype().getTexte());//marche pas
        QCMTheme.setText(listetheme1.getListQuestionstheme().get(0).getTheme());
        QCMjoueur.setText(listjoueur.get(0));
        Reponse1.setText(listetheme1.getListQuestionstheme().get(0).QCMtype().getRep1());
        reponse2.setText(listetheme1.getListQuestionstheme().get(0).QCMtype().getRep2());
        reponse3.setText(listetheme1.getListQuestionstheme().get(0).QCMtype().getRep3());
        QCMNiveau.setText(String.valueOf(listetheme1.getListQuestionstheme().get(0).difficulty));
        f.setContentPane(QCMPanel);
        f.revalidate();
    }
}
