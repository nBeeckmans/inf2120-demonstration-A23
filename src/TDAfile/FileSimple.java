package TDAfile;

public class FileSimple<T> {

    private final class Element<T> {
        private T valeur;
        private Element<T> suivant;
    }

    private Element<T> premier;
    private Element<T> dernier;

    public void enfiler(T valeur) {
        Element<T> nouvelElement = new Element<>();
        nouvelElement.valeur = valeur;

        if ( !estVide() ){
            nouvelElement.suivant = premier;
            premier=nouvelElement;
        } else {
            this.premier = nouvelElement;
            this.dernier = nouvelElement;
        }
    }

    public T defiler() throws FileVide {
        if (estVide())
            throw new FileVide();

        // on cherche avant dernier element !
        Element<T> temp = premier;
        while ( temp != null && temp.suivant != dernier ) {
            temp = temp.suivant;
        }

        T valeur;
        if ( temp != null ) {
           valeur = temp.suivant.valeur;
           dernier = temp;
           dernier.suivant = null;
        } else {
            valeur = premier.valeur;
            premier = null;
            dernier = null;
        }

        return valeur;
    }

    public boolean estVide(){
        return taille() == 0;
    }

    public int taille(){
        int i = 0;
        Element<T> element = premier;
        while( element != null ){
            i++;
            element = element.suivant;
        }

        return i;
    }

    public T tete() throws FileVide{
        if (estVide())
            throw new FileVide();

        return this.dernier.valeur;
    }

}
