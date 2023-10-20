package Fonctions;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Principale {
    private static final int BORNE_MAX = 100;

    public static void main(String[] args) {
        Supplier<Integer> supplier = new MRand(BORNE_MAX);
        //testGenerateur(supplier);
        //testFunction();
        //testConsummerFraction();
        testPredicate(supplier);
   }

    public static void testGenerateur(Supplier<Integer> supplier) {
        if ( supplier == null) {
            throw new RuntimeException();
        }
        int[] occurences = new int[BORNE_MAX];

        int i;
        for ( i = 0; i < 1_000_000; i++ ) {
            occurences[supplier.get()] += 1;
        }
        for (i = 0; i < 100; i++ ){
            System.out.printf("il y a %d a la case %d\n",occurences[i], i);
        }
    }

    public static void testConsummerFraction () {
        Consumer<Fraction> consummer = (x) -> x.numerateur = x.numerateur * 2;
        ArrayList<Fraction> fractions = new ArrayList<>();
        fractions.add( new Fraction( 1.0 ,2.0  ) );
        fractions.add( new Fraction( 3.0 ,4.0 ) );
        fractions.add( new Fraction( 10.0 ,3.0 ) );
        fractions.forEach(consummer);
        System.out.println(fractions);
    }

    public static void testPredicate ( Supplier<Integer> supplier) {
        if ( supplier == null ) {
            throw new RuntimeException();
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < BORNE_MAX; i ++) {
            integers.add(supplier.get());
        }
        System.out.println(integers);
        // ici j'ai mis 30 parce que je reutilise le supplier fait plus
        // haut, je trouve qu'avoir un predicat a "< 30" est plus interessant
        // et plus facile pour montrer que le predicat fonctionne !
        Predicate<Integer> predicate = x -> x < 30;
        integers.removeIf(predicate);

        System.out.println(integers);
    }

    public static void testFunction () {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("bonjour");
        strings.add("ca va");
        strings.add("allo");
        strings.add("bonne nuit");
        strings.add(":///");

        Function<ArrayList<String>, String> lambda = (list ) -> {
            String retour = "";
            for (int i = 0; i < list.size()-1; i ++) {
                retour += list.get(i) + ", ";
            }
            retour += list.get(list.size()-1);
            return retour;
        };
        System.out.println(lambda.apply(strings));

    }
}
