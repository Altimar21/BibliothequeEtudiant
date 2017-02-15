import java.util.Vector;

/**
 * Created by Julien on 15/02/2017, 13:20.
 * Package name : PACKAGE_NAME.
 */
public class Livre {

    private String author;
    private Date dateRelease;
    private String editor;
    private int numISBN;
    private String title;
    private Publiclec publicc;
    private int nbCopy;
    private int lastIdCopy;
    private Vector<Copy> Copy;

    public Livre(String author, Date dateRelease, String editor, int numISBN, String title, Publiclec publicc) {
        this.author = author;
        this.dateRelease = dateRelease;
        this.editor = editor;
        this.numISBN = numISBN;
        this.title = title;
        this.publicc = publicc;

        Copy = new Vector<Copy>();
        Copy = null;
    }

    public void PrintCopy(int idCopy){

        Copy c = findCopy(idCopy);
        c.toString();
    }

    private Copy findCopy(int idCopy){
        for (int i = 0; i <= Copy.size() ;i++){
            if(Copy.get(i).getIdCopy() == idCopy){
                return Copy.get(i);
            }
        }
        return null;
    }

    private Copy getCopy(int idCopy){
        return findCopy(idCopy);
    }

    private void setCopy(boolean borrCopy, Date dateRecep, int idCopy){
        this.Copy.addElement(new Copy(borrCopy,dateRecep,idCopy));
    }



    @Override
    public String toString() {
        return "Livre{" +
                "author='" + author + '\'' +
                ", dateRelease=" + dateRelease +
                ", editor='" + editor + '\'' +
                ", numISBN=" + numISBN +
                ", title='" + title + '\'' +
                ", publicc=" + publicc +
                ", nbCopy=" + nbCopy +
                '}';
    }
}
