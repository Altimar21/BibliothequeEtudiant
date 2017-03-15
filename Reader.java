import java.io.Serializable;
import java.util.*;

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
		private Vector<Borrow> borrow;
	
	
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
		
		public Reader(String fName, String lName, Integer numReader, GregorianCalendar dateNaiss, String adress, String tel)
		{
			this.fName = fName;
			this.lName = lName;
			this.numReader = numReader;
			this._dateNaiss = dateNaiss;
			this.adress = adress;
			this.tel = tel;
			borrow = new Vector<>();
		}

// -----------------------------------------------
	// Public
// -----------------------------------------------
		
		// -----------------------------------------------
			//Getters
		// -----------------------------------------------



		public int getNbBorrow(){
		    return borrow.size();
        }

		public String getfName() {
			return fName;
		}

		public String getlName() {
			return lName;
		}

		public int getNumReader() { return numReader; }

    	public Vector<Borrow> getBorrow() {
        return borrow;
    }
        public String getAllName(){
		    return lName + " " + fName.toUpperCase();
        }

    // -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		/*
		 * La méthode afficherLecteur display l'ensemble des informations relatives � un lecteur.
		 */
		public void printReader()
		{

			System.out.println("Numero lecteur : " + numReader);
			System.out.println("Nom et prenom du lecteur: " + getAllName());
			System.out.println("Age : " + this.calculAge() + " ans");
			System.out.println("Adresse : " + adress);
			System.out.println("Telephone : " + tel);
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

		public void removeBorrow(Borrow borrow){
		    this.borrow.remove(borrow);
        }
	
// -----------------------------------------------
	// Private
// -----------------------------------------------

		// -----------------------------------------------
			//Setters
		// -----------------------------------------------



        public void setBorrow(Copy copy){
            borrow.add(new Borrow(this,copy, new GregorianCalendar()));
            copy.setBorrow(this.borrow.lastElement());
        }

        private String printBorrow(){
            String r = "";
            System.out.println(borrow.size());
            for(int i  = 0; i <= borrow.size();i++){
                r = r + borrow.get(i).toString();
            }
            return r;
        }

    public void display() {
        String r = "";
        if(!borrow.isEmpty()) {
            for (Borrow aBorrow : borrow) {
              r = r + aBorrow.display();
            }
        }else{
            r =  "Aucun emprunt";
        }
        System.out.println( "Lecteur : " + "\n" +
                "Prenom    : " + fName + "\n" +
                "Nom       : " + lName + "\n" +
                "Numero    : " + numReader + "\n" +
                "DateNaiss : " + EntreesSorties.ecrireDate(_dateNaiss) + "\n" +
                "Adress    : " + adress + "\n" +
                "Numtel    : " + tel +  "\n" +
                "Emprunt   : " + r + "\n" );

    }
}