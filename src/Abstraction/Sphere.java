package Abstraction;

public class Sphere extends Forme3D{
    private double rayon;
    private static final double QUATRE_TIERS = 4.0/3.0;

    public Sphere(double rayon) {
        if (rayon < 0)
            throw new RuntimeException();

        this.rayon = rayon;
    }
    @Override
    public double volume() {
        return QUATRE_TIERS * Math.PI * rayon * rayon * rayon;
        //return QUATRE_TIERS * Math.PI * Math.pow(rayon, 3);
        //return 4.0/3.0 * Math.Pi * rayon * rayon * rayon;
    }

    @Override
    public String toString() {
        return Forme3D.DEBUT_MESSAGE
                + this.getClass().getName().substring(Forme3D.DEBUT_NOM_DE_CLASSE)
                + " de rayon : "
                + rayon;
    }
}
