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
		frameAccueil.setVisible(true);
		JLabel labelAhh = new JLabel("Voici les thèmes disponibles : ");
		JLabel labelJeu = new JLabel("Voici les thèmes disponibles :");
		JLabel theme1 = new JLabel("Sciences");
		JLabel theme2 = new JLabel("Sport");
		JLabel theme3 = new JLabel("Histoire");
		JLabel theme4 = new JLabel("Mathematiques");
		JLabel theme5 = new JLabel("Musique");
		JLabel theme6 = new JLabel("Geographie");
		JLabel theme7 = new JLabel("Cuisine");
		JLabel theme8 = new JLabel("Programmation");
		JLabel theme9 = new JLabel("Reseau");
		frameAccueil.add(labelJeu, BorderLayout.NORTH);
		frameAccueil.add(labelAhh);
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
		
		
		frameAccueil.add(panelThemes);
	}
	
}
