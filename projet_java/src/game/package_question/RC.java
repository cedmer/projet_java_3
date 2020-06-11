package game;

public class RC {
    private String texte;
    private String rep;

    public RC(String texte, String rep) {
        this.texte=texte;
        this.rep=rep;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String isRep() {
        return rep;
    }

    public void setRep(String rep) {
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

