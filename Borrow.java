import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Julien on 06/03/2017, 11:00.
 * Package name : Borrow.
 *
 * @author Julien
 */
public class Borrow implements Serializable {

    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------
    private Reader reader;
    private Copy copy;
    private GregorianCalendar dateRelease;

    // -----------------------------------------------
    //Constructeur
    // -----------------------------------------------

    /**
     * Crée un emprunt
     *
     * @param reader
     * @param copy
     * @param dateRelease
     */
    public Borrow(Reader reader, Copy copy, GregorianCalendar dateRelease) {
        this.reader = reader;
        this.copy = copy;
        this.dateRelease = dateRelease;
    }

// -----------------------------------------------
// Public
// -----------------------------------------------

    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------

    /**
     * Suprime un emprunt,
     */
    public void removeBorrow(){
        this.getReader().removeBorrow(this);
        this.getCopy().setBorrow(null);
        this.setReader(null);
        this.setCopy(null);
    }

    /**
     * Affiche les information relative a l'emprunt
     * @return
     */
    public String display() {
        return  reader.getfName()                   + "\t" +
                reader.getlName()                + "\t" +
                this.copy.getBook().getNumISBN()  + "\t" +
                this.copy.getBook().getTitle()    + "\t" +
                this.copy.getIdCopy()             + "\t" +
                EntreesSorties.ecrireDate(dateRelease) + "\t" +
                EntreesSorties.ecrireDate(getDateReturn());
    }

    /**
     * Affiche les information détaillé de l'emprunt
     */
    public void displayAll(){
        EntreesSorties.afficherMessage("Lecteur             : " + reader.getAllName());
        EntreesSorties.afficherMessage("Num Lecteur         : " + reader.getNumReader());
        EntreesSorties.afficherMessage("Num ISBN            : " + copy.getBook().getNumISBN());
        EntreesSorties.afficherMessage("Titre               : " + copy.getBook().getTitle() );
        EntreesSorties.afficherMessage("Numero d'exemplaire : " + copy.getIdCopy() );
        System.out.print("\n");
        EntreesSorties.afficherMessage("Date d'emprunt      : " + EntreesSorties.ecrireDate(dateRelease) );
        EntreesSorties.afficherMessage("Date de retour      : " + EntreesSorties.ecrireDate(getDateReturn()));
        EntreesSorties.afficherMessage("\n\n");
    }

    // -----------------------------------------------
    //Getters
    // -----------------------------------------------

    /**
     * Retourne la date a laquelle l'emprunt devra être rendu
     * @return
     */
    public GregorianCalendar getDateReturn(){
        GregorianCalendar dateReturn = (GregorianCalendar) dateRelease.clone();
        dateReturn.add(Calendar.DATE, 8);
        return dateReturn;
    }



// -----------------------------------------------
// Private
// -----------------------------------------------
    // -----------------------------------------------
    //Setters
    // -----------------------------------------------

    /**
     * Lie un lecteur a l'emprunt
     * @param reader
     */
    private void setReader(Reader reader) {
        this.reader = reader;
    }

    /**
     * Lie un exemplaire a un ouvrage
     * @param copy
     */
    private void setCopy(Copy copy) {
        this.copy = copy;
    }

    // -----------------------------------------------
    //Getters
    // -----------------------------------------------

    /**
     * Retourne le lecteur a qui apartient cet emprunt
     * @return
     */
    private Reader getReader() {
        return reader;
    }

    /**
     * Retourne l'exemplaire emprunté
     * @return
     */
    private Copy getCopy() {
        return copy;
    }




}