package Extra.InstanceOf;

public class FactureInstanceOf {

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
        final double[] TAXES = {1.05, 1.09975};

        for (int i = 0; i < produitEffectifs; i ++) {
            if (produits[i] instanceof NonTaxable)
                prixTotal += produits[i].PRIX;

            else if (produits[i] instanceof TaxeSimple)
                prixTotal += produits[i].PRIX * TAXES[0];

            else if (produits[i] instanceof TaxeDouble)
                prixTotal += produits[i].PRIX * TAXES[1];
        }
        return prixTotal;
    }
}
