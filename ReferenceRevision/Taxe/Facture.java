package ReferenceRevision.Taxe;

public class Facture {
    NonTaxable[] produitsNonTaxables = new NonTaxable[10];
    TaxeSimple[] produitsTaxablesSimple = new TaxeSimple[10];
    TaxeDouble[] produitsTaxablesDouble = new TaxeDouble[10];

    //ajouterProduit(NonTaxable produit);
    //ajouterProduit(TaxeSimple produit);
    //ajouterProduit(TaxeDouble produit);
    public void ajouterProduitNonTaxable(NonTaxable produit) {

    }
    public void ajouterProduitTaxeSimple(TaxeSimple produit) {

    }
    public void ajouterProduitTaxeDouble(TaxeDouble produit) {

    }

    public double prixTotal() {
        double prixTotal = 0.0;
        for (NonTaxable produits: produitsNonTaxables) {
            prixTotal += produits.prix();
        }
        for (TaxeSimple produits: produitsTaxablesSimple) {
            prixTotal += produits.prix();
        }
        for (TaxeDouble produits: produitsTaxablesDouble) {
            prixTotal += produits.prix();
        }
        return prixTotal;
    }
}
