import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by Julien on 15/02/2017, 13:39.
 * Package name : PACKAGE_NAME.
 */
public class Copy implements Serializable {
    private boolean borrCopy;
    private GregorianCalendar dateRecep;
    private int idCopy;
    private Book book;
    private Borrow borrow;

    /**
     *
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
    }

    /**
     *
     * @return id Exemplaire
     */
    public int getIdCopy() {
        return idCopy;
    }

    /**
     *
     * @param  b prend un booleen
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

    /**
     *
     * @return
     */
    public Borrow getBorrow() {
        return borrow;
    }

    /**
     *
     * @param borrow
     */
    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    /**
     *
     * @return
     */
    public boolean isBorrCopy() {
        return borrCopy;
    }

    /**
     *
     * @return
     */
    public Book getBook() {
        return book;
    }

    /**
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
}