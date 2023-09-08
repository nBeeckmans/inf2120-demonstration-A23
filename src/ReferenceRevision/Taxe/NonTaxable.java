package src.ReferenceRevision.Taxe;
public class NonTaxable {
    private String nom;
    private double prix;

    public NonTaxable(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public double prix() {
        return prix;
    }

}
