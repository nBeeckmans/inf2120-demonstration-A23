package Extra.IterableIterator;

import java.util.Iterator;

public class Principale {
    public static void main(String[] args) {
        ContenantDeInteger c = new ContenantDeInteger();

        for( int i = 0; i <= 200; i ++ ) {
            c.add(i);
        }

        for (Integer i : c ) {
            System.out.println(i);
        }

        while(c.iterator().hasNext()){
            System.out.println(c.iterator().next());
        }
    }
}
