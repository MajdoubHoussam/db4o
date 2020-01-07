package Frame;

//Packages n�cessaires pour cr�er une interface avec SWING
import javax.swing.*;
import java.awt.*;
/*Cette biblioth�que sert � bundle nos boutons avec une t�che donc une suite d'insctructions
  � ex�cuter*/
import java.awt.event.*;
/*Ces 4 biblioth�ques servent � instancier et manipuler une base de donn�es db4o
  La cr�ation avec ObjectContainer, Query pour interroger la BD
  ObjectSet qui contient les r�sultats des requ�tes clientes  
 */
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import emi.Personne;

//On impl�mente l'interface ActionListener pour traiter les clics de souris de l'utilisateur
public class SearchRes extends JFrame implements ActionListener{
	
	//enterName est un attribut de type JLabel du Java Swing qui sert � afficher un texte
	private JLabel enterName;
	//name de type JTextField est une zone d'�dition de texte comportant une seule ligne
	//C'est dans cette zone que l'utilisateur va saisir le nom d'une Personne pour int�rroger la BD
	private JTextField name;
	//click du type JButton sert � ajouter un bouton pour effecter la recherche
	private JButton click;
	//storeName est un attribut ajout� o� l'on stockera le texte saisit par l'utilisateur
	private String storeName="";
	//btnNewButton est un autre bouton qui nous m�ne vers l'autre interface d'ajout d'une Personne
	private JButton btnNewButton;
	
	public SearchRes() {
		//setSize est une m�thode de Swing pour d�finir les dimensions de notre interface
		setSize(400,430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Ici on d�finit les dimensions de nos layouts et leurs formats
		enterName = new JLabel("Enter Name :");
		enterName.setBounds(35, 55, 120, 30);
		enterName.setFont(new Font("Arial", Font.BOLD, 14));
		click = new JButton("Search");
		click.setFont(new Font("Tahoma", Font.BOLD, 15));
		click.setBounds(140, 220, 110, 40);
		name = new JTextField();
		name.setBounds(115, 105, 130, 30);
		//Ici on cr�e des bundle de nos boutons avec l'interface correspondante
		click.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().add(click);
		getContentPane().add(name);
		getContentPane().add(enterName);
		
		//Dans cette partie, on lie le bouton btnNewButton avec l'affichage de notre deuxi�me interface
		//qui servira � l'ajout d'un objet Personne � notre BD
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
		//Cette instruction sert � ouvrir notre BD d�j� cr��e pour l'interroger 
		ObjectContainer db = Db4o.openFile(Db4o.newConfiguration(), "C:/Users/dark-/Desktop/BD_Complexes/db.yap");
		
		//Au click sur le bouton Search, cette zone d'instructions s'ex�cutera
		if(e.getSource()==click) {
			//On r�cupere ce que l'utilisateur a saisit dans la variable storeName
			storeName = name.getText();
			//On cr�e une requ�te pour int�rroger la BD et on sp�cifie la classe qu'on voudrait consulter, ici Personne
			Query q = db.query();
			q.constrain(Personne.class);
			//La requ�te consiste � cherche un objet Personne et de retourner un objet qui � le m�me nom que le texte saisit
			q.descend("nom").constrain(storeName);
			//q.execute() sert � r�cuperer le r�sultat de la requ�te
			ObjectSet result = q.execute();
			/*Apr�s avoir r�cuperer le resultat de la requ�te on affiche gr�ce � la m�thode toString() de la classe Personne
			le nom de l'objet trouve s'il �xiste d�j�*/
			JOptionPane.showMessageDialog(null, "Hello "+result.toString());
			//Apr�s avoir afficher le message de retour, on ferme l'interface de recherche
			System.exit(0);
		}
		
	}
	
}
