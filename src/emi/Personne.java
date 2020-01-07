package emi;

public class Personne {

	private String nom;
	private String prenom;
	private Naissance naissance;
	private Adresse adresse;
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Naissance getNaissance() {
		return naissance;
	}

	public void setNaissance(Naissance naissance) {
		this.naissance = naissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return prenom;
	}
	
	
	
}
