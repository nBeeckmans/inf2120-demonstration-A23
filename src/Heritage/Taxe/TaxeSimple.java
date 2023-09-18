package Heritage.Taxe;
public class TaxeSimple extends Produit{
    private static final double TAXE = 1.05;
    public TaxeSimple(String nom, double prix) {
        super(nom, prix);
    }
    @Override
    public double prix() {
        return prix * TAXE ;
    }

    // RAPPELS :
    //public String getNom() {
      //  super.nom;
    //}

    public String getNom() {
        return super.getNom();
    }
}
