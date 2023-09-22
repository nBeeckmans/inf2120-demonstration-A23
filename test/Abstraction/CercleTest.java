package Abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CercleTest {

    @Test
    void exceptionConstructeur() {
        assertThrows(RuntimeException.class,() -> new Cercle(-1));
    }
    @Test
    void aire0() {
        Forme2D forme = new Cercle(0);
        double attendu = 0;
        assertEquals(attendu, forme.aire());
    }
    @Test
    void aire2() {
        Forme2D forme = new Cercle(2);
        double attendu = 4 * Math.PI;
        assertEquals(attendu, forme.aire());
    }

    @Test
    void testToString() {
        Forme2D forme = new Cercle(0);
        String attendu = Forme2D.DEBUT_MESSAGE + "cercle de rayon : 0.0";
        assertEquals(attendu, forme.toString());
    }
}