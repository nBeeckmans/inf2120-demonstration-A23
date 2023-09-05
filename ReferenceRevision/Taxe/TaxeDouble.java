package ReferenceRevision.Taxe;

import java.text.DecimalFormat;

public class TaxeDouble {
    private String nom;
    private double  prix;
    public static double TAXE = 1.09975;

    public TaxeDouble(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public double prix() {
        return prix * TAXE;
    }
}
