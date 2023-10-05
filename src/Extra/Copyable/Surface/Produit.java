package Extra.Copyable.Surface;

public abstract class Produit implements Copyable<Produit> {

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

    @Override
    public boolean equals( Object o ) {
        Produit aCompare = ( Produit ) o;
        return aCompare.prix == this.prix
                && aCompare.nom.equals(this.nom);
    }

    @Override
    public String toString() {
        return this.nom + " + " +  this.prix;
    }
}
