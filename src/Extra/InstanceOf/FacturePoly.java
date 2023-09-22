package Extra.InstanceOf;

public class FacturePoly {

    private static final String MESSAGE_ERREUR =
            "impossible d'ajouter un element supplementaire a ";
    private static final int NOMBRE_MAXIMUM_ELEMENTS = 100_000_000;

    private Produit[] produits = new Produit[NOMBRE_MAXIMUM_ELEMENTS];
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
