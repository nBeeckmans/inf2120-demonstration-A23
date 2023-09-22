package Extra.FactoryV2;

public abstract class Produit {

    protected double prix;
    private String nom;

    public Produit( String nom, double prix) {
        this.prix = prix;
        this.nom = nom;
    }

    abstract public double prix();

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
