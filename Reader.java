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
			this.setNom(fName);
			this.setPrenom(lName);
			this.setNumLecteur(numReader);
			this.setDateNaiss(dateNaiss);
			this.setAdresse(adress);
			this.setTel(tel);
		}

// -----------------------------------------------
	// Public
// -----------------------------------------------
		
		// -----------------------------------------------
			//Getters
		// -----------------------------------------------
	
		public String getNom() {
			return fName;
		}

		public String getPrenom() {
			return lName;
		}

		public Integer getNumLecteur() {
			return numReader;
		}
		
		public GregorianCalendar getDateNaiss() {
			return _dateNaiss;
		}

		public String getAdresse() {
			return adress;
		}

		public String getTel() {
			return tel;
		}
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		/*
		 * La m�thode afficherLecteur affiche l'ensemble des informations relatives � un lecteur.
		 */
		public void printReader()
		{
			System.out.println("Numero lecteur : " + this.getNumLecteur());
			System.out.println("Nom et prenom du lecteur: " + this.getNom() + " " + this.getPrenom());
			System.out.println("Age : " + this.calculAge() + " ans");
			System.out.println("Adresse : " + this.getAdresse());
			System.out.println("Telephone : " + this.getTel());
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

		// -----------------------------------------------
			//Setters
		// -----------------------------------------------

		private void setNom(String fName) {
			this.fName = fName;
		}

		private void setPrenom(String prenom) {
			this.lName = prenom;
		}
		
		private void setNumLecteur(Integer numLecteur) {
			this.numReader = numLecteur;
		}

		private void setDateNaiss(GregorianCalendar dateNaiss) {
			this._dateNaiss = dateNaiss;
		}

		private void setAdresse(String adresse) {
			this.adress = adresse;
		}

		private void setTel(String tel) {
			this.tel = tel;
		}
		
		
}