package game;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    private JComboBox theme1;
    private JComboBox theme2;
    private JButton Choisir;
    private JButton reponse1;
    private JLabel joueur;
    private QCM qcm1;
    private Question q1;
    private QCM qcm2;
    private Question q2;
    private VF vf1;
    private Question q3;
    private JFrame f = new JFrame("jeu");
    private JFrame frame = new JFrame();

    private ListeQuestions listetheme = new ListeQuestions();
    private ListeQuestions listetheme1phase1 = new ListeQuestions();
    private ListeQuestions listetheme2phase1 = new ListeQuestions();
    private ListeQuestions listetheme3phase1 = new ListeQuestions();
    private ListeQuestions listetheme4phase1 = new ListeQuestions();
    private ListeQuestions listetheme5phase1 = new ListeQuestions();
    private ListeQuestions listetheme6phase1 = new ListeQuestions();
    private ListeQuestions listetheme7phase1 = new ListeQuestions();
    private ListeQuestions listetheme8phase1 = new ListeQuestions();
    private ListeQuestions listetheme9phase1 = new ListeQuestions();
    private ListeQuestions listetheme10phase1 = new ListeQuestions();
    private ListeQuestions listetheme1phase2 = new ListeQuestions();
    private ListeQuestions listetheme2phase2 = new ListeQuestions();
    private ListeQuestions listetheme3phase2 = new ListeQuestions();
    private ListeQuestions listetheme4phase2 = new ListeQuestions();
    private ListeQuestions listetheme5phase2 = new ListeQuestions();
    private ListeQuestions listetheme6phase2 = new ListeQuestions();
    private ListeQuestions listetheme7phase2 = new ListeQuestions();
    private ListeQuestions listetheme8phase2 = new ListeQuestions();
    private ListeQuestions listetheme9phase2 = new ListeQuestions();
    private ListeQuestions listetheme10phase2 = new ListeQuestions();
    private int nbrquestionphase1 = 0;
    private int nbrquestionphase2 = 0;
    private int nbrquestionsurletheme = 0;
    private int Theme;
    private int joueurjoue;
    private EnsJoueurs J = new EnsJoueurs();
    private Themes t = new Themes();
    private ArrayList<Joueur> listjoueur = new ArrayList<Joueur>();
    private ArrayList<Joueur> lisjoueurelimine = new ArrayList<>();
    private ArrayList<Integer> listsixTheme = new ArrayList<>();
    private ArrayList<Integer> listthemechoisi = new ArrayList<>();
    private int Phase = 0;
    private int nbrthemechoisi = 0;

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
                    Questionphase1(Theme);

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
                } else if (Phase == 2) {
                    if (nbrquestionphase2 == 6) {
                        debut_phase3();
                        Phase = 3;
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
                } else if (Phase == 2) {
                    if (nbrquestionphase2 == 6) {
                        debut_phase3();
                        Phase = 3;
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
                } else if (Phase == 2) {
                    if (nbrquestionphase2 == 6) {
                        debut_phase3();
                        Phase = 3;
                    } else {
                        preparation();
                    }
                }

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
                if (Phase == 1) {
                    if (nbrquestionphase1 == 16) {
                        debut_phase2();
                        Phase = 2;
                    } else {
                        preparation();
                    }
                } else if (Phase == 2) {
                    if (nbrquestionphase2 == 6) {
                        debut_phase3();
                        Phase = 3;
                    } else {
                        preparation();
                    }
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
                if (Phase == 1) {
                    if (nbrquestionphase1 == 16) {
                        debut_phase2();
                        Phase = 2;
                    } else {
                        preparation();
                    }
                } else if (Phase == 2) {
                    if (nbrquestionphase2 == 6) {
                        debut_phase3();
                        Phase = 3;
                    } else {
                        preparation();
                    }
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
                if (Phase == 1) {
                    if (nbrquestionphase1 == 16) {
                        debut_phase2();
                        Phase = 2;
                    } else {
                        preparation();
                    }
                } else if (Phase == 2) {
                    if (nbrquestionphase2 == 6) {
                        debut_phase3();
                        Phase = 3;
                    } else {
                        preparation();
                    }
                }
            }
        });

        phaseSuivante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Phase == 2) {
                    for (int i = 0; i < 6; i++) {
                        listsixTheme.add(t.SelectionnerTheme());
                    }
                    for (int j = 0; j < 6; j++) {
                        theme1.addItem(t.getListThemes().get(listsixTheme.get(j)));
                        theme2.addItem(t.getListThemes().get(listsixTheme.get(j)));
                    }
                    Choixthemeparjoueur(2);
                } else if (Phase == 3) {

                }
            }
        });

        commencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Phase == 1) {
                    Questionphase1(Theme);
                } else if (Phase == 2) {
                    Questionphase2();
                }

            }
        });

        Choisir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (theme1.getSelectedItem().equals(theme2.getSelectedItem())) {
                    JOptionPane.showMessageDialog(frame, "Veuiller choisir deux theme differents");
                } else {

                    nbrthemechoisi = nbrthemechoisi + 2;

                    for (int i = 0; i < 9; i++) {
                        if (t.getListThemes().get(i).equals(theme1.getSelectedItem())) {
                            listthemechoisi.add(i);
                            for (int j = 0; j < 5; j++) {
                                if (t.getListThemes().get(listsixTheme.get(j)).equals(theme1.getSelectedItem())) {
                                    System.out.println("test" + theme1.getSelectedItem());
                                    listsixTheme.remove(j);
                                    break;
                                }
                            }
                        }
                    }
                    for (int i = 0; i < 9; i++) {
                        if (t.getListThemes().get(i).equals(theme2.getSelectedItem())) {
                            listthemechoisi.add(i);
                            for (int j = 0; j < 5; j++) {
                                if (t.getListThemes().get(listsixTheme.get(j)).equals(theme2.getSelectedItem())) {
                                    System.out.println("test" + theme2.getSelectedItem());
                                    listsixTheme.remove(j);
                                    break;
                                }
                            }
                        }
                    }
                }
                if (nbrthemechoisi != 6) {
                    if (nbrthemechoisi == 2) {
                        System.out.println("nbr:" + nbrthemechoisi);
                        Choixthemeparjoueur(1);
                    } else if (nbrthemechoisi == 4) {
                        Choixthemeparjoueur(0);
                    } else {
                        Choixthemeparjoueur(2);
                    }
                } else {
                    joueurjoue = 2;
                    preparation();
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
        RCreponse = new JTextArea();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        RCPanel.add(RCreponse, gbc);
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
        gbc.gridwidth = 21;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFJoueur, gbc);
        VFQuestion = new JLabel();
        VFQuestion.setText("Question");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 21;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFQuestion, gbc);
        VFTheme = new JLabel();
        VFTheme.setText("Theme");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 18;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(VFTheme, gbc);
        VFNiveau = new JLabel();
        VFNiveau.setText("Niveau");
        gbc = new GridBagConstraints();
        gbc.gridx = 20;
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
        gbc.gridx = 19;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        VFPanel.add(label12, gbc);
        VFFaux = new JButton();
        VFFaux.setText("Faux");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 3;
        gbc.gridwidth = 14;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        VFPanel.add(VFFaux, gbc);
        VFVrai = new JButton();
        VFVrai.setText("Vrai");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        VFPanel.add(VFVrai, gbc);
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
        Choixthemetitre.setText(" Choisis 2 themes");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(Choixthemetitre, gbc);
        Choisir = new JButton();
        Choisir.setText("Choisir ces themes");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Choixtheme.add(Choisir, gbc);
        theme1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        theme1.setModel(defaultComboBoxModel1);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Choixtheme.add(theme1, gbc);
        theme2 = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Choixtheme.add(theme2, gbc);
        joueur = new JLabel();
        joueur.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(joueur, gbc);
        final JLabel label14 = new JLabel();
        label14.setText("Joueur ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        Choixtheme.add(label14, gbc);
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
        listetheme1phase1.AjouterQuestion(q1);
        qcm2 = new QCM("comment va tu?1 ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(1), 1, qcm2);
        listetheme2phase1.AjouterQuestion(q2);
        vf1 = new VF("comment va tu2? ", true);
        q3 = new Question(t.getListThemes().get(2), 1, vf1);
        listetheme3phase1.AjouterQuestion(q3);
        qcm2 = new QCM("comment va tu3? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(3), 1, qcm2);
        listetheme4phase1.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu4? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(4), 1, qcm2);
        listetheme5phase1.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu5? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(5), 1, qcm2);
        listetheme6phase1.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu6? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(6), 1, qcm2);
        listetheme7phase1.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu7? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(7), 1, qcm2);
        listetheme8phase1.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu8? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(8), 1, qcm2);
        listetheme9phase1.AjouterQuestion(q2);
        qcm2 = new QCM("comment va tu9? ", "bien", "pas bien", "peut-etre", "bien");
        q2 = new Question(t.getListThemes().get(8), 1, qcm2);
        listetheme10phase1.AjouterQuestion(q2);
        Collections.shuffle(listetheme1phase1.getListQuestionstheme());//pour mélanger l'ordre des questions du premier theme
        Collections.shuffle(listetheme2phase1.getListQuestionstheme());//pour mélanger l'ordre des questions du deuxieme theme
        Collections.shuffle(listetheme3phase1.getListQuestionstheme());
        Collections.shuffle(listetheme4phase1.getListQuestionstheme());
        Collections.shuffle(listetheme5phase1.getListQuestionstheme());
        Collections.shuffle(listetheme6phase1.getListQuestionstheme());
        Collections.shuffle(listetheme7phase1.getListQuestionstheme());
        Collections.shuffle(listetheme8phase1.getListQuestionstheme());
        Collections.shuffle(listetheme9phase1.getListQuestionstheme());
        Collections.shuffle(listetheme10phase1.getListQuestionstheme());
    }

    public void Questionphase1(int theme) {

        switch (theme) {
            case 0:
                listetheme = listetheme1phase1;
                break;
            case 1:
                listetheme = listetheme2phase1;
                break;
            case 2:
                listetheme = listetheme3phase1;
                break;
            case 3:
                listetheme = listetheme4phase1;
                break;
            case 4:
                listetheme = listetheme5phase1;
                break;
            case 5:
                listetheme = listetheme6phase1;
                break;
            case 6:
                listetheme = listetheme7phase1;
                break;
            case 7:
                listetheme = listetheme8phase1;
                break;
            case 8:
                listetheme = listetheme9phase1;
                break;
            case 9:
                listetheme = listetheme10phase1;
                break;
        }

        if (listetheme.getListQuestionstheme().get(0).enonce instanceof QCM) {

            QCMQuestion.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getTexte());
            QCMTheme.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).getTheme());
            QCMjoueur.setText(listjoueur.get(joueurjoue).getNom());
            reponse1.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRep1());
            reponse2.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRep2());
            reponse3.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRep3());
            QCMNiveau.setText(String.valueOf(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).difficulty));
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
        //nbrquestionsurletheme = nbrquestionsurletheme + 1;
        nbrquestionphase1 = nbrquestionphase1 + 1;
        //if (nbrquestionsurletheme == 4) {
        Theme = Theme + 1;
        if (Theme > 10) {
            Theme = 0;
            // }
        }

    }

    public void preparation() {
        if (Phase == 1) {
            joueurjoue = joueurjoue + 1;
            if (joueurjoue == 4) {
                joueurjoue = 0;
            }
        } else if (Phase == 2) {
            if (nbrquestionphase2 == 0) {//sécurité pour gérer le premier cas ou c'est la premiere question

            } else {
                if (nbrquestionphase2 % 2 == 0) {
                    joueurjoue = joueurjoue - 1;
                }
                if (joueurjoue == -1) {//sécurité pour eviter de chercher un joueur hors de la liste
                    joueurjoue = 2;
                }
            }


        }

        Joueurplay.setText(listjoueur.get(joueurjoue).getNom());
        f.setContentPane(Paneljoueurjouer);
        f.revalidate();
    }

    public void debut_phase2() {
        Collections.sort(listjoueur, new Comparator<Joueur>() {//on compare les score
            @Override
            public int compare(Joueur j1, Joueur j2) {

                return Integer.compare(j1.getScore(), j2.getScore());
            }
        });
        joueurpremier.setText(listjoueur.get(3).getNom());//on affiche le premier qui est a la fin de la liste
        score1.setText(String.valueOf(listjoueur.get(3).getScore()));
        joueurdeuxieme.setText(listjoueur.get(2).getNom());
        score2.setText(String.valueOf(listjoueur.get(2).getScore()));
        joueurtroisieme.setText(listjoueur.get(1).getNom());
        score3.setText(String.valueOf(listjoueur.get(1).getScore()));
        joueurdernier.setText(listjoueur.get(0).getNom());
        score4.setText(String.valueOf(listjoueur.get(0).getScore()));
        f.setContentPane(Score);
        f.revalidate();
        listjoueur.get(0).changerEtat("elimine");//on change son statut
        lisjoueurelimine.add(listjoueur.get(0));//on l'ajoute dans la liste des elimine
        listjoueur.remove(0);//on le supprime de la liste de joueur
    }

    public void Choixthemeparjoueur(int i) {
        if (i == 1) {
            theme1.removeAllItems();
            theme2.removeAllItems();
            for (int j = 0; j < 4; j++) {
                theme1.addItem(t.getListThemes().get(listsixTheme.get(j)));
                theme2.addItem(t.getListThemes().get(listsixTheme.get(j)));
            }
        } else if (i == 0) {
            theme1.removeAllItems();
            theme2.removeAllItems();
            for (int j = 0; j < 2; j++) {
                theme1.addItem(t.getListThemes().get(listsixTheme.get(j)));
                theme2.addItem(t.getListThemes().get(listsixTheme.get(j)));
            }
        }
        joueur.setText(listjoueur.get(i).getNom());
        f.setContentPane(Choixtheme);
        f.revalidate();
    }

    public void Questionphase2() {
        switch (listthemechoisi.get(nbrquestionphase2)) {
            case 0:
                listetheme = listetheme1phase1;
                break;
            case 1:
                listetheme = listetheme2phase1;
                break;
            case 2:
                listetheme = listetheme3phase1;
                break;
            case 3:
                listetheme = listetheme4phase1;
                break;
            case 4:
                listetheme = listetheme5phase1;
                break;
            case 5:
                listetheme = listetheme6phase1;
                break;
            case 6:
                listetheme = listetheme7phase1;
                break;
            case 7:
                listetheme = listetheme8phase1;
                break;
            case 8:
                listetheme = listetheme9phase1;
                break;
            case 9:
                listetheme = listetheme10phase1;
                break;
        }
        //listthemechoisi;
        if (listetheme.getListQuestionstheme().get(0).enonce instanceof QCM) {

            QCMQuestion.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getTexte());
            QCMTheme.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).getTheme());
            QCMjoueur.setText(listjoueur.get(joueurjoue).getNom());
            reponse1.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRep1());
            reponse2.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRep2());
            reponse3.setText(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).QCMtype().getRep3());
            QCMNiveau.setText(String.valueOf(listetheme.getListQuestionstheme().get(nbrquestionsurletheme).difficulty));
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
        nbrquestionphase2 = nbrquestionphase2 + 1;
    }

    public void debut_phase3() {
        Collections.sort(listjoueur, new Comparator<Joueur>() {//on compare les score
            @Override
            public int compare(Joueur j1, Joueur j2) {

                return Integer.compare(j1.getScore(), j2.getScore());
            }
        });
        joueurpremier.setText(listjoueur.get(2).getNom());//on affiche le premier qui est a la fin de la liste
        score1.setText(String.valueOf(listjoueur.get(2).getScore()));
        joueurdeuxieme.setText(listjoueur.get(1).getNom());
        score2.setText(String.valueOf(listjoueur.get(1).getScore()));
        joueurtroisieme.setText(listjoueur.get(0).getNom());
        score3.setText(String.valueOf(listjoueur.get(0).getScore()));
        joueurdernier.setText("");
        score4.setText("");
        f.setContentPane(Score);
        f.revalidate();
        listjoueur.get(0).changerEtat("elimine");//on change son statut
        lisjoueurelimine.add(listjoueur.get(0));//on l'ajoute dans la liste des elimine
        listjoueur.remove(0);//on le supprime de la liste de joueur
    }


}
