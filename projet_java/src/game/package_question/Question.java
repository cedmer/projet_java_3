package game.package_question;

public class Question<T> {



    int numero;
    private String theme;
	private int difficulty;
	private T enonce;

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
	

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public T getenonce() {
        return enonce;
    }

    public void setenonce(T enonce) {
        this.enonce = enonce;
    }

	@Override
	public String toString() {
		return enonce.toString();
	}
}
