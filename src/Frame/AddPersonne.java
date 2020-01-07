package Frame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import emi.Adresse;
import emi.Naissance;
import emi.Personne;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddPersonne extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField numeroPorte;
	private JTextField quartier;
	private JTextField commune;
	private JTextField jour;
	private JTextField mois;
	private JTextField annee;
	private JTextField lieu;
	private String storeNom="";
	private String storePrenom="";
	private String storeNumeroPorte="";
	private String storeQuartier="";
	private String storeCommune="";
	private String storeJour="";
	private String storeMois="";
	private String storeAnnee="";
	private String storeLieu="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPersonne frame = new AddPersonne();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddPersonne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*On ajoute un listener qui va exécuter une suite d'insctruction pour ajouter une Personne 
		  avec le clique sur le bouton Ajouter*/
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//On instancie notre BD
				ObjectContainer db = Db4o.openFile(Db4o.newConfiguration(), "C:/Users/dark-/Desktop/BD_Complexes/db.yap");
				
				if(e.getSource()==btnAjouter) {
					//On récupere ce que l'utilisateur a saisit dans les champs de saisie  
					storeNom = nom.getText();
					storePrenom = prenom.getText();
					storeNumeroPorte = numeroPorte.getText();
					storeQuartier = quartier.getText();
					storeCommune = commune.getText();
					storeJour = jour.getText();
					storeMois = mois.getText();
					storeAnnee = annee.getText();
					storeLieu = lieu.getText();
					try {
					//On instancie un objet de type Personne, Naissance et Adresse avec les informations saisit par l'utilisateur
					Personne p = new Personne(storeNom,storePrenom);
					Naissance n = new Naissance(storeJour, storeMois, storeAnnee, storeLieu);
					Adresse a = new Adresse(storeNumeroPorte, storeQuartier, storeCommune);
					//On lie l'objet declaré avec les champs Naissance et Adresse avec les setters declarés dans la classe Personne
					p.setNaissance(n);
					p.setAdresse(a);
					//Ici on persiste nos 3 données dans la BD
					db.store(p);
					db.store(n);
					db.store(a);
					
					}
					finally {
						//On ferme l'instance de notre BD pour effectuer l'ajout avec succès
						db.close();
						//Puis on affiche un message qui montre que l'ajout s'est bien effectué
						System.out.println("Ajout a la base de donnees avec succes");
						//Ensuite on ferme l'interface
						System.exit(0);
					}
					
				}
			}
		});
		
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAjouter.setBounds(171, 401, 126, 27);
		contentPane.add(btnAjouter);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(52, 45, 56, 16);
		contentPane.add(lblNom);
		
		JLabel label = new JLabel("Prenom :");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(52, 80, 77, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Quartier :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(52, 150, 90, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("N\u00B0 de porte :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(52, 115, 90, 16);
		contentPane.add(label_2);
		
		nom = new JTextField();
		nom.setBounds(201, 43, 116, 22);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(201, 80, 116, 22);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		JLabel label_3 = new JLabel("Commune :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(52, 185, 90, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Jour :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(52, 220, 90, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Mois :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(52, 255, 90, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Ann\u00E9e :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(52, 290, 90, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Lieu :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(52, 325, 90, 16);
		contentPane.add(label_7);
		
		numeroPorte = new JTextField();
		numeroPorte.setColumns(10);
		numeroPorte.setBounds(201, 113, 116, 22);
		contentPane.add(numeroPorte);
		
		quartier = new JTextField();
		quartier.setColumns(10);
		quartier.setBounds(201, 148, 116, 22);
		contentPane.add(quartier);
		
		commune = new JTextField();
		commune.setColumns(10);
		commune.setBounds(201, 183, 116, 22);
		contentPane.add(commune);
		
		jour = new JTextField();
		jour.setColumns(10);
		jour.setBounds(201, 218, 116, 22);
		contentPane.add(jour);
		
		mois = new JTextField();
		mois.setColumns(10);
		mois.setBounds(201, 253, 116, 22);
		contentPane.add(mois);
		
		annee = new JTextField();
		annee.setColumns(10);
		annee.setBounds(201, 288, 116, 22);
		contentPane.add(annee);
		
		lieu = new JTextField();
		lieu.setColumns(10);
		lieu.setBounds(201, 323, 116, 22);
		contentPane.add(lieu);
	}
}
