import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


// Classe de gestion de la Bibliotheque

public class Bibliotheque implements Serializable 
{
	
	private static final long serialVersionUID = 262L;

	// -----------------------------------------------
		//Attributs
	// -----------------------------------------------
		private int lastNumReader = 0;
		private HashMap<Integer, Lecteur> _dicoLecteur;
		private HashMap<Integer,Book> _dicoBook;
		
		/*
		 * Le dictionnaire de lecteur permet à bibliotheque de 
		 * garantir l'unicité de ces derniers, et facilitent les recherches et créations.
		 */
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
	

		public Bibliotheque() {
			this.setReader(new HashMap<Integer, Lecteur>());
		
		}
	
// -----------------------------------------------
	// Public
// -----------------------------------------------	
		
		// -----------------------------------------------
			// Mï¿½thodes
		// -----------------------------------------------
	
		/*
		 * La méthode nouveauLecteur permet de créé un lecteur en demandant la saisie de son numéro
		 * nom, prénom, date de naissance, adresse et numéro de téléphone.
		 * L'age doit être compris entre 3 et 110 ans
		 * Le lecteur est identifié par son numéro, si celui ci existe déjà dans le dictionnaire
		 * de bibliothèque, un message d'erreur est affiché.
		 * Une fois le nouveau lecteur créé, il est ajouté au dictionnaire de lecteur
		 * afin de garantir la cohérence des données.
		 */
	public void newReader() {
		Integer numReader = lastNumReader + 1;
		lastNumReader++;
		String nom = EntreesSorties.lireChaine("Entrez le nom :");
		String prenom = EntreesSorties.lireChaine("Entrez le prenom :");
		Integer age;
		GregorianCalendar dateNaiss, dateNaissComp;
		GregorianCalendar dateActuelle = new GregorianCalendar();
		do {
			dateNaiss = EntreesSorties.lireDate("Entrez la date de naissance du lecteur :");
			dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), dateNaiss.get(GregorianCalendar.MONTH), dateNaiss.get(GregorianCalendar.DATE));
			if (dateNaissComp.before(dateActuelle)) {
				age = dateActuelle.get(GregorianCalendar.YEAR) - dateNaiss.get(GregorianCalendar.YEAR);
			} else {
				age = dateActuelle.get(GregorianCalendar.YEAR) - dateNaiss.get(GregorianCalendar.YEAR) - 1;
			}
			if ((age <= 3) | (age >= 110)) {
				EntreesSorties.afficherMessage("Age incorrecte (" + age + "), veuillez recommencer.");
			} else {
				EntreesSorties.afficherMessage("Age du lecteur : " + age + " ans");
			}
		} while ((age <= 3) | (age >= 110));
		String adresse = EntreesSorties.lireChaine("Entrez l'adresse :");
		String tel = EntreesSorties.lireChaine("Entrez le numero de telephone :");
		EntreesSorties.afficherMessage("Fin de saisie, lecteur numéro : " + numReader);

		Lecteur L = new Lecteur(nom, prenom, numReader, dateNaiss, adresse, tel);
		lierLecteur(L, numReader);
	}
		

	
	
	/*
	 * La méthode consulterLecteur permet d'afficher l'ensemble des informations relatives à
	 * un lecteur, par la saisie de son identifiant (numéro de lecteur).
	 * Si le numéro de lecteur n'est pas dans la base de données de bibliotheque un message d'erreur est
	 * renvoyé a l'utilisateur.
	 */
	public void consulterReader()
	{
		Integer numReader = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");
		
		Lecteur L = unLecteur(numReader);
		
		if (L!=null){
			L.printReader();
		}
		else {
			EntreesSorties.afficherMessage("Aucun lecteur n'est associe a ce numero.");
		}
	}

	public void consultBook(){
		int ISBN = EntreesSorties.lireEntier("Entrez l'ISBN :");

	}

	public void newBook(){
		int ISBN = EntreesSorties.lireEntier("Entrez l'ISBN :");
		if(getBook(ISBN) != null){
			String Author = EntreesSorties.lireChaine("Entrez l'autheur :");
            GregorianCalendar DateRelease = EntreesSorties.lireDate("Entrer une date");
			String Editor = EntreesSorties.lireChaine("Entrez l'editeur :");
            int ISBN = EntreesSorties.lireEntier("Entrez l'ISBN :");
			String Title = EntreesSorties.lireChaine("Entrez le Titre :");
			int Public = EntreesSorties.lireEntier("Entrez le Publique 1: ENFANT, 2:ADO, 3:ADULTE:");
            Publiclec p = null;
			switch (Public){
                case 1:{
                    p = p.ADO;
                }
                case 2:{
                    p = p.ENFANT;
                }
                case 3:{
                    p = p.ADULTE;
                }
            }
			setBook(new Book(Author,DateRelease,Editor,ISBN,Title,p),ISBN);

		}
	}

// -----------------------------------------------
	// Private
// -----------------------------------------------
	
	// -----------------------------------------------
		// Setters
	// -----------------------------------------------
	
	private void setReader(HashMap<Integer, Lecteur> dicoLecteur) {
		_dicoLecteur = dicoLecteur;
	}


	
	// -----------------------------------------------
		// Mï¿½thodes
	// -----------------------------------------------
	
	/*
	 * La méthode unLecteur permet de rechercher dans la base de donnée de bibliotheque un objet 
	 * lecteur identifié par son numéro, et de renvoyer l'objet. (ou la donnée null s'il n'est pas trouvé)
	 */
	private Lecteur unLecteur(Integer numReader)
	{
		return _dicoLecteur.get(numReader);
	}
	
	/*
	 * La méthode lierLecteur permet d'ajouter un lecteur a la base de donnée de bibliotheque.
	 */
	private void lierLecteur(Lecteur L, Integer numReader)
	{
		_dicoLecteur.put(numReader, L);
	}
    private void setBook(Book b, Integer ISBN){
        _dicoBook.put(ISBN,b);
    }
	
	
	/*
	 * La méthode lesLecteurs permet de créer un iterator sur les lecteurs, dans le but de les parcourir
	 * pour eventuellement les relancer.
	 */
	private Iterator<Lecteur> lesLecteurs() {
		return _dicoLecteur.values().iterator();
	}

	// -----------------------------------------------
	// Getter
	// -----------------------------------------------
	private Book getBook(int ISBN){
		return _dicoBook.get(ISBN);
	}
}