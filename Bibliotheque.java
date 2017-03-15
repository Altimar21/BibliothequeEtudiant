import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;


// Classe de gestion de la Bibliotheque

public class Bibliotheque implements Serializable 
{
	
	private static final long serialVersionUID = 262L;

	// -----------------------------------------------
		//Attributs
	// -----------------------------------------------
		private int lastNumReader = 0;
		private HashMap<Integer, Reader> _dicoLecteur;
		private HashMap<Integer, Book> _dicoBook;
		/*
		 * Le dictionnaire de lecteur permet à bibliotheque de 
		 * garantir l'unicité de ces derniers, et facilitent les recherches et créations.
		 */
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
	

		public Bibliotheque() {
			this.setReader(new HashMap<Integer, Reader>());
            this.setHashBook(new HashMap<Integer, Book>());
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

		Reader L = new Reader(nom, prenom, numReader, dateNaiss, adresse, tel);
		setReader(L, numReader);
	}

	public void newCopy (){
		int ISBN = EntreesSorties.lireEntier("Entrez l'ISBN du livre :");
		Book B = getBook(ISBN);
		if(B!=null)
		{
		//	B.toString();
			GregorianCalendar dateRecep = EntreesSorties.lireDate("Entrez la date de reception :");
			boolean emprunt;
			int empruntable = EntreesSorties.lireEntier("L'exemplaire est il empruntable ? (0 :Non 1: Oui) :");
			if (empruntable==1)
			{
				emprunt = true;
			}
			else{
				emprunt = false;
			}
			B.addCopy(emprunt, dateRecep);
		}else{
		    System.out.println("Le livre n'existe pas");
        }
	}



	/*
	 * La méthode consulterLecteur permet d'afficher l'ensemble des informations relatives à
	 * un lecteur, par la saisie de son identifiant (numéro de lecteur).
	 * Si le numéro de lecteur n'est pas dans la base de données de bibliotheque un message d'erreur est
	 * renvoyé a l'utilisateur.
	 */
	public void consultReader()
	{
		Integer numReader = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");

		Reader L = getReader(numReader);

		if (L!=null){
			L.display();
		}
		else {
			EntreesSorties.afficherMessage("Aucun lecteur n'est associé a ce numero.");
		}
	}

	public void consultBook(){
		int ISBN = EntreesSorties.lireEntier("Entrez l'ISBN :");
        Book b = getBook(ISBN);
		if(b != null){
		    b.display();
        }else{
		    System.out.println("Le Livre n'existe pas");
        }
	}

	public void newBook(){
		Integer ISBN = EntreesSorties.lireEntier("Entrez l'ISBN :");
        Book B = getBook(ISBN);
		if(B==null){
			String Author = EntreesSorties.lireChaine("Entrez l'auteur :");
            GregorianCalendar DateRelease = EntreesSorties.lireDate("Entrez une date :");
			String Editor = EntreesSorties.lireChaine("Entrez l'editeur :");
			String Title = EntreesSorties.lireChaine("Entrez le titre :");
			int Public = EntreesSorties.lireEntier("Entrez le Publique 1:ENFANT, 2:ADO, 3:ADULTE:");
            Publiclec p = null;
			switch (Public){
                case 1:
                    p = Publiclec.ENFANT;
                    break;
                case 2:
                    p = Publiclec.ADO;
                    break;
                case 3:
                    p = Publiclec.ADULTE;
                    break;
            }
			setBook(new Book(Author,DateRelease,Editor,ISBN,Title,p),ISBN);
            _dicoBook.get(ISBN).display();
		}else{
            System.out.println("Le Livre existe déjà");
        }
	}

	public void consultCopyBook(){
        int ISBN = EntreesSorties.lireEntier("Entrez l'ISBN :");
        Book b = getBook(ISBN);
        if (b == null) {
            System.out.println("Le Livre avec l'isbn " + ISBN + "n'existe pas");
            return;
        }

        int idCopy = EntreesSorties.lireEntier("Entrez l'idCopy :");

        if(b.getCopy()){
            System.out.println("Aucun exemplaire n'est enregistré pour ce livre");
            return;
        }

        if(b.getCopy(idCopy) == null){
            System.out.println("Ce numero d'exemplaire n'existe pas");
            return;
        }
        b.PrintCopy(idCopy);
    }

    public void BorrCopy() {
        Integer NumReader = EntreesSorties.lireEntier("Entrer le numero du lecteur :");
        Reader reader = getReader(NumReader);


        if (reader == null) {
            System.out.println("Le lecteur n'existe pas");
            return;
        }

        int ISBN = EntreesSorties.lireEntier("Entrez le numero ISBN :");
        Book book = getBook(ISBN);

        if (book == null) {
            System.out.println("Le livre n'existe pas");
            return;
        }

        if (book.getCopy()) {
            System.out.println("Pas d'exemplaire de ce livre en stock");
            return;
        }

        if (book.nbBorrCopy() == 0) {
            System.out.println("Pas d'exemplaire empruntable");
            return;
        }

        if (reader.getNbBorrow() > 5) {
                System.out.println("Vous avez emprunté la maximum de livre (5)");
               return;
        }

        Publiclec publicc = book.getPublicc();

        if (publicc == Publiclec.ADULTE && reader.calculAge() < 16) {
            System.out.println("Il faut être adulte pour emprunter ce livre");
            return;
        }

        if (publicc == Publiclec.ADO && reader.calculAge() < 10) {
            System.out.println("Il faut être ado pour emprunter ce livre");
            return;
        }

        reader.setBorrow(book.getCopy(book.getfirstBorrCoppy()));
        EntreesSorties.afficherMessage("Exemplaire du livre " + ISBN + " emprunté");
    }

