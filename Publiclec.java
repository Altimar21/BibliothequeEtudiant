/**
 * Created by Julien on 15/02/2017, 13:29.
 * Package name : PACKAGE_NAME.
 */
public enum Publiclec {
    ENFANT ("Enfant"),
    ADO ("ADO"),
    ADULTE ("ADULTE");

    private String name = "";

        //Constructeur
    Publiclec(String name){
        this.name = name;
    }

    public String toString(){
            return name;
    }
}
