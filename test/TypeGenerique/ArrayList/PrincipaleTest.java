package TypeGenerique.ArrayList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static TypeGenerique.ArrayList.Principale.tweens;
import static org.junit.jupiter.api.Assertions.*;

class PrincipaleTest {

    @Test
    void tweens_0_0_0() {
        ArrayList<Double> attendu = new ArrayList<>(List.of(0.0));
        ArrayList<Double> obtenu = tweens(0,0,0);
        assertEquals(attendu, obtenu);
    }
    @Test
    void tweens_0_0_1() {
        ArrayList<Double> attendu = new ArrayList<>(Arrays.asList(0.0,0.0));
        ArrayList<Double> obtenu = tweens(0,0,1);
        assertEquals(attendu, obtenu);
    }
    @Test
    void tweens_0_1_1() {
        ArrayList<Double> attendu = new ArrayList<>(Arrays.asList(0.0,1.0));
        ArrayList<Double> obtenu = tweens(0,1,1);
        assertEquals(attendu, obtenu);
    }
    @Test
    void tweens_1_1_1() {
        ArrayList<Double> attendu = new ArrayList<>(Arrays.asList(1.0,1.0));
        ArrayList<Double> obtenu = tweens(1,1,1);
        assertEquals(attendu, obtenu);
    }
    @Test
    void tweens_0_1_5_PasCorrect() {
        ArrayList<Double> attendu = new ArrayList<>(Arrays.asList(0.0,0.2,0.4,0.6,0.8,1.0));
        ArrayList<Double> obtenu = tweens(0,1,5);
        assertEquals(attendu, obtenu);
    }
    @Test
    void tweens_0_1_5_Correct() {
        double[] attendu = {0.0,0.2,0.4,0.6,0.8,1.0};
        Double[] obtenu = new Double[6];

        assertArrayEquals(
                attendu,
                enPrimitif(tweens(0,1,5).toArray(obtenu)),
                0.0001);
    }

    private double[] enPrimitif(Double[] tableau) {
        double[] tableauRetour = new double[tableau.length];
        for (int i =0; i < tableau.length; i ++) {
            Double element = tableau[i];
            if (element != null)
                tableauRetour[i] = tableau[i];
        }
        return tableauRetour;
    }

    @Test
    void tweens_1_2_1_Correct() {
        ArrayList<Double> attendu = new ArrayList<>(Arrays.asList(1.0,2.0));
        ArrayList<Double> obtenu = tweens(1,2,1);
        assertEquals(attendu, obtenu);
    }
    @Test
    void tweens_negatif_1_positif_2_1_Correct() {
        ArrayList<Double> attendu = new ArrayList<>(Arrays.asList(-1.0,2.0));
        ArrayList<Double> obtenu = tweens(-1,2,1);
        assertEquals(attendu, obtenu);
    }

    @Test
    void tweens_negatif_1_negatif_2_1_Correct() {
        ArrayList<Double> attendu = new ArrayList<>(Arrays.asList(-1.0,-2.0));
        ArrayList<Double> obtenu = tweens(-1,-2,1);
        assertEquals(attendu, obtenu);
    }

}