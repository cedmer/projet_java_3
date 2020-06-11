package game.package_question;

public class QCM {
    private String texte;
    private String rep1;
    private String rep2;
    private String rep3;
    private String repV;


    public QCM(String texte, String rep1, String rep2, String rep3, String repV) {
		super();
		this.texte = texte;
		this.rep1 = rep1;
		this.rep2 = rep2;
		this.rep3 = rep3;
		this.repV = repV;
	}

	public String getTexte() {return texte;}
    public void setTexte(String texte) {this.texte = texte;}
    public String getRep1() {return rep1;}
	public void setRep1(String rep1) {this.rep1 = rep1;}
	public String getRep2() {return rep2;}
	public void setRep2(String rep2) {this.rep2 = rep2;}
	public String getRep3() {return rep3;}
	public void setRep3(String rep3) {this.rep3 = rep3;}
	public String getRepV() {return repV;}
	public void setRepV(String repV) {this.repV = repV;}

	public void afficherQuestion() {

    	System.out.println("La question est : " + getTexte());
    }

	@Override
	public String toString() {
		return texte;
	}
}
