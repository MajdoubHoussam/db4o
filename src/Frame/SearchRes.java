package Frame;

//Packages nécessaires pour créer une interface avec SWING
import javax.swing.*;
import java.awt.*;
/*Cette bibliothèque sert à bundle nos boutons avec une tâche donc une suite d'insctructions
  à exécuter*/
import java.awt.event.*;
/*Ces 4 bibliothèques servent à instancier et manipuler une base de données db4o
  La création avec ObjectContainer, Query pour interroger la BD
  ObjectSet qui contient les résultats des requêtes clientes  
 */
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import emi.Personne;

//On implémente l'interface ActionListener pour traiter les clics de souris de l'utilisateur
public class SearchRes extends JFrame implements ActionListener{
	
	//enterName est un attribut de type JLabel du Java Swing qui sert à afficher un texte
	private JLabel enterName;
	//name de type JTextField est une zone d'édition de texte comportant une seule ligne
	//C'est dans cette zone que l'utilisateur va saisir le nom d'une Personne pour intérroger la BD
	private JTextField name;
	//click du type JButton sert à ajouter un bouton pour effecter la recherche
	private JButton click;
	//storeName est un attribut ajouté où l'on stockera le texte saisit par l'utilisateur
	private String storeName="";
	//btnNewButton est un autre bouton qui nous mène vers l'autre interface d'ajout d'une Personne
	private JButton btnNewButton;
	
	public SearchRes() {
		//setSize est une méthode de Swing pour définir les dimensions de notre interface
		setSize(400,430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Ici on définit les dimensions de nos layouts et leurs formats
		enterName = new JLabel("Enter Name :");
		enterName.setBounds(35, 55, 120, 30);
		enterName.setFont(new Font("Arial", Font.BOLD, 14));
		click = new JButton("Search");
		click.setFont(new Font("Tahoma", Font.BOLD, 15));
		click.setBounds(140, 220, 110, 40);
		name = new JTextField();
		name.setBounds(115, 105, 130, 30);
		//Ici on crée des bundle de nos boutons avec l'interface correspondante
		click.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().add(click);
		getContentPane().add(name);
		getContentPane().add(enterName);
		
		//Dans cette partie, on lie le bouton btnNewButton avec l'affichage de notre deuxième interface
		//qui servira à l'ajout d'un objet Personne à notre BD
		btnNewButton = new JButton("Add Personne");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPersonne addPersonne = new AddPersonne();
				addPersonne.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(240, 320, 130, 25);
		getContentPane().add(btnNewButton);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//Cette instruction sert à ouvrir notre BD déjà créée pour l'interroger 
		ObjectContainer db = Db4o.openFile(Db4o.newConfiguration(), "C:/Users/dark-/Desktop/BD_Complexes/db.yap");
		
		//Au click sur le bouton Search, cette zone d'instructions s'exécutera
		if(e.getSource()==click) {
			//On récupere ce que l'utilisateur a saisit dans la variable storeName
			storeName = name.getText();
			//On crée une requête pour intérroger la BD et on spécifie la classe qu'on voudrait consulter, ici Personne
			Query q = db.query();
			q.constrain(Personne.class);
			//La requête consiste à cherche un objet Personne et de retourner un objet qui à le même nom que le texte saisit
			q.descend("nom").constrain(storeName);
			//q.execute() sert à récuperer le résultat de la requête
			ObjectSet result = q.execute();
			/*Après avoir récuperer le resultat de la requête on affiche grâce à la méthode toString() de la classe Personne
			le nom de l'objet trouve s'il éxiste déjà*/
			JOptionPane.showMessageDialog(null, "Hello "+result.toString());
			//Après avoir afficher le message de retour, on ferme l'interface de recherche
			System.exit(0);
		}
		
	}
	
}
