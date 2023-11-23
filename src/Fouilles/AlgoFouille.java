package Fouilles;

public class AlgoFouille {
    public static < E extends Comparable< E > > int fouilleBinaire( E [] tableau, E element ){
        int i = 0;
        int j = tableau.length-1;
        while( i < j ) {
            int m = (i + j)/2;
            if ( element.compareTo(tableau[m]) <= 0){
                j = m;
            } else {
                i = m + 1;
            }
        }
        if ( tableau[i].compareTo(element)!= 0){
            i = -1;
        }
        return i;
    }

    public static < E extends Comparable< E > > int fouilleBinaire( E [] tableau, E element, int debut, int fin ){
        int retour;
        if ( debut < fin ){
            int milieu = (debut + fin) / 2;
            retour = element.compareTo(tableau[milieu]) <= 0
                    ? fouilleBinaire(tableau, element, debut, milieu)
                    : fouilleBinaire(tableau, element, milieu + 1, fin);
        } else {
            retour = tableau[debut].compareTo(element) == 0
                    ? debut
                    : -1;

        }
        return retour;
    }

}
