package ReferenceRevision.Couleur;

import ReferenceRevision.Couleur.Couleur;

public class Main {

    public static void main(String[] args) {

        Couleur c1 = new Couleur(1, 200, 6);
        Couleur c2 = c1;
        System.out.println(c2);
        c2.setRouge(100);
        System.out.println(c1);

        c1.blanchir();
        System.out.println( c1 );
        System.out.println( c2 );
    }

}