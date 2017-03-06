import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Created by Julien on 15/02/2017, 13:20.
 * Package name : PACKAGE_NAME.
 */
public class Book {

    private String author;
    private GregorianCalendar dateRelease;
    private String editor;
    private int numISBN;
    private String title;
    private Publiclec publicc;
    private int nbCopy;
    private int lastIdCopy;
    private Vector<Copy> copy;

    public Book(String author, GregorianCalendar dateRelease, String editor, int numISBN, String title, Publiclec publicc) {
        this.author = author;
        this.dateRelease = dateRelease;
        this.editor = editor;
        this.numISBN = numISBN;
        this.title = title;
        this.publicc = publicc;

        lastIdCopy = 0;

        copy = new Vector<>();
    }

    public void PrintCopy(int idCopy){
        Copy c = getCopy(idCopy);
        if (c != null){
            System.out.println(c.toString());
        }else{
            System.out.println("L'exemplaire n'exite pas");
        }

    }

    private Copy findCopy(int idCopy){
        for (int i = 0; i <= copy.size() ;i++){
            if(copy.get(i).getIdCopy() == idCopy){
                return copy.get(i);
            }
        }
        return null;
    }

    private Copy getCopy(int idCopy){
        return findCopy(idCopy);
    }

    public void addCopy(boolean borrCopy, GregorianCalendar dateRecep){
        lastIdCopy++;
        setCopy(borrCopy,dateRecep,lastIdCopy);
    }

    private void setCopy(boolean borrCopy, GregorianCalendar dateRecep, int idCopy){
        Copy c = new Copy(borrCopy,dateRecep,idCopy);
        this.copy.add(c);
    }


    @Override
    public String toString() {
        return "Detail livre : \n" +
                "author      : " + author + "\n" +
                "dateRelease : " + EntreesSorties.ecrireDate(dateRelease)+ "\n" +
                "editor      : " + editor + "\n" +
                "numISBN     : " + numISBN + "\n" +
                "title       : " + title + "\n" +
                "publique    : " + publicc +"\n" +
                "nbCopy      : " + nbCopy ;
    }
}