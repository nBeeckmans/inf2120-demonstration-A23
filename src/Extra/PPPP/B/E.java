package Extra.PPPP.B;

import Extra.PPPP.A;
public class E extends A {

    // montre qu'on y a quand meme acces !
    public int methode(int i) {
        super.setA(i);
        return super.getA();
    }
}
