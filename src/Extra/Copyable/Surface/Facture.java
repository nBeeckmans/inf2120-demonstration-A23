package Extra.Copyable.Surface;

public class Facture implements Copyable<Facture> {

    private static final String MESSAGE_ERREUR =
            "impossible d'ajouter un element supplementaire a ";
    private static final int NOMBRE_MAXIMUM_ELEMENTS = 30;

    private Produit[] produits = new Produit[30];
    int produitEffectifs = 0;

    public Facture() {};
    private Facture(Produit[] produits, int produitEffectifs) {
        this.produits = produits;
        this.produitEffectifs = produitEffectifs;
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

    @Override
    public Facture copier() {
        return new Facture(produits, produitEffectifs);
    }

    public Produit get(int indice) {
        //rappel ca serait mieux de mettre un Optional<Produit>
        return indice < produitEffectifs ? produits[indice] : null;
    }
}
