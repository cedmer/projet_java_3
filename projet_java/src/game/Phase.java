package game;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;


public interface Phase {
    
    //public static ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    
    public static int numeroPhase = 0;

    public static int PhasedeJeu() {return numeroPhase; }
    
    public static void SelectionnerJoueurs(EnsJoueurs joueurs){
    	joueurs.SelectionnerJoueur();
    }
    
    
}