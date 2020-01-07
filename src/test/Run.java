package test;


import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import emi.Adresse;
import emi.Naissance;
import emi.Personne;

public class Run {

	public static void main(String args[]) {
		//Cette m�thode sert � la fois de cr�er la base de donn�es ainsi que de l�initialiser pour stocker les donn�es.
		ObjectContainer db = Db4o.openFile(Db4o.newConfiguration(), "C:/Users/dark-/Desktop/BD_Complexes/db.yap");
		try {
			
			//On instancie un objet de type Personne et on l'associe avec Naissance et Adresse avec les m�thodes setNaissance et setAdresse
			Personne p1 = new Personne("NOM","Prenom");
			Naissance n1 = new Naissance("07","03","1995","Rue1");
			Adresse a1 = new Adresse("1", "Quart1", "Commune1");
			p1.setNaissance(n1);
			p1.setAdresse(a1);
			//On stocke nos donn�es(Ici l'objet Personne, Naissance et Adresse) dans la BD initialis�e
			db.store(n1);
			db.store(a1);
			db.store(p1);
			
		}finally {
			//On ferme l'instance de la BD pour faire la persistance des donn�es
			db.close();
			System.out.println("Base de donnees cree");
		}
		
	}
	
}
