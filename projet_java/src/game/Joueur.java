package game;

public class Joueur {
    private static int incr = 100;
    private int numero, score;
    private String nom, etat;

    public Joueur(){
        numero = incr;
        Joueur.incr +=10;
        
        this.score = 0;
        this.etat = "en attente";
    }
    

    public int getScore() { return score; }
    public int getNumero() { return numero; }
    public String getEtat() { return etat; }
    public String getNom() { return nom; }

    @Override
    public String toString() {
        return "\nJoueur numero : " + numero + "\nScore : " + score + "\nNom : " + nom;
    }

    public void changerEtat(String etat){ this.etat = etat; }
    public void MAJScore(int points){ this.score += points; }
    public void Saisir(String nom){ this.nom = nom; }
}