package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu {
	//private JFrame frameAccueil;
	//private JPanel panelThemes;
	
	public Menu() {
		//Themes listeThemes = new Themes();
		JFrame frameAccueil = new JFrame();
		JPanel panelThemes = new JPanel();
		panelThemes.setLayout(new GridLayout(5,2));
		frameAccueil.setTitle("Jeu de questions reponses");
		frameAccueil.setSize(400,300);
		frameAccueil.setLocationRelativeTo(null);
		frameAccueil.setVisible(true);
		JLabel labelJeu = new JLabel("Voici les thèmes disponibles :");
		JButton theme1 = new JButton("Sciences");
		theme1.putClientProperty("theme", "Sciences");
		JButton theme2 = new JButton("Sport");
		theme2.putClientProperty("theme", "Sport");
		JButton theme3 = new JButton("Histoire");
		theme3.putClientProperty("theme", "Histoire");
		JButton theme4 = new JButton("Mathematiques");
		theme4.putClientProperty("theme", "Mathematiques");
		JButton theme5 = new JButton("Musique");
		theme5.putClientProperty("theme", "Musique");
		JButton theme6 = new JButton("Geographie");
		theme6.putClientProperty("theme", "Geographie");
		JButton theme7 = new JButton("Cuisine");
		theme7.putClientProperty("theme", "Cuisine");
		JButton theme8 = new JButton("Programmation");
		theme8.putClientProperty("theme", "Programmation");
		JButton theme9 = new JButton("Reseau");
		theme1.putClientProperty("theme", "Reseau");
		frameAccueil.add(labelJeu, BorderLayout.NORTH);
		panelThemes.add(theme1);
		panelThemes.add(theme2);
		panelThemes.add(theme3);
		panelThemes.add(theme4);
		panelThemes.add(theme5);
		panelThemes.add(theme6);
		panelThemes.add(theme7);
		panelThemes.add(theme8);
		panelThemes.add(theme9);
		JButton buttonJouer = new JButton("JOUER");
		frameAccueil.add(buttonJouer, BorderLayout.SOUTH);
		
		buttonJouer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameAccueil.dispose();
		    	fenetre f = new fenetre();
		        f.init();
			}
        });
		
		
		//for(int i = 0; i<=listeThemes.getListThemes().size();i++) {
		//	System.out.println(listeThemes.get(i));
		//}
		
		theme1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	FenetreQuestion f = new FenetreQuestion(String.valueOf(theme1.getClientProperty("theme")));
			}
        });
		
		theme2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	FenetreQuestion f = new FenetreQuestion(String.valueOf(theme2.getClientProperty("theme")));
			}
        });
		
		theme3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	FenetreQuestion f = new FenetreQuestion(String.valueOf(theme3.getClientProperty("theme")));
			}
        });
		
		theme4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	FenetreQuestion f = new FenetreQuestion(String.valueOf(theme4.getClientProperty("theme")));
			}
        });
		
		theme5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	FenetreQuestion f = new FenetreQuestion(String.valueOf(theme5.getClientProperty("theme")));
			}
        });
		
		theme6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	FenetreQuestion f = new FenetreQuestion(String.valueOf(theme6.getClientProperty("theme")));
			}
        });
		
		theme7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	FenetreQuestion f = new FenetreQuestion(String.valueOf(theme7.getClientProperty("theme")));
			}
        });
		
		theme8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	FenetreQuestion f = new FenetreQuestion(String.valueOf(theme8.getClientProperty("theme")));
			}
        });
		
		theme9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	FenetreQuestion f = new FenetreQuestion(String.valueOf(theme9.getClientProperty("theme")));
			}
        });
		
		
		frameAccueil.add(panelThemes);
	}
	
}
