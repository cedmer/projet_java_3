package game.package_question;

public class VF {
    private String texte;
    private boolean rep;

    public VF(String texte, boolean rep) {
        this.texte=texte;
        this.rep=rep;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public boolean isRep() {
        return rep;
    }

    public void setRep(boolean rep) {
        this.rep = rep;
    }

    public void afficherQuestion() {
        System.out.println("La question est : " + getTexte());

    }
    
    @Override
	public String toString() {
		return texte;
	}
}