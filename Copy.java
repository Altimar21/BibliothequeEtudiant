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

    public Copy(boolean borrCopy, GregorianCalendar dateRecep, int idCopy, Book book) {
        this.borrCopy = borrCopy;
        this.dateRecep = dateRecep;
        this.idCopy = idCopy;
        this.book = book;
    }

    public int getIdCopy() {
        return idCopy;
    }

    private String BooltoString(boolean b){
        if(borrCopy){
           return "Oui";
        }
        else{
           return "Non";
        }
    }

    public boolean isBorrCopy() {
        return borrCopy;
    }

    @Override
    public String toString() {
        return "Detail exemplaire    : " +"\n" +
                "empruntable  : " + BooltoString(borrCopy) + "\n" +
                "dateRecep    : " + EntreesSorties.ecrireDate(dateRecep) +"\n" +
                "idExemplaire : " + idCopy ;
    }
}