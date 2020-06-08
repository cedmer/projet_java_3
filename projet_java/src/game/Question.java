package game;

public class Question<T> extends fenetre {



    int numéro;
    String theme;
	int difficulty;
	T enonce;

	public Question(String theme, int difficulty , T enonce){

	    this.theme = theme;
	    this.enonce = enonce;
	    this.difficulty = difficulty;

    }
    public QCM QCMtype(){
	    return (QCM)this.enonce;
    }
    public VF VFtype(){
        return (VF)this.enonce;
    }
    public RC RCtype(){
        return (RC)this.enonce;
    }

	public void afficher() {

        System.out.println("Le niveau de la question est de niveau : " + difficulty);
        if(enonce instanceof QCM) {
            ((QCM) enonce).afficherQuestion();
        }
        else if(enonce instanceof VF) {
            ((VF) enonce).afficherQuestion();
        }
        else {
            ((RC) enonce).afficherQuestion();
        }
    }

    public int getNuméro() {
        return numéro;
    }

    public void setNuméro(int numéro) {
        this.numéro = numéro;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public T geténoncé() {
        return enonce;
    }

    public void seténoncé(T énoncé) {
        this.enonce = enonce;
    }
}
