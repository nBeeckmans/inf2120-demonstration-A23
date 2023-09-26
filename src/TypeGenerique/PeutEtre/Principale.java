package TypeGenerique.PeutEtre;

import java.util.Optional;

public class Principale {
    public static void main (String[] args) {
        Double[] tableauDouble = {1.0, 1.11, 1.23, 1.25};
        PeutEtre<Integer> elementTrouve = trouverElement(tableauDouble, 1.0);
        System.out.println(elementTrouve);

        PeutEtre<Integer> elementPasTrouve = trouverElement(tableauDouble, 2.0);
        System.out.println(elementPasTrouve);
    }
    public static <T> PeutEtre<Integer> trouverElement( T[] a_tableau, T a_element ) {
        int indice = 0;
        T elementRegarde ;
        boolean pasTrouve = true;
        do {
            elementRegarde = a_tableau[indice];

            if (elementRegarde != null)
                pasTrouve = !elementRegarde.equals(a_element);

            indice ++;
        } while(pasTrouve && indice < a_tableau.length);

        return indice < a_tableau.length
                ? new QQChose<>(--indice)
                : new Rien<>();
    }
    public static <T> Optional<Integer> trouverElementOptional(T[] a_tableau, T a_element ) {
        int i = 0;
        T elementRegarde;
        boolean pasTrouve = true;

        do {
            elementRegarde = a_tableau[i];

            if (elementRegarde != null){
                pasTrouve = !elementRegarde.equals(a_element);
            }

            i ++;
        } while(pasTrouve && i < a_tableau.length);

        Integer indice = i < a_tableau.length
                ?  i - 1
                : null;
        return Optional.ofNullable(indice);
    }
}
