package ReferenceRevision.Couleur;

public class Main {

    public static void main(String[] args) {

        Couleur c1 = new Couleur(1, 200, 6);
        Couleur c2 = c1;
        System.out.println(c2);
        try {

            c2.setRouge(100);
        } catch( RuntimeException e) {
            //faire quelque chose
        }
        System.out.println(c1);

        c1.blanchir();
        System.out.println( c1 );
        System.out.println( c2 );
    }

}