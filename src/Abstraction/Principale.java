package Abstraction;

public class Principale {
    public static final String VALEUR_OBTENUE =
            "Valeur Obtenue : ";
    public static final String VALEUR_PREDITE =
            "Valeur Predite : ";

    public static final int TAILLE_TABLEAU = 10;
    public static void main(String[] args) {
        try {
            testAireCercle();
            testAireRectangle();
            testVolumeSphere();
            testVolumeCylindre();
            testTableauForme3D();
        } catch (TestException testException) {
            System.err.println(testException);
        } finally {
            System.out.println("Fin du programme !");
        }
    }

    public static void testAireCercle() {
        Forme2D forme = new Cercle(1);
        double valeurPredite = 1 * Math.PI;
        if (forme.aire() != valeurPredite)
            throw new TestException(VALEUR_OBTENUE
                    + forme.aire()
                    + VALEUR_PREDITE
                    + valeurPredite);
    }
    public static void testAireRectangle() {
        Forme2D forme = new Rectangle(1, 1);
        double valeurPredite = 1;
        if (forme.aire() != valeurPredite)
            throw new TestException(VALEUR_OBTENUE
                    + forme.aire()
                    + VALEUR_PREDITE
                    + valeurPredite);
    }
    public static void testVolumeSphere() {
        Forme3D forme = new Sphere(1);
        double valeurPredite = 4.0/3.0 * Math.PI;
        if (forme.volume() != valeurPredite)
            throw new TestException(VALEUR_OBTENUE
                    + forme.volume()
                    + VALEUR_PREDITE
                    + valeurPredite);
    }
    public static void testVolumeCylindre() {
        Forme3D forme = new CylindreDroit(new Cercle(1), 1);
        double valeurPredite = Math.PI;
    //    double valeurPredite = 123 * Math.PI;
        if (forme.volume() != valeurPredite)
            throw new TestException(VALEUR_OBTENUE
                    + forme.volume()
                    + VALEUR_PREDITE
                    + valeurPredite);
    }

    public static void testTableauForme3D(){
        Forme3D[] formes = new Forme3D[TAILLE_TABLEAU];
        double[] volumes = new double[TAILLE_TABLEAU];

        for (int i = 0; i < TAILLE_TABLEAU; i++) {
            formes[i] = usineForme3D(i);
            volumes[i] = formes[i].volume();
            System.out.println(formes[i] + " de volume " + volumes[i]);
        }

    }

    public static Forme3D usineForme3D(int i) {
        return switch(i % 3){
            case 0-> new CylindreDroit(new Cercle(i), i) ;
            case 1-> new CylindreDroit(new Rectangle(i, 2*i),i);
            case 2-> new Sphere(i);
            default -> null;
        };
    }
}
