package emi;

public class Naissance {

	private String jour;
	private String mois;
	private String annee;
	private String lieu;
	
	public Naissance(String jour, String mois, String annee, String lieu) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
		this.lieu = lieu;
	}

	public Naissance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	@Override
	public String toString() {
		return "Naissance [jour=" + jour + ", mois=" + mois + ", annee=" + annee + ", lieu=" + lieu + "]";
	}
	
	
	
}