    public void returnCopy(){
        Integer NumReader = EntreesSorties.lireEntier("Entrez le numero du lecteur :");
        Reader reader = getReader(NumReader);


        if(reader == null) {
            System.out.println("Le lecteur n'existe pas");
            return;
        }

        int ISBN = EntreesSorties.lireEntier("Entrez numero ISBN :");
        Book book = getBook(ISBN);
        if(book == null) {
            System.out.println("Le livre n'existe pas");
            return;
        }
        int idCopy = EntreesSorties.lireEntier("Numéro d'exemplaire : ");
        Copy copy = book.getCopy(idCopy);
        if (copy == null){
            EntreesSorties.afficherMessage("L'exemplaire numero" + idCopy + " n'existe pas");
            return;
        }
        Borrow borrow = copy.getBorrow();

        if (borrow == null) {
            EntreesSorties.afficherMessage("L'exemplaire numero" + idCopy + " n'est pas emprunté");
            return;
        }

        borrow.removeBorrow();
        EntreesSorties.afficherMessage("Exemplaire rendu");
    }

    public void consultBorrowReader(){
        int numReader = EntreesSorties.lireEntier("Numéro de lecteur : ");
        Reader reader = getReader(numReader);
        if (reader == null){
            System.out.println("Le numero "+ numReader + "ne correspond a aucun lecteur connu");
            return;
        }

        if(reader.getNbBorrow() == 0){
            System.out.println("Aucun emprunt effectué par ce lecteur");
            return;
        }
        for (Borrow b : reader.getBorrow()){
           System.out.println(b.display());
        }
    }

    public void askReader(){
        for (Reader r : _dicoLecteur.values()) {
            if (r.getNbBorrow() != 0) {
                for (Borrow b : r.getBorrow()) {
                    GregorianCalendar now = new GregorianCalendar();
                    GregorianCalendar datereturn = b.getDateReturn();
                    datereturn.add(GregorianCalendar.DAY_OF_MONTH, 8);
                    if (datereturn.before(now)) {
                        EntreesSorties.ecrireDate(datereturn);
                        b.display();
                    }
                }
            }
        }
    }

    public void consultListBook(){
        for (Book b : _dicoBook.values()) {
            EntreesSorties.afficherMessage("Livre  " + b.getTitle() + " : \tIsbn " + b.getNumISBN());
        }
    }

    public void consultListBorrow(){
        for (Reader r : _dicoLecteur.values()) {
            if (r.getNbBorrow() != 0) {
                for (Borrow b : r.getBorrow()) {
                    b.displayAll();
                }
            }
        }
    }
    public void consultListReader(){
        for (Reader r : _dicoLecteur.values()) {
            EntreesSorties.afficherMessage("Lecteur " + r.getNumReader() +":"+ "\t" + r.getAllName());
        }
    }

    /*
    public void consultListCopy(){
        int ISBN = EntreesSorties.lireEntier("Enter numero ISBN :");
        Book book = getBook(ISBN);

        if (book == null) {
            System.out.println("Le livre n'existe pas");
            return;
        }

        for (int i =0; i <  book.getNbCopy() ;i++){

        }
    }*/

// -----------------------------------------------
	// Private
// -----------------------------------------------

	// -----------------------------------------------
		// Setters
	// -----------------------------------------------

	private void setReader(HashMap<Integer, Reader> dicoLecteur) {
		_dicoLecteur = dicoLecteur;
	}
    private void setHashBook(HashMap<Integer, Book> dicoBook){
	    _dicoBook = dicoBook;
    }


	// -----------------------------------------------
		// Mï¿½thodes
	// -----------------------------------------------

	/*
	 * La méthode unLecteur permet de rechercher dans la base de donnée de bibliotheque un objet
	 * lecteur identifié par son numéro, et de renvoyer l'objet. (ou la donnée null s'il n'est pas trouvé)
	 */
	/*
	 * La méthode setReader permet d'ajouter un lecteur a la base de donnée de bibliotheque.
	 */
	private void setReader(Reader L, Integer numReader)
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
	private Iterator<Reader> lesLecteurs() {
		return _dicoLecteur.values().iterator();
	}

	// -----------------------------------------------
	// Getter
	// -----------------------------------------------
	private Book getBook(Integer ISBN){
		return _dicoBook.get(ISBN);
	}

	private Reader getReader(Integer NumReader){
	    return _dicoLecteur.get(NumReader);
    }
}