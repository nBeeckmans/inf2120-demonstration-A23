package Extra.Copyable.Simple;

public class Facture  {

    private static final String MESSAGE_ERREUR =
            "impossible d'ajouter un element supplementaire a ";
    private static final int NOMBRE_MAXIMUM_ELEMENTS = 30;

    private Produit[] produits = new Produit[30];
    int produitEffectifs = 0;

    public void ajouterProduit(Produit produit) {
        if ( produitEffectifs < NOMBRE_MAXIMUM_ELEMENTS ) {
            produits[produitEffectifs] = produit;
            produitEffectifs ++;
        } else {
            System.err.println(MESSAGE_ERREUR + Produit.class.getName());
        }
    }

    public double prixTotal() {
        double prixTotal = 0.0;
        //for "optimise"
        for (int i = 0; i < produitEffectifs; i ++){
                prixTotal += produits[i].prix();
        }
        return prixTotal;
    }

}
