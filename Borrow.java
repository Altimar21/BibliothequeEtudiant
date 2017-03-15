import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Julien on 06/03/2017, 11:00.
 * Package name : PACKAGE_NAME.
 */
public class Borrow implements Serializable {
    private Reader reader;
    private Copy copy;
    private GregorianCalendar dateRelease;

    public Borrow(Reader reader, Copy copy, GregorianCalendar dateRelease) {
        this.reader = reader;
        this.copy = copy;
        this.dateRelease = dateRelease;
    }


    public void removeBorrow(){
        this.getReader().removeBorrow(this);
        this.getCopy().setBorrow(null);
        this.setReader(null);
        this.setCopy(null);
    }

    private void setReader(Reader reader) {
        this.reader = reader;
    }

    private void setCopy(Copy copy) {
        this.copy = copy;
    }

    private Reader getReader() {
        return reader;
    }

    private Copy getCopy() {
        return copy;
    }

    public GregorianCalendar getDateReturn(){
        GregorianCalendar dateReturn = (GregorianCalendar) dateRelease.clone();
        dateReturn.add(Calendar.DATE, 8);
        return dateReturn;
    }

    public String display() {
        return  reader.getfName()                   + "\t" +
                reader.getlName()                + "\t" +
                this.copy.getBook().getNumISBN()  + "\t" +
                this.copy.getBook().getTitle()    + "\t" +
                this.copy.getIdCopy()             + "\t" +
                EntreesSorties.ecrireDate(dateRelease) + "\t" +
                EntreesSorties.ecrireDate(getDateReturn());
    }
    public void displayAll(){
        EntreesSorties.afficherMessage("Lecteur             : " + reader.getAllName());
        EntreesSorties.afficherMessage("Num Lecteur         : " + reader.getNumReader());
        EntreesSorties.afficherMessage("Num ISBN            : " + copy.getBook().getNumISBN());
        EntreesSorties.afficherMessage("Titre               :" + copy.getBook().getTitle() );
        EntreesSorties.afficherMessage("Numero d'exemplaire : " + copy.getIdCopy() );
        System.out.print("\n");
        EntreesSorties.afficherMessage("Date d'emprunt      : " + EntreesSorties.ecrireDate(dateRelease) );
        EntreesSorties.afficherMessage("Date de retour      : " + EntreesSorties.ecrireDate(getDateReturn()));
    }
}