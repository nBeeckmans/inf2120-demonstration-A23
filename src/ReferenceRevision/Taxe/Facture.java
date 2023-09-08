package ReferenceRevision.Taxe;
public class Facture {

    private static final String MESSAGE_ERREUR =
            "impossible d'ajouter un element supplementaire a ";
    private static final int NOMBRE_MAXIMUM_ELEMENTS = 10;
    private NonTaxable[] produitsNonTaxables = new NonTaxable[10];
    private TaxeSimple[] produitsTaxablesSimple = new TaxeSimple[10];
    private int compteurElementTaxablesSimple = 0;
    private TaxeDouble[] produitsTaxablesDouble = new TaxeDouble[10];
    private int compteurElementTaxablesDouble = 0;

    //ajouterProduit(NonTaxable produit);
    //ajouterProduit(TaxeSimple produit);
    //ajouterProduit(TaxeDouble produit);

    //utilisation de null pour montrer que la case est vide !
    public void ajouterProduitNonTaxable(NonTaxable produit) {
        int i = 0;
        NonTaxable element= produitsNonTaxables[i];
        while(element != null && i < produitsNonTaxables.length) {
            i++;
            element = produitsNonTaxables[i];
        }
        if (i < produitsNonTaxables.length) {
            produitsNonTaxables[i] = produit;
        } else {
            System.err.println(MESSAGE_ERREUR + NonTaxable.class.getName());
        }
    }
    public void ajouterProduitTaxeSimple(TaxeSimple produit) {
        if ( compteurElementTaxablesSimple < NOMBRE_MAXIMUM_ELEMENTS ) {
            produitsTaxablesSimple[compteurElementTaxablesSimple] = produit;
            compteurElementTaxablesSimple ++;
        } else {
            System.err.println(MESSAGE_ERREUR + TaxeSimple.class.getName());
        }

    }
    public void ajouterProduitTaxeDouble(TaxeDouble produit) {
        if ( compteurElementTaxablesDouble < NOMBRE_MAXIMUM_ELEMENTS ) {
            produitsTaxablesDouble[compteurElementTaxablesDouble] = produit;
            compteurElementTaxablesDouble ++;
        } else {
            System.err.println(MESSAGE_ERREUR + TaxeSimple.class.getName());
        }
    }

    public double prixTotal() {
        double prixTotal = 0.0;
        //for normal
        for (int i = 0; i < NOMBRE_MAXIMUM_ELEMENTS; i++) {
            if (produitsNonTaxables[i] != null) {
                prixTotal += produitsNonTaxables[i].prix();
            }
        }
        //for ameliore
        for (TaxeSimple produits: produitsTaxablesSimple) {
            if (produits != null)
                prixTotal += produits.prix();
        }
        //for "optimise"
        for (int i = 0; i < compteurElementTaxablesDouble; i ++){
                prixTotal += produitsTaxablesDouble[i].prix();
        }
        return prixTotal;
    }
}
