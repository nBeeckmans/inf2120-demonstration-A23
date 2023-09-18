package Heritage.Taxe;

public class TaxeDouble extends Produit{

    private final static double TAXE = 1.09975;


    public TaxeDouble(String nom, double prix) {
        super(nom, prix);
    }

    @Override
    public double prix() {
        return super.prix * TAXE;
    }
}
