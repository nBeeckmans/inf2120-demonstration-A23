package TypeGenerique.PeutEtre;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static TypeGenerique.PeutEtre.Principale.trouverElement;
import static TypeGenerique.PeutEtre.Principale.trouverElementOptional;
import static org.junit.jupiter.api.Assertions.*;

class PrincipaleTest {

    Integer[] tableau = { 0, 1, 2, 3, 5};

    @Test
    void trouverElementTrouve() throws ARien {
        PeutEtre<Integer> attendu = new QQChose<>(1);
        Integer cherche = 1;
        PeutEtre<Integer> obtenu = trouverElement(tableau, cherche);
        assertEquals(attendu.qQChose(), obtenu.qQChose());
    }
    @Test
    void trouverElementPasTrouve() {
        PeutEtre<Integer> attendu = new Rien<>();
        Integer cherche = 6;
        PeutEtre<Integer> obtenu = trouverElement(tableau, cherche);
        assertEquals(attendu.estRien(), obtenu.estRien());
    }

    @Test
    void trouverElementOptionalTrouve() {
        Optional<Integer> attendu = Optional.of(1);
        Integer cherche = 1;
        Optional<Integer> obtenu = trouverElementOptional(tableau, cherche);
        assertEquals(attendu.get(), obtenu.get());
    }
    @Test
    void trouverElementOptionalPasTrouve() {
        Optional<Integer> attendu = Optional.empty();
        Integer cherche = 6;
        Optional<Integer> obtenu = trouverElementOptional(tableau, cherche);
        assertEquals(attendu.isEmpty(), obtenu.isEmpty());
    }
}