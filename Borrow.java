import java.io.Serializable;
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


    @Override
    public String toString() {
        return "Borrow :" +
                "reader=" + reader +
                ", copy=" + copy +
                ", dateRelease=" + dateRelease +
                '}';
    }
}
