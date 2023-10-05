package Extra.Copyable.Profond;

public class NonTaxable extends Produit {
    public NonTaxable(String nom, double prix) {
        super(nom, prix);
    }

    @Override
    public double prix() {
        return super.getPrix();
    }

    @Override
    public Produit copier() {
        return new NonTaxable(super.getNom(), super.getPrix());
    }
}
