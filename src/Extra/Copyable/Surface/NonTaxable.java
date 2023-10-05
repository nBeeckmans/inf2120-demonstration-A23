package Extra.Copyable.Surface;

public class NonTaxable extends Produit {
    public NonTaxable(String nom, double prix) {
        super(nom, prix);
    }

    @Override
    public double prix() {
        return super.getPrix();
    }

    @Override
    public NonTaxable copier() {
        return new NonTaxable(super.getNom(), super.getPrix());
    }
}
