package emi;

public class Adresse {

	private String numeroPorte;
	private String quartier;
	private String commune;
	
	public Adresse(String numeroPorte, String quartier, String commune) {
		super();
		this.numeroPorte = numeroPorte;
		this.quartier = quartier;
		this.commune = commune;
	}

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumeroPorte() {
		return numeroPorte;
	}

	public void setNumeroPorte(String numeroPorte) {
		this.numeroPorte = numeroPorte;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	@Override
	public String toString() {
		return "Adresse [numeroPorte=" + numeroPorte + ", quartier=" + quartier + ", commune=" + commune + "]";
	}
	
	
	
	
}
