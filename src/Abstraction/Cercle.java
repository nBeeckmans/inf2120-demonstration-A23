package Abstraction;

public class Cercle extends Forme2D {
    public static final String MESSAGE_TO_STRING =
            Forme2D.DEBUT_MESSAGE +"cercle de rayon : ";
    private double rayon;

    public Cercle (double rayon) {
        if (rayon < 0)
            throw new RuntimeException();

        this.rayon = rayon;
    }
    @Override
    public double aire() {
        return   Math.PI * rayon * rayon;
    }
    @Override
    public String toString() {
        return MESSAGE_TO_STRING + rayon;
    }
}
