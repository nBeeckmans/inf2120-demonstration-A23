package Extra.RechercheBinaire;

import java.util.ArrayList;

public class Principale {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(9);
        list.add(11);
        list.add(19);
        list.add(333);
        list.add(70000);

        System.out.println(RechercheBinaire.recherche(list, 19));
        System.out.println(RechercheBinaire.recherche(list, 70000000));

    }
}
