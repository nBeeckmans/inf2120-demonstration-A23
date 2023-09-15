package Extra.PPPP;

import Extra.PPPP.B.B;
import Extra.PPPP.B.E;

public class Main {
    public static void main(String[] args) {
        A a = new A3();
        B b = new B();
        D d = new D();
        E e = new E();
        A2 a2 = new A2();
        int i = 2;
        System.out.printf("e.methode(%d) donne : %d\n", i, e.methode(i) );
    }
}
