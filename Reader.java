import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;

// Classe de gestion de Reader

public class Reader implements Serializable
{
	
	private static final long serialVersionUID = 422L;
	
	// -----------------------------------------------
		//Attributs
	// -----------------------------------------------
	
		private String fName;
		private String lName;
		private Integer numReader;
		private GregorianCalendar _dateNaiss;
		private String adress;
		private String tel;
	
	
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
		
		public Reader(String fName, String lName, Integer numReader, GregorianCalendar dateNaiss, String adress, String tel)
		{
			this.fName = fName;
			this.lName=lName;
			this.numReader=numReader;
			this._dateNaiss=dateNaiss;
			this.adress=adress;
			this.tel=tel;
		}

// -----------------------------------------------
	// Public
// -----------------------------------------------
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		/*
		 * La m�thode afficherLecteur affiche l'ensemble des informations relatives � un lecteur.
		 */
		public void printReader()
		{
			System.out.println("Numero lecteur : " + this.numReader);
			System.out.println("Nom et prenom du lecteur: " + this.fName + " " + this.lName);
			System.out.println("Age : " + this.calculAge() + " ans");
			System.out.println("Adresse : " + this.adress);
			System.out.println("Telephone : " + this.tel);
			EntreesSorties.afficherMessage("");
		}

		
		/*
		 * la m�thode calculAge permet de d�terminer l'age des lecteurs grace a leur date de naissance
		 * et la date actuelle. De cette fa�on, il n'y a pas de mise a jour a faire sur l'age des lecteurs.
		 */
		public Integer calculAge() {
			Integer age;
			GregorianCalendar dateNaissComp;
			GregorianCalendar dateActuelle = new GregorianCalendar();
			dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), _dateNaiss.get(GregorianCalendar.MONTH), _dateNaiss.get(GregorianCalendar.DATE));
			if(dateNaissComp.before(dateActuelle)){
				age=dateActuelle.get(GregorianCalendar.YEAR)-_dateNaiss.get(GregorianCalendar.YEAR);
			}
			else{
				age=dateActuelle.get(GregorianCalendar.YEAR)-_dateNaiss.get(GregorianCalendar.YEAR)-1;
			}
			return age;
		}
		
	
	
// -----------------------------------------------
	// Private
// -----------------------------------------------
		
		
}