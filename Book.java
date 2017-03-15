import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Created by Julien on 15/02/2017, 13:20.
 * Package name : PACKAGE_NAME.
 */
public class Book implements Serializable {

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

    //retourne l'exemplaire lier a l'id
    public Copy getCopy(int idCopy){
        return findCopy(idCopy);
    }

    //retourne si il y a des exemplaire de ce livre
    public boolean getCopy(){
        return copy.isEmpty();
    }

    public int getNbCopy(){
        return copy.size();
    }

    //retourne l'id du premier exemplaire empruntable
    public int getfirstBorrCoppy() {
        for (int i = 0; i <= copy.size(); i++) {
            if (copy.get(i).isBorrCopy() && copy.get(i).getBorrow() == null) {
                return copy.get(i).getIdCopy();
            }
        }
        return 0;
    }

    //retourne le nombre d'exemplaire empruntable
    public int nbBorrCopy(){
     //  return copy.size();
        int count = 0;
        for (Copy aCopy : copy) {
            if (aCopy.isBorrCopy() && aCopy.getBorrow() == null) {
                count++;
            }
        }
        return count;
    }

    public Publiclec getPublicc() {
        return publicc;
    }

    public int getNumISBN() {
        return numISBN;
    }

    public String getTitle() {
        return title;
    }


    public void addCopy(boolean borrCopy, GregorianCalendar dateRecep){
        lastIdCopy++;
        setCopy(borrCopy,dateRecep,lastIdCopy);
    }

    private void setCopy(boolean borrCopy, GregorianCalendar dateRecep, int idCopy){
      //  Copy c = new Copy(borrCopy,dateRecep,idCopy, this);
        this.copy.add(new Copy(borrCopy,dateRecep,idCopy, this));
    }

    public void display() {
        System.out.println( "Detail livre : "            + "\n" +
                            "Auteur        : " + author   + "\n" +
                            "Date livre    : " + EntreesSorties.ecrireDate(dateRelease)+ "\n" +
                            "Editeur       : " + editor   + "\n" +
                            "ISBN          : " + numISBN  + "\n" +
                            "Titre         : " + title    + "\n" +
                            "Publique      : " + publicc  + "\n" +
                            "Nb exemplaire : " + copy.size() );
    }
}