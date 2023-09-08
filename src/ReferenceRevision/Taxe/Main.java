package src.ReferenceRevision.Taxe;

public class Main {
    public static void main(String[] args) {
        Facture f1 = new Facture();
        f1.ajouterProduitNonTaxable(new NonTaxable("eau", 2.00));
        f1.ajouterProduitTaxeDouble(new TaxeDouble("chips", 2.00));
        f1.ajouterProduitTaxeSimple(new TaxeSimple("autoroute", 2.00));

        System.out.println("prix total de la facture : " + f1.prixTotal());
    }
}
