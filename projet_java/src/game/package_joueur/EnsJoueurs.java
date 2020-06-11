package game.package_joueur;


import java.util.Random;
import java.util.Vector;

public class EnsJoueurs {
    private Vector<Joueur> vectorJoueurs;

    public EnsJoueurs(){
        vectorJoueurs = new Vector<>(20);
    }

    public void Afficher(){
        for(Joueur joueur : vectorJoueurs)
            System.out.println(joueur.toString());
    }

    public Vector<Joueur> getVectorJoueurs() { return vectorJoueurs; }
    public void setVectorJoueurs(Vector<Joueur> vectorJoueurs){
        this.vectorJoueurs = vectorJoueurs;
    }
    public void removeJoueur(int num){
        for(int i=0;i<vectorJoueurs.size();i++){
            if(vectorJoueurs.get(i).getNumero() == num){
                vectorJoueurs.remove(i);
            }
        }
    }

    public Joueur SelectionnerJoueur(){
        Random random = new Random();
        return vectorJoueurs.get(random.nextInt(vectorJoueurs.size()));
    }

    public void add(Joueur j) {
        vectorJoueurs.add(j);

    }
}