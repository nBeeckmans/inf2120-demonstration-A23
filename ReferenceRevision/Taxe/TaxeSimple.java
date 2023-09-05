package ReferenceRevision.Taxe;

public class TaxeSimple {
    private String nom;
    private double prix;
    public static double TAXE = 1.05;
    public TaxeSimple(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public double prix() {
        return prix * TAXE ;
    }
}
