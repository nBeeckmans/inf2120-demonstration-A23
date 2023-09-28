package TypeGenerique.ArrayList;

import java.util.ArrayList;

public class Principale {
    public static void main(String[] args) {
        System.out.println(tweens(0, 12, 6));
        System.out.println(tweens(0, 12, 0));
    }
    public static ArrayList<Double> tweens(double depart, double fin, int nbrInterval ){
        int tailleTableau = nbrInterval + 1;
        ArrayList<Double> tableau = new ArrayList<>(tailleTableau);
        double ecart = nbrInterval != 0
                ? (fin - depart) / nbrInterval
                : 0;

        for (int i = 0; i < tailleTableau; i++){
            tableau.add(depart);
            depart += ecart;
        }
        return tableau;
    }
}
