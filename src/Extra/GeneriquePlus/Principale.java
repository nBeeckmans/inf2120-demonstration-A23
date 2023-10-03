package Extra.GeneriquePlus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Principale {

    public static void main(String[] args){

        ArrayList<Integer> tableau =
                new ArrayList<>(Arrays.asList(0,1,2,3,5,6,7,99));

        System.out.println("Test valide :" );
        test(tableau, 3);
        System.out.println("Test invalide :");
        test(tableau, 70);

        System.out.println("---------------");
        Produit[] produits = {
                new NonTaxable("test", 1),
                new TaxeSimple("test", 2),
                new TaxeDouble("test", 3)
        };

        Facture f1 = creerFacture(produits);
        Facture f2 = creerFacture2(produits[0], produits[1], produits[2]);

        System.out.println("info sur f1 :" );
        System.out.println(f1.produitEffectifs);
        System.out.println(f1.prixTotal());

        System.out.println("info sur f2 :" );
        System.out.println(f2.produitEffectifs);
        System.out.println(f2.prixTotal());

    }

    private static void test(ArrayList<Integer> tableau,Integer valeurCherchee) {
        Optional<Integer> valeur = trouverEtCopier(tableau, valeurCherchee);

        if (valeur.isPresent())
            System.out.println(valeur.get());
        else
            System.out.println("la valeur n'est pas trouvee !");
    }

    public static <T> Optional<T> trouverEtCopier(ArrayList<T> tableau, T objet) {

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
                ? Optional.of(objetRegarde)
                : Optional.empty();
    }

    public static <T extends Produit> Facture creerFacture(T...elements ) {
        Facture nouvelleFacture = new Facture();
        for(T element : elements) {
            nouvelleFacture.ajouterProduit(element);
        }
        return nouvelleFacture;
    }
    public static Facture creerFacture2(Produit...elements) {
        Facture nouvelleFacture = new Facture();
        for(Produit element : elements) {
            nouvelleFacture.ajouterProduit(element);
        }
        return nouvelleFacture;
    }



}
