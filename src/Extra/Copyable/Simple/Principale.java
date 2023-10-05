package Extra.Copyable.Simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Principale {

    public static void main(String[] args){

        ArrayList<Produit> produits = new ArrayList<>();
        produits.add(new NonTaxable("alo", 1));
        produits.add(new TaxeDouble("alo", 2));
        produits.add(new TaxeSimple("alo", 3));
        produits.add(new NonTaxable("alo", 1));


        Optional<Produit> trouve = trouverEtCopier(produits, new TaxeSimple("ola", 3));
        System.out.println(trouve.isPresent() ? trouve.get() : "pas trouve");

        trouve = trouverEtCopier(produits, new TaxeSimple("alo", 3));
        System.out.println(trouve.isPresent() ? trouve.get() : "pas trouve");

        System.out.printf("\nOn modifie la valeur\n");
        trouve.get().setPrix(100);
        System.out.println(trouve.get());

        System.out.printf("\nOn regarde l'original\n");
        System.out.println(produits.get(2));
    }


    public static <T extends Copyable<T>> Optional<T> trouverEtCopier(ArrayList<T> tableau, T objet) {

        int tailleTableau = tableau.size();
        int i = 0;

        boolean estTrouve = false;
        T objetRegarde = null;

        while(!estTrouve && i < tailleTableau) {
           objetRegarde = tableau.get(i);
           estTrouve = objet.equals(objetRegarde);
           i ++;
        }

        return i < tailleTableau
                ? Optional.of(objetRegarde.copier())
                : Optional.empty();
    }
}
