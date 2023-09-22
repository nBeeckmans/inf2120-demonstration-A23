package Abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    @Test
    void exceptionConstructeurBaseInvalide() {
        assertThrows(RuntimeException.class,() -> new Rectangle(-1, 2));
    }

    @Test
    void exceptionConstructeurHauteurInvalide() {
        assertThrows(RuntimeException.class,() -> new Rectangle(2, -1));

    }
    @Test
    void exceptionConstructeurHauteurEtBaseInvalides() {
        assertThrows(RuntimeException.class,() -> new Rectangle(-1, -1));
    }
    @Test
    void aire0() {
        Forme2D forme = new Rectangle(0,0);
        double attendu = 0;
        assertEquals(attendu, forme.aire());
    }
    @Test
    void aireB2H4() {
        Forme2D forme = new Rectangle(2,4);
        double attendu = 8;
        assertEquals(attendu, forme.aire());
    }

    @Test
    void testToString() {
        Forme2D forme = new Rectangle(0,0);
        String attendu = Forme2D.DEBUT_MESSAGE + "Rectangle de base : 0.0 et de hauteur : 0.0";
        assertEquals(attendu, forme.toString());
    }
}