package Extra.IterableIterator;

import java.util.Iterator;

public class ContenantDeInteger implements Iterable<Integer> {
    Integer[] tableCirculaire = new Integer[30];
    int compteurElement=0;
    private class Parcoureur implements Iterator<Integer> {
        int indice = 0;
        @Override
        public boolean hasNext() {
            return (indice +1) < tableCirculaire.length;
        }

        @Override
        public Integer next() {
            return tableCirculaire[++indice];
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Parcoureur();
    }

    public void add(Integer i) {
        tableCirculaire [++compteurElement < tableCirculaire.length
                ? compteurElement
                : (compteurElement = 0)] = i;
    }

    /**
     * public void add(Integer i) {
     *     compteurElement += 1;
     *     if (compteurElement < tableCirculaire.length) {
     *         tableCirculaire[compteurElement] = i;
     *     } else {
     *         compteurElement = 0;
     *         tableCirculaire[compteurElement] = i;
     *     }
     * }
     */
}