package Extra.GeneriquePlus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Principale {
    public static void main(String[] args){
        Integer valeurCherchee = 3;

        ArrayList<Integer> tableau =
                new ArrayList<>(Arrays.asList(0,1,2,3,5,6,7,99));

        Optional<Integer> valeur = trouverEtCopier(tableau, valeurCherchee);

        if (valeur.isPresent()) {
            System.out.println(valeur.get());
        } else {
            System.out.println("la valeur n'est pas trouvee !");
        }
    }

    public static <T> Optional<T> trouverEtCopier(ArrayList<T> tableau, T objet) {

        int tailleTableau = tableau.size();
        T objetRegarde = null;
        int i = 0;
        boolean estTrouve = false;

        while(!estTrouve && i < tailleTableau) {
           objetRegarde = tableau.get(i);
           estTrouve = objet.equals(objetRegarde);
           i ++;
        }

        return i < tailleTableau
                ? Optional.of(objetRegarde)
                : Optional.empty();
    }

}
