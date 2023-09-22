package Abstraction;

public class CylindreDroit extends Forme3D{
    private Forme2D base;
    private double hauteur;
    public CylindreDroit(Forme2D base, double hauteur) {
        if (hauteur < 0)
            throw new RuntimeException();

        this.base = base;
        this.hauteur = hauteur;
    }
    @Override
    public double volume() {
        return base.aire() * hauteur;
    }

    @Override
    public String toString() {
        return Forme3D.DEBUT_MESSAGE
                + this.getClass().getName().substring(Forme3D.DEBUT_NOM_DE_CLASSE)
                + " avec une base de type  : "
                + base.getClass().getName().substring(Forme3D.DEBUT_NOM_DE_CLASSE)
                + " dont l'aire est de "
                + base.aire()
                + " et une hauteur de "
                + this.hauteur;
    }
}
