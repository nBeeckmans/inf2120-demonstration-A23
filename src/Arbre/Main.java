package Arbre;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args){

    }

    public static <T extends Comparable<T>> void tri (ArrayList<T> list){
        ArbreBinaire<T> arbre = new ArbreBinaire<>();
        while( !list.isEmpty() ){
            arbre.inserer(list.removeFirst());
        }
        arbre.remplirOrdonne(list);
    }
}
