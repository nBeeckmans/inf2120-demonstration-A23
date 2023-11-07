import java.util.ArrayDeque;
import java.util.Deque;

import Main;

public class Correction {

}

//cette methode respecte le principe d'une pile (mais est alors bcp plus longue)
public static <T> void inverser(Deque<T> pile) {
    Deque<T> temp = donnerInverseDeque(pile);
    temp = donnerInverseDeque(temp);
    // temp est maintenant dans le sens normale !

    // on reutilise la meme technique pour remplir la pile d'origine
    while(!temp.isEmpty())
        pile.add(temp.pollLast());
}
