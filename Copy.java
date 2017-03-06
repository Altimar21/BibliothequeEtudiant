import java.util.GregorianCalendar;

/**
 * Created by Julien on 15/02/2017, 13:39.
 * Package name : PACKAGE_NAME.
 */
public class Copy {
    private boolean borrCopy;
    private GregorianCalendar dateRecep;
    private int idCopy;

    public Copy(boolean borrCopy, GregorianCalendar dateRecep, int idCopy) {
        this.borrCopy = borrCopy;
        this.dateRecep = dateRecep;
        this.idCopy = idCopy;
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

    @Override
    public String toString() {
        return "Detail exemplaire    : " +"\n" +
                "empruntable  : " + BooltoString(borrCopy) + "\n" +
                "dateRecep    : " + EntreesSorties.ecrireDate(dateRecep) +"\n" +
                "idExemplaire : " + idCopy ;
    }
}