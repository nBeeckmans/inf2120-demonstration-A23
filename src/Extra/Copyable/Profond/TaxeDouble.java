package Extra.Copyable.Profond;

public class TaxeDouble extends Produit {

    private static double TAXE = 1.09975;

    public TaxeDouble(String nom, double prix) {
        super(nom, prix);
    }

    @Override
    public double prix() {
        return super.prix * TAXE;
    }

    @Override
    public TaxeDouble copier() {
        return new TaxeDouble( super.getNom(), super.getPrix());
    }
}
