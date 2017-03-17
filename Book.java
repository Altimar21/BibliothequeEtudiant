import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Created by Julien on 15/02/2017, 13:20.
 * Package name : Book.
 *
 * @author Julien
 */
public class Book implements Serializable {


    // -----------------------------------------------
    //Attributs
    // -----------------------------------------------
    private String author;
    private GregorianCalendar dateRelease;
    private String editor;
    private int numISBN;
    private String title;
    private Publiclec publicc;
    private int nbCopy;
    private int lastIdCopy;
    private Vector<Copy> copy;

    // -----------------------------------------------
    //Constructeur
    // -----------------------------------------------

    /**
     * Crée un Livre.
     *
     * @param author
     * @param dateRelease
     * @param editor
     * @param numISBN
     * @param title
     * @param publicc
     */
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

// -----------------------------------------------
// Public
// -----------------------------------------------

    // -----------------------------------------------
    // Methodes
    // -----------------------------------------------

    /**
     * Affiche les données d'un exemplaire a partir de son identifiant
     *
     * @param idCopy
     */
    public void PrintCopy(int idCopy){
        Copy c = getCopy(idCopy);
        if (c != null){
            System.out.println(c.toString());
        }else{
            System.out.println("L'exemplaire n'exite pas");
        }

    }

    /**
     * Retourne le nombre d'exmplaire empruntable
     *
     * @return nombre exemplaires
     */
    public int nbBorrCopy(){
        int count = 0;
        for (Copy aCopy : copy) {
            if (aCopy.isBorrCopy() && aCopy.getBorrow() == null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Ajoute un exemplaire de ce livre
     *
     * @param borrCopy
     * @param dateRecep
     */
    public void addCopy(boolean borrCopy, GregorianCalendar dateRecep){
        lastIdCopy++;
        setCopy(borrCopy,dateRecep,lastIdCopy);
    }

    /**
     * Affiche les details du livre
     */
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

    // -----------------------------------------------
    //Getters
    // -----------------------------------------------

    /**
     * Retourne l'exemplaire lier a un identifiant
     * @param idCopy
     * @return Copy
     */
    public Copy getCopy(int idCopy){
        for (int i = 0; i <= copy.size() ;i++){
            if(copy.get(i).getIdCopy() == idCopy){
                return copy.get(i);
            }
        }
        return null;
    }


    /**
     * Retourne true si il y a des exemplaire de ce livre en stock
     *
     * @return true ou false
     */
    public boolean getCopy(){
        return copy.isEmpty();
    }

    /**
     * Retourne l'identifiant du premier exemplaire empruntable
     * 
     * @return identifiant d'un exemplaire
     */
    public int getfirstBorrCoppy() {
        for (int i = 0; i <= copy.size(); i++) {
            if (copy.get(i).isBorrCopy() && copy.get(i).getBorrow() == null) {
                return copy.get(i).getIdCopy();
            }
        }
        return 0;
    }

    /**
     * Retourne le type de publique lier a ce livre
     *
     * @return le publique
     */
    public Publiclec getPublicc() {
        return publicc;
    }

    /**
     * Retourne le numero ISBN de ce livre
     *
     * @return ISBN
     */
    public int getNumISBN() {
        return numISBN;
    }

    /**
     * Retourne le titre de ce livre
     *
     * @return Titre
     */
    public String getTitle() {
        return title;
    }
// -----------------------------------------------
// Private
// -----------------------------------------------
    // -----------------------------------------------
    //Setters
    // -----------------------------------------------


    /**
     * Permet d'ajouter un exemplaire
     *
     * @param borrCopy
     * @param dateRecep
     * @param idCopy
     */
    private void setCopy(boolean borrCopy, GregorianCalendar dateRecep, int idCopy){
        this.copy.add(new Copy(borrCopy,dateRecep,idCopy, this));
    }

}