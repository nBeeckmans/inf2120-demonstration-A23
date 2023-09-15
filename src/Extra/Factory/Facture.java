package Extra.Factory;

public class Facture {

    private static final String MESSAGE_ERREUR =
            "impossible d'ajouter un element supplementaire a ";
    private static final int NOMBRE_MAXIMUM_ELEMENTS = 10;

    private Produit[] produits = new Produit[30];
    int produitEffectifs = 0;

    public void ajouterProduitNonTaxable(NonTaxable produit) {
        int i = 0;
        Produit element= produits[i];
        while(element != null && i < produits.length) {
            i++;
            element = produits[i];
        }
        if (i < produits.length) {
            produits[i] = produit;
            // Important dans ce cas, car j'utilise l'autre methode aussi !
            produitEffectifs ++;
        } else {
            System.err.println(MESSAGE_ERREUR + NonTaxable.class.getName());
        }
    }
    public void ajouterProduitTaxeSimple(TaxeSimple produit) {
        if ( produitEffectifs < NOMBRE_MAXIMUM_ELEMENTS ) {
            produits[produitEffectifs] = produit;
            produitEffectifs ++;
        } else {
            System.err.println(MESSAGE_ERREUR + TaxeSimple.class.getName());
        }

    }
    public void ajouterProduitTaxeDouble(TaxeDouble produit) {
        if ( produitEffectifs < NOMBRE_MAXIMUM_ELEMENTS ) {
            produits[produitEffectifs] = produit;
            produitEffectifs ++;
        } else {
            System.err.println(MESSAGE_ERREUR + TaxeSimple.class.getName());
        }
    }
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
