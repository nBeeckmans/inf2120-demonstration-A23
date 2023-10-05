package Extra.RechercheBinaire;

import java.util.ArrayList;

public class RechercheBinaire {
    public static <T extends Comparable<T>> int recherche(ArrayList<T> list, T objetCherche) {
        int premier = 0;
        int dernier = list.size()-1; //on veut l'indice !
        while( premier < dernier) {
            int milieu = (premier + dernier) / 2;
            if (objetCherche.compareTo(list.get(milieu)) <= 0){
                dernier = milieu;
            } else {
                premier = milieu + 1;
            }
        }
        if (list.get(premier).compareTo(objetCherche) != 0) {
            premier = -1;
        }
        return premier;
    }
}
