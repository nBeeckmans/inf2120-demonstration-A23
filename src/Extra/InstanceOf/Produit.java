package Extra.InstanceOf;

public abstract class Produit {

    public final double PRIX; // final -> pas modifiable apres instanciation !
    private String nom;

    public Produit( String nom, double prix) {
        this.PRIX = prix;
        this.nom = nom;
    }

    abstract public double prix();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
