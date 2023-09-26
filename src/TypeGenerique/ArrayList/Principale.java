package TypeGenerique.ArrayList;

import java.util.ArrayList;

public class Principale {
    public static void main(String[] args) {
        System.out.println(tweens(0, 12, 6));
        System.out.println(tweens(0, 12, 0));
    }
    public static ArrayList<Double> tweens(double depart, double fin, int nbrInterval ){
        ArrayList<Double> tableau = new ArrayList<>(nbrInterval + 1);
        double ecart = (fin - depart) / nbrInterval;
        tableau.add(depart);

        while(depart < fin){
            depart += ecart;
            tableau.add(depart);
        }
        return tableau;
    }
}
