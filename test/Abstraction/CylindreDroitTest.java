package Abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CylindreDroitTest {


    @Test
    void exceptionConstructeurHauteurInvalide() {
        assertThrows(RuntimeException.class,() -> new CylindreDroit(new Cercle(1), -1));
    }
    @Test
    void aire0() {
        Forme3D forme = new CylindreDroit(new Rectangle(0, 0),0);
        double attendu = 0;
        assertEquals(attendu, forme.volume());
    }
    @Test
    void aire2() {
        Forme3D forme = new CylindreDroit(new Cercle(2),2);
        double attendu = 8 * Math.PI;
        assertEquals(attendu, forme.volume());
    }

}