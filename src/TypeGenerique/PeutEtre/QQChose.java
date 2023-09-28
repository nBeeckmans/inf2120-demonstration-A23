package TypeGenerique.PeutEtre;

public class QQChose <T> extends PeutEtre<T> {
    protected T valeur;
    public QQChose( T a_valeur ){
        valeur = a_valeur;
    }

    @Override
    public boolean estQQChose(){
        return true;
    }
    @Override
    public boolean estRien(){
        return false;
    }
    @Override
    public T qQChose() throws ARien{
        return valeur;
    }
}