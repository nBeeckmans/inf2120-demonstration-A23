package Heritage.Taxe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {

    @Test
    void ajouterProduitNonTaxable() {
        Facture facture = new Facture();
        NonTaxable produitNonTaxable = new NonTaxable("nom",1.00);
        facture.ajouterProduitNonTaxable(produitNonTaxable);
        assertEquals(1, facture.produitEffectifs);
    }

    @Test
    void ajouterProduitTaxeSimple() {
        Facture facture = new Facture();
        TaxeSimple produitTaxeSimple = new TaxeSimple("nom",1.00);
        facture.ajouterProduitTaxeSimple(produitTaxeSimple);
        assertEquals(1, facture.produitEffectifs);
    }

    @Test
    void ajouterProduitTaxeDouble() {
        Facture facture = new Facture();
        TaxeDouble produitTaxeDouble = new TaxeDouble("nom",1.00);
        facture.ajouterProduitTaxeDouble(produitTaxeDouble);
        assertEquals(1, facture.produitEffectifs);
    }

    @Test
    void ajouterProduit() {
        Facture facture = new Facture();
        NonTaxable produitNonTaxable = new NonTaxable("nom",1.00);
        TaxeSimple produitTaxeSimple = new TaxeSimple("nom",1.00);
        TaxeDouble produitTaxeDouble = new TaxeDouble("nom",1.00);
        Produit produit = new Produit("nom", 1.00);
        facture.ajouterProduit(produitNonTaxable);
        facture.ajouterProduit(produitTaxeSimple);
        facture.ajouterProduit(produitTaxeDouble);
        facture.ajouterProduit(produit);
        assertEquals(4, facture.produitEffectifs);
    }

    @Test
    void prixTotal() {
        Facture facture = new Facture();
        NonTaxable produitNonTaxable = new NonTaxable("nom",1.00);
        TaxeSimple produitTaxeSimple = new TaxeSimple("nom",1.00);
        TaxeDouble produitTaxeDouble = new TaxeDouble("nom",1.00);
        Produit produit = new Produit("nom", 1.00);
        facture.ajouterProduit(produitNonTaxable);
        facture.ajouterProduit(produitTaxeSimple);
        facture.ajouterProduit(produitTaxeDouble);
        facture.ajouterProduit(produit);
        assertEquals(3.14975, facture.prixTotal(),0.00001 );
    }
}