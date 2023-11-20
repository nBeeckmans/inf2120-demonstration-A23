package TDAPile;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Deque<Character> list = new ArrayDeque<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        Deque<Character> newlist = donnerInverseDeque(list);
        System.out.println("Ancienne liste :" + list);
        System.out.println("Nouvelle liste :" +newlist);
        inverserDeque(newlist);
        System.out.println(newlist);

        System.out.println(parser("{{{{{{{{((((([[[[[testPositif]]]]])))))}}}}}}}}"));
        System.out.println(parser("{{{{{{{((((([[testNegatif]]]])))))}}}}}}}}"));
    }
    public static <T> Deque<T> donnerInverseDeque(Deque<T> pile) {
        Deque<T> retour = new ArrayDeque<>();
        while ( !pile.isEmpty() )
            retour.add(pile.pollLast());

        return retour;
    }

    public static <T> void inverserDeque(Deque<T> pile) {
        Deque<T> temp= donnerInverseDeque(pile);
        while (!temp.isEmpty())
            pile.add(temp.pollFirst());
    }

    public static boolean parser(String text) {
        boolean estValide = true;
        int i = 0;
        Deque<Character> pile = new ArrayDeque<>();

        while(estValide && i < text.length()) {
            char character =  text.charAt(i);

            if ("{([".indexOf(character) >= 0){
                pile.add(character);

            } else if ( "})]".indexOf(character) >= 0) {
                switch(character) {
                    case '}':
                        estValide = ( pile.pollLast() == '{' );
                        break;
                    case ']':
                        estValide = ( pile.pollLast() == '[' );
                        break;
                    case ')':
                        estValide = ( pile.pollLast() == '(' );
                        break;
                }
            }
            i++;
        }
        return estValide && pile.isEmpty();
    }
}
