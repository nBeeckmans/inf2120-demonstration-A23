package Extra.FindOut;

public class Couleur {
    private Integer rouge;
    private Integer vert;
    private Integer bleu;

    private final int VALEUR_MAX= 255;
    private final int VALEUR_MIN= 0;
    public Couleur (int rouge, int vert, int bleu) {
        setRouge(rouge);
        setVert(vert);
        setBleu(bleu);
    }

    public int getRouge() {
        return rouge;
    }

    public void setRouge(int rouge) {
        if (rouge > VALEUR_MAX || rouge < VALEUR_MIN)
            throw new RuntimeException();
        this.rouge = rouge;
    }

    public int getVert() {
        return vert;
    }

    public void setVert(int vert) {
        if (vert > VALEUR_MAX || vert < VALEUR_MIN)
            throw new RuntimeException();
        this.vert = vert;
    }

    public int getBleu() {
        return bleu;
    }

    public void setBleu(int bleu) {

        if (bleu > VALEUR_MAX || bleu < VALEUR_MIN)
            throw new RuntimeException();
        this.bleu = bleu;
    }

    public void blanchir(){
        blanchirCouleurPrimaire(rouge);
    }

    private void blanchirCouleurPrimaire(Integer couleur) {
        // Meme si couleur est un pointeur, il n'est pas possible de
        // modifier la valeur de l'objet !
        couleur =  (couleur + 255) / 2;
    }

    @Override
    public String toString() {
        return "ReferenceRevision.Couleur.Couleur{" +
                "rouge=" + rouge +
                ", vert=" + vert +
                ", bleu=" + bleu +
                '}';
    }

}