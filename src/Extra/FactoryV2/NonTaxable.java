package Extra.FactoryV2;

public class NonTaxable extends Produit {
    public NonTaxable(String nom, double prix) {
        super(nom, prix);
    }

    @Override
    public double prix() {
        return super.getPrix();
    }

}
