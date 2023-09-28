package TypeGenerique.PeutEtre;

public class Rien <T> extends PeutEtre<T> {

    @Override
    public boolean estQQChose() {
        return false;
    }

    @Override
    public boolean estRien() {
        return true;
    }

    @Override
    public T qQChose() throws ARien {
        throw new ARien();
    }
}
