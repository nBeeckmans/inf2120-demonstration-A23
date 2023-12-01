package Arbre;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbreBinaireTest {

    static ArbreBinaire<Integer> arbreBinaire = new ArbreBinaire<>();
    @BeforeAll
    static void remplirArbre(){
        arbreBinaire.inserer(2);
        arbreBinaire.inserer(1);
        arbreBinaire.inserer(4);
        arbreBinaire.inserer(3);
    }
    @Test
    void hauteurI() {

        System.out.println(arbreBinaire.toString());
        assertEquals( arbreBinaire.hauteurI(2), 0);
        assertEquals( arbreBinaire.hauteurI(1), 1);
        assertEquals( arbreBinaire.hauteurI(4), 1);
        assertEquals( arbreBinaire.hauteurI(3), 2);
        assertEquals( arbreBinaire.hauteurI(0), -1);
    }

    @Test
    void hauteurR() {
        assertEquals( arbreBinaire.hauteurR(2), 0);
        assertEquals( arbreBinaire.hauteurR(1), 1);
        assertEquals( arbreBinaire.hauteurR(4), 1);
        assertEquals( arbreBinaire.hauteurR(3), 2);
        assertEquals( arbreBinaire.hauteurR(7), -1);
    }
}