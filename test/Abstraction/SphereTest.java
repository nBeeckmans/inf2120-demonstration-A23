package Abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SphereTest {

    @Test
    void exceptionConstructeur() {
        assertThrows(RuntimeException.class,() -> new Sphere(-1));
    }
    @Test
    void aire0() {
        Forme3D forme = new Sphere(0);
        double attendu = 0;
        assertEquals(attendu, forme.volume());
    }
    @Test
    void aire2() {
        Forme3D forme = new Sphere(2);
        double attendu = 4.0/3.0 * 8 * Math.PI;
        assertEquals(attendu, forme.volume());
    }

}