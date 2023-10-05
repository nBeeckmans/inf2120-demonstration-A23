package Interface;

import java.util.ArrayList;

public class Principale {
    public static void main(String []args) {
        testListDouble();
        testListFraction();
    }

    public static void testListDouble() {
        System.out.println("----------------------");
        ArrayList<NDouble> list = new ArrayList<>();
        list.add(new NDouble(1));
        list.add(new NDouble(2));
        list.add(new NDouble(3));
        list.add(new NDouble(4));
        Nombre<NDouble> somme = somme(list);
        System.out.println(somme);
        System.out.println("somme attendue : " + (1 +2 + 3 +4));
    }

    public static void testListFraction() {
        System.out.println("----------------------");
        ArrayList<Fraction> list = new ArrayList<>();
        list.add(new Fraction(1.0, 2.0));
        list.add(new Fraction(2.0, 4.0));
        list.add(new Fraction(3.0, 3.0));
        list.add(new Fraction(4.0, 1.0));
        Nombre<Fraction> somme = somme(list);
        System.out.println(somme);
        System.out.println("num attendu : " + (2.0/4.0 + 1.0/2.0 + 3.0/3.0 + 4.0/1.0)*24.0);
        System.out.println("denom attendu : " + 24.0);
    }
    public static <N extends Nombre<N>> Nombre<N> somme(ArrayList< N > tableau) {
        Nombre<N> valeurRetour = null;
        if (!tableau.isEmpty()) {
            valeurRetour = tableau.get(0);
            for (int i = 1; i < tableau.size(); i ++) {
                valeurRetour = valeurRetour.add(tableau.get(i));
            }
        }
        return valeurRetour;
    }
}
