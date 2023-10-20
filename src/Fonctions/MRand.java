package Fonctions;

import java.util.function.Supplier;

public class MRand implements Supplier<Integer> {
    protected static final long M = 0x1000_0000_0000L;
    protected static final long A = 0x5_DEEC_E66DL;
    protected static final long C = 11L;
    protected static final long MASK = 0x0000_7FFF_FFFF_0000L;
    protected static final int DEC = 16;

    int borneSuperieur = Integer.MAX_VALUE;
    long derniereValeur;

    public MRand() {
        borneSuperieur = Integer.MAX_VALUE;
    }


    public MRand( int borneSuperieur ) {
        if ( borneSuperieur < 0 )
            throw new RuntimeException();

        this.borneSuperieur = borneSuperieur;
    }

    @Override
    public Integer get() {
        derniereValeur = (A * derniereValeur + C) % M;
        return (int) ((derniereValeur & MASK) >> DEC) % borneSuperieur;
    }

}
