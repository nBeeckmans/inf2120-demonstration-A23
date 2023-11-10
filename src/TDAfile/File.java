package TDAfile;
import java.util.function.Consumer;

public class File<T> {

    private final class Element<T> {
        private T valeur;
        private Element<T> precedant;
    }

    private final Consumer<T> ajouterPremierElement = ( valeur ) -> {
        //creer element
        Element<T> element = new Element<>();
        element.valeur = valeur;
        //placer element dans la liste
        this.premier = element;
        this.dernier = this.premier;

        //changer future ajout d'element
        this.ajouterElement = this.ajouterAutreElement;
    };

    private final Consumer<T> ajouterAutreElement = ( valeur ) -> {
        //creer element
        Element<T> element = new Element<>();
        element.valeur = valeur;
        //placer element dans la liste
        this.premier.precedant = element;
        this.premier = element;
    };

    // quand on creer la pile, on sait qu'il n'y a pas d'elements !
    private Consumer<T> ajouterElement = this.ajouterPremierElement;

    private Element<T> premier;
    private Element<T> dernier;
    private int nombreElement;

    public void enfiler(T valeur) {
        this.ajouterElement.accept(valeur);
        this.nombreElement++;
    }

    public T defiler() throws FileVide {
        switch(nombreElement) {
            case 0:
                throw new FileVide();
            case 1:
                ajouterElement = ajouterPremierElement;
                }
        T temp = this.dernier.valeur;
        this.dernier = this.dernier.precedant;
        this.nombreElement--;
        return temp;

    }

    public boolean estVide(){
        return nombreElement == 0;
    }

    public int taille(){
        return nombreElement;
    }

    public T tete() {
        return this.dernier.valeur;
    }

}
