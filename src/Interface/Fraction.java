package Interface;

public class Fraction implements Nombre<Fraction> {
    protected Double numerateur;
    protected Double denominateur;

    public Fraction(Double numerateur, Double denominateur) {
        if (denominateur == 0)
            throw new RuntimeException();

        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }

    @Override
    public Fraction add(Fraction x) {
        Double nouveauNumerateur = this.numerateur * x.denominateur
                + this.denominateur * x.numerateur;
        Double nouveauDenominateur = this.denominateur * x.denominateur ;
        return new Fraction(nouveauNumerateur, nouveauDenominateur);
    }

    @Override
    public Fraction sub(Fraction x) {
        Double nouveauNumerateur = this.numerateur * x.denominateur - this.denominateur * x.numerateur;
        Double nouveauDenominateur = this.denominateur * x.denominateur ;
        return new Fraction(nouveauNumerateur, nouveauDenominateur);
    }

    @Override
    public Fraction mul(Fraction x) {
        Double nouveauNumerateur = this.numerateur * x.numerateur;
        Double nouveauDenominateur = this.denominateur * x.denominateur;
        return new Fraction(nouveauNumerateur, nouveauDenominateur);

    }

    @Override
    public Fraction div(Fraction x) {
        Double nouveauNumerateur = this.numerateur * x.denominateur;
        Double nouveauDenominateur = this.numerateur * x.denominateur;
        Fraction nouvelleFraction = null;

        try {
            nouvelleFraction = new Fraction(nouveauNumerateur, nouveauDenominateur);
        } catch (RuntimeException e) {}

        return nouvelleFraction;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "Numerateur=" + numerateur +
                ", Denominateur=" + denominateur +
                '}';
    }
}
