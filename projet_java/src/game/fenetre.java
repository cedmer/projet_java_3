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
    private JButton VFVrai;
    private JButton VFFaux;
    private JButton reponse2;
    private JButton reponse3;
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
    private JButton reponse1;
    private QCM qcm1;
    private Question q1;
    private QCM qcm2;
    private Question q2;
    private VF vf1;
    private Question q3;
    private ListeQuestions listetheme = new ListeQuestions();
    private ListeQuestions listetheme1 = new ListeQuestions();
    private ListeQuestions listetheme2 = new ListeQuestions();
    private ListeQuestions listetheme3 = new ListeQuestions();
    private ListeQuestions listetheme4 = new ListeQuestions();
    private ListeQuestions listetheme5 = new ListeQuestions();
    private ListeQuestions listetheme6 = new ListeQuestions();
    private ListeQuestions listetheme7 = new ListeQuestions();
    private ListeQuestions listetheme8 = new ListeQuestions();
    private ListeQuestions listetheme9 = new ListeQuestions();
    private ListeQuestions listetheme10 = new ListeQuestions();
    private int nbrquestionphase1 = 0;
    private int nbrquestionsurletheme = 0;
    private int Theme;
    private int joueurjoue;
    private EnsJoueurs J = new EnsJoueurs();

    private JFrame f = new JFrame("jeu");

    private JFrame frame = new JFrame();

    private Themes t = new Themes();
    private ArrayList<Joueur> listjoueur = new ArrayList<Joueur>();
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
                    //J.add(j1);
                    //J.add(j2);
                    //J.add(j3);
                    //J.add(j4);
                    listjoueur.add(j1);
                    listjoueur.add(j2);
                    listjoueur.add(j3);
                    listjoueur.add(j4);
                    Collections.shuffle(listjoueur);//pour melanger l'odre de jeu des joueurs
                    Phase = 1;
                    Theme = t.SelectionnerTheme();
                    System.out.println(Theme);
                    Question(Theme);

                }

            }
        });
        RCValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (RCreponse.getText().equals(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).RCtype().isRep())) {
                    int temp = listjoueur.get(joueurjoue).getScore();
                    temp = temp + 2;
                    listjoueur.get(joueurjoue).setScore(temp);
                }
                if (Phase == 1) {
                    if (nbrquestionphase1 == 16) {
                        debut_phase2();
                        Phase = 2;
                    } else {
                        preparation();
                    }
                }

            }
        });
        VFVrai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bol = true;
                if (Boolean.compare(bol, listetheme.getListQuestionstheme().get(nbrquestionsurletheme).VFtype().isRep()) == 0) {
                    System.out.println("test6");
                    int temp = listjoueur.get(joueurjoue).getScore();
                    temp = temp + 2;
                    listjoueur.get(joueurjoue).setScore(temp);
                }
                if (Phase == 1) {
                    if (nbrquestionphase1 == 16) {
                        debut_phase2();
                        Phase = 2;
                    } else {
                        preparation();
                    }
                }

            }
        });
        VFFaux.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bol = false;
                if (Boolean.compare(bol, listetheme.getListQuestionstheme().get(nbrquestionsurletheme).VFtype().isRep()) == 0) {
                    System.out.println("test6");
                    int temp = listjoueur.get(joueurjoue).getScore();
                    temp = temp + 2;
                    listjoueur.get(joueurjoue).setScore(temp);
                }
                if (Phase == 1) {
                    if (nbrquestionphase1 == 16) {
                        debut_phase2();
                        Phase = 2;
                    } else {
                        preparation();
                    }
                }

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
                Question(Theme);
            }
        });
        reponse1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reponse1.getText().equals(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRepV())) {
                    int temp = listjoueur.get(joueurjoue).getScore();
                    temp = temp + 2;
                    listjoueur.get(joueurjoue).setScore(temp);
                }
                System.out.println(nbrquestionphase1);
                if (Phase == 1) {
                    if (nbrquestionphase1 == 16) {
                        debut_phase2();
                        Phase = 2;
                    } else {
                        preparation();
                    }
                } else if (Phase == 2) {
                }
            }
        });
        reponse2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reponse2.getText().equals(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRepV())) {
                    int temp = listjoueur.get(joueurjoue).getScore();
                    temp = temp + 2;
                    listjoueur.get(joueurjoue).setScore(temp);
                }
                System.out.println(nbrquestionphase1);
                if (Phase == 1) {
                    if (nbrquestionphase1 == 16) {
                        debut_phase2();
                        Phase = 2;
                    } else {
                        preparation();
                    }
                } else if (Phase == 2) {
                }
            }
        });
        reponse3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reponse3.getText().equals(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRepV())) {
                    int temp = listjoueur.get(joueurjoue).getScore();
                    temp = temp + 2;
                    listjoueur.get(joueurjoue).setScore(temp);
                }
                System.out.println(nbrquestionphase1);
                if (Phase == 1) {
                    if (nbrquestionphase1 == 16) {
                        debut_phase2();
                        Phase = 2;
                    } else {
                        preparation();
                    }
                } else if (Phase == 2) {
                }
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
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(QCMjoueur, gbc);
        QCMQuestion = new JLabel();
        QCMQuestion.setText("Question : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        QCMPanel.add(QCMQuestion, gbc);
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
        gbc.gridwidth = 2;
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
        reponse1 = new JButton();
        reponse1.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        QCMPanel.add(reponse1, gbc);
        reponse2 = new JButton();
        reponse2.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        QCMPanel.add(reponse2, gbc);
        reponse3 = new JButton();
        reponse3.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        QCMPanel.add(reponse3, gbc);
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
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(RCjoueur, gbc);
        RCQuestion = new JLabel();
        RCQuestion.setText("Question");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(RCQuestion, gbc);
        RCreponse = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        RCPanel.add(RCreponse, gbc);
        RCValider = new JButton();
        RCValider.setText("Valider");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        RCPanel.add(RCValider, gbc);
        RCTheme = new JLabel();
        RCTheme.setText("Theme");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(RCTheme, gbc);
        RCNiveau = new JLabel();
        RCNiveau.setText("Niveau");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(RCNiveau, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("Joueur : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(label5, gbc);
        final JLabel label6 = new JLabel();
        label6.setText("Theme :");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(label6, gbc);
        final JLabel label7 = new JLabel();
        label7.setText("Question : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(label7, gbc);
        final JLabel label8 = new JLabel();
        label8.setText("Niveau : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        RCPanel.add(label8, gbc);
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
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFJoueur, gbc);
        VFVrai = new JButton();
        VFVrai.setText("Vrai");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        VFPanel.add(VFVrai, gbc);
        VFFaux = new JButton();
        VFFaux.setText("Faux");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        VFPanel.add(VFFaux, gbc);
        VFQuestion = new JLabel();
        VFQuestion.setText("Question");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 6;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFQuestion, gbc);
        VFTheme = new JLabel();
        VFTheme.setText("Theme");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFTheme, gbc);
        VFNiveau = new JLabel();
        VFNiveau.setText("Niveau");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFNiveau, gbc);
        final JLabel label9 = new JLabel();
        label9.setText("Joueur :  ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(label9, gbc);
        final JLabel label10 = new JLabel();
        label10.setText("Theme : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(label10, gbc);
        final JLabel label11 = new JLabel();
        label11.setText("Question : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(label11, gbc);
        final JLabel label12 = new JLabel();
        label12.setText("Niveau : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(label12, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        VFPanel.add(spacer1, gbc);
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
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Paneljoueurjouer.add(commencer, gbc);
        Joueurplay = new JLabel();
        Joueurplay.setText("Joueur machin a toi de jouer");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Paneljoueurjouer.add(Joueurplay, gbc);
        final JLabel label13 = new JLabel();
        label13.setText("Joueur qui va jouer :  ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        Paneljoueurjouer.add(label13, gbc);
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
        qcm2 = new QCM("comment va tu?1 ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(1), 1, qcm2);
        listetheme2.AjouterQuestion(q2);
        vf1 = new VF("comment va tu2? ", true);
        q3 = new Question(t.getListThemes().get(2), 1, vf1);
        listetheme3.AjouterQuestion(q3);
        qcm2 = new QCM("comment va tu3? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(3), 1, qcm2);
        listetheme4.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu4? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(4), 1, qcm2);
        listetheme5.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu5? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(5), 1, qcm2);
        listetheme6.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu6? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(6), 1, qcm2);
        listetheme7.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu7? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(7), 1, qcm2);
        listetheme8.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu8? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(8), 1, qcm2);
        listetheme9.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu9? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(8), 1, qcm2);
        listetheme10.AjouterQuestion(q2);
        Collections.shuffle(listetheme1.getListQuestionstheme());//pour m�langer l'ordre des questions du premier theme
        Collections.shuffle(listetheme2.getListQuestionstheme());//pour m�langer l'ordre des questions du deuxieme theme
        Collections.shuffle(listetheme3.getListQuestionstheme());
        Collections.shuffle(listetheme4.getListQuestionstheme());
        Collections.shuffle(listetheme5.getListQuestionstheme());
        Collections.shuffle(listetheme6.getListQuestionstheme());
        Collections.shuffle(listetheme7.getListQuestionstheme());
        Collections.shuffle(listetheme8.getListQuestionstheme());
        Collections.shuffle(listetheme9.getListQuestionstheme());
        Collections.shuffle(listetheme10.getListQuestionstheme());
    }

    public void Question(int theme) {

        switch (theme) {
            case 0:
                listetheme = listetheme1;
                break;
            case 1:
                listetheme = listetheme2;
                break;
            case 2:
                listetheme = listetheme3;
                break;
            case 3:
                listetheme = listetheme4;
                break;
            case 4:
                listetheme = listetheme5;
                break;
            case 5:
                listetheme = listetheme6;
                break;
            case 6:
                listetheme = listetheme7;
                break;
            case 7:
                listetheme = listetheme8;
                break;
            case 8:
                listetheme = listetheme9;
                break;
            case 9:
                listetheme = listetheme10;
                break;
        }

        if (listetheme.getListQuestionstheme().get(0).enonce instanceof QCM) {

            QCMQuestion.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getTexte());
            QCMTheme.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).getTheme());
            QCMjoueur.setText(listjoueur.get(joueurjoue).getNom());
            reponse1.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRep1());
            reponse2.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRep2());
            reponse3.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRep3());
            QCMNiveau.setText(String.valueOf(listetheme1.getListQuestionstheme().get(nbrquestionsurletheme).difficulty));
            f.setContentPane(QCMPanel);
            f.revalidate();

        } else if (listetheme.getListQuestionstheme().get(0).enonce instanceof VF) {

            VFQuestion.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).VFtype().getTexte());
            VFTheme.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).getTheme());
            VFJoueur.setText(listjoueur.get(joueurjoue).getNom());
            VFNiveau.setText(String.valueOf(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).difficulty));
            f.setContentPane(VFPanel);
            f.revalidate();

        } else {

            RCQuestion.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).VFtype().getTexte());
            RCTheme.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).getTheme());
            RCjoueur.setText(listjoueur.get(joueurjoue).getNom());
            RCNiveau.setText(String.valueOf(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).difficulty));
            f.setContentPane(RCPanel);
            f.revalidate();

        }
        if (Phase == 1) {
            //nbrquestionsurletheme = nbrquestionsurletheme + 1;
            nbrquestionphase1 = nbrquestionphase1 + 1;
            //if (nbrquestionsurletheme == 4) {
            Theme = Theme + 1;
            if (Theme > 10) {
                Theme = 0;
                // }
            }
        }
    }

    public void preparation() {
        joueurjoue = joueurjoue + 1;
        if (joueurjoue == 4) {
            joueurjoue = 0;
        }
        Joueurplay.setText(listjoueur.get(joueurjoue).getNom());
        f.setContentPane(Paneljoueurjouer);
        f.revalidate();
    }

    public void debut_phase2() {
        joueurpremier.setText(listjoueur.get(joueurjoue).getNom());
        score1.setText(String.valueOf(listjoueur.get(joueurjoue).getScore()));
        f.setContentPane(Score);
        f.revalidate();
    }
}
