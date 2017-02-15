/**
 * Created by Julien on 15/02/2017, 13:39.
 * Package name : PACKAGE_NAME.
 */
public class Copy {
    private boolean borrCopy;
    private Date dateRecep;
    private int idCopy;

    public Copy(boolean borrCopy, Date dateRecep, int idCopy) {
        this.borrCopy = borrCopy;
        this.dateRecep = dateRecep;
        this.idCopy = idCopy;
    }

    public int getIdCopy() {
        return idCopy;
    }


    @Override
    public String toString() {
        return "Copy{" +
                "borrCopy=" + borrCopy +
                ", dateRecep=" + dateRecep +
                ", idCopy=" + idCopy +
                '}';
    }
}