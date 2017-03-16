import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by Julien on 15/02/2017, 13:39.
 * Package name : PACKAGE_NAME.
 */
public class Copy implements Serializable {


    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------

    private boolean borrCopy;
    private GregorianCalendar dateRecep;
    private int idCopy;
    private Book book;
    private Borrow borrow;

    // -----------------------------------------------
    //Constructeur
    // -----------------------------------------------

    /**
     * Crée un exemplaire.
     *
     * @param borrCopy boolean
     * @param dateRecep GregorianCalendar
     * @param idCopy iny
     * @param book Book
     */
    public Copy(boolean borrCopy, GregorianCalendar dateRecep, int idCopy, Book book) {
        this.borrCopy = borrCopy;
        this.dateRecep = dateRecep;
        this.idCopy = idCopy;
        this.book = book;

        this.borrow = null;
    }
// -----------------------------------------------
// Public
// -----------------------------------------------


    // -----------------------------------------------
    //Setters
    // -----------------------------------------------

    /**
     * Modifie l'emprunt de cet exemplaire
     *
     * @param borrow
     */
    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    // -----------------------------------------------
    //Getters
    // -----------------------------------------------
    /**
     * Retourne l'identifiant de l'exemplaire
     *
     * @return id Exemplaire
     */
    public int getIdCopy() {
        return idCopy;
    }

    /**
     * Retourne l'emprunt fais sur cet exemplaire
     *
     * @return
     */
    public Borrow getBorrow() {
        return borrow;
    }


    /**
     * Retourne le livre lier a cet exemplaire
     *
     * @return
     */
    public Book getBook() {
        return book;
    }

    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------



    /**
     * Retourne l'etat de l'emprunt de l'exemplaire
     *
     * @return
     */
    public boolean isBorrCopy() {
        return borrCopy;
    }

    /**
     * Retourne les details de l'exemplaire
     *
     * @return
     */
    @Override
    public String toString() {
        return "Detail exemplaire    : " +"\n" +
                "empruntable  : " + BooltoString(borrCopy) + "\n" +
                "dateRecep    : " + EntreesSorties.ecrireDate(dateRecep) +"\n" +
                "idExemplaire : " + idCopy ;
    }


// -----------------------------------------------
// Private
// -----------------------------------------------
    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------

    /**
     * Retourne "Oui" si b = true ou "Non" si b = false
     *
     * @param  b
     * @return retourne le string correspondant au booleen
     */
    private String BooltoString(boolean b){
        if(borrCopy){
            return "Oui";
        }
        else{
            return "Non";
        }
    }
}