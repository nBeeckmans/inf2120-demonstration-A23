package Extra.LambdaSorts;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class Principale  {

    static BiConsumer<ArrayList<Integer>, Integer> bubbleSort = ( list, indice) -> {
        extracted(list, indice);
    };

    private static void extracted(ArrayList<Integer> list, Integer indice) {
        int length = list.size();
        for (int i = 0; i < length - indice - 1; i++ ){
            if ( list.get(i) > list.get(i+1)) {
                Integer temporaire = list.get(i+1);
                list.set(i + 1, list.get(i));
                list.set(i, temporaire);
            }
        }
    }


    static BiConsumer<ArrayList<Integer>, Integer> selectionSort = ( list, indice ) -> {
        int indiceMinimum = indice;
        int length = list.size();
        for ( int i = indice + 1; i < length; i ++) {
            if (list.get(i) < list.get(indiceMinimum)) {
                indiceMinimum = i;
            }
        }
        if ( indiceMinimum != indice) {
            Integer temporaire = list.get(indice);
            list.set(indice, list.get(indiceMinimum));
            list.set(indiceMinimum, temporaire);
        }};

    public static void main( String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        {
            list1.add(1);
            list1.add(2);
            list1.add(7);
            list1.add(4);
            list1.add(10);
            list1.add(0);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        {
            list2.add(1);
            list2.add(2);
            list2.add(7);
            list2.add(4);
            list2.add(10);
            list2.add(0);
        }
        System.out.println(list1);
        System.out.println(list2);

        sort(list1,bubbleSort);
        sort(list2,selectionSort);

        System.out.println(list1);
        System.out.println(list2);

    }


    public static<T extends Comparable<T>> void sort
            (ArrayList<T> list, BiConsumer<ArrayList<T>, Integer> boucleInterne ) {

        int length = list.size() - 1;
        for ( int i = 0; i < length; i ++) {
            boucleInterne.accept(list, i);
        }
    }
}
