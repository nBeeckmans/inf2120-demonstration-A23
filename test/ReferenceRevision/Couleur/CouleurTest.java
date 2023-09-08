package ReferenceRevision.Couleur;

import static org.junit.jupiter.api.Assertions.*;

class CouleurTest {

    @org.junit.jupiter.api.Test
    void blanchirBlanc() {
        Couleur blanc = new Couleur(255,255,255);
        blanc.blanchir();
        assertEquals(255, blanc.getBleu());
        assertEquals(255, blanc.getRouge());
        assertEquals(255, blanc.getVert());
    }

    @org.junit.jupiter.api.Test
    void testMain() {
        Couleur c1 = new Couleur(1, 200, 6);
        Couleur c2 = c1;
        c2.setRouge(100);
        assertEquals(c1.getRouge(), c2.getRouge());
    }
}