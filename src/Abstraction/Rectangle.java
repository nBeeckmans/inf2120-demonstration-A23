package Abstraction;

public class Rectangle extends Forme2D{
    public static final String MESSAGE_TO_STRING_1 =
            Forme2D.DEBUT_MESSAGE + "Rectangle de base : ";
    public static final String MESSAGE_TO_STRING_2 =
            " et de hauteur : ";
    private Double base;
    private Double hauteur;

    public Rectangle(double base, double hauteur) {
        if (base < 0 || hauteur < 0)
            throw new RuntimeException();

        this.base = base;
        this.hauteur = hauteur;
    }
    @Override
    public double aire() {
        return base * hauteur;
    }

    @Override
    public String toString() {
        return MESSAGE_TO_STRING_1
                + base
                + MESSAGE_TO_STRING_2
                + hauteur;
    }
}
