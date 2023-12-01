package Arbre;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Arbre.Main.tri;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    static ArrayList<Integer> liste = new ArrayList<>();

    @BeforeAll
    static void remplirListe(){
        liste.add(1);
        liste.add(12);
        liste.add(4);
        liste.add(0);
        liste.add(-1);
        liste.add(3);
        liste.add(6);
    }

    @Test
    void testTri() {
        tri(liste);

        assertArrayEquals(liste.toArray(), new Integer[]{
                -1,0,1,3,4,6,12
        });
    }
}