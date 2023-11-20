package Fouilles;


public class Fraction implements Comparable<Fraction> {
    int numerateur = 0;
    int denominateur = 1;

    public Fraction(){}

    public Fraction( int num, int denom ){
        this.numerateur = num;
        this.denominateur = denom;
    }

    @Override
    public int compareTo(Fraction fraction) {
        return this.numerateur * fraction.denominateur - fraction.numerateur * this.denominateur;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerateur=" + numerateur +
                ", denominateur=" + denominateur +
                '}';
    }
}
