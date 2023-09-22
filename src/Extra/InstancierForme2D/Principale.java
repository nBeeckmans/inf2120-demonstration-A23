package Extra.InstancierForme2D;

import Abstraction.*;

public class Principale {
    public static void main(String[] args) {
        Forme2D petitCarre = new Forme2D() {
            private double cote = 2.0;

            //N'existe pas dans la classe Forme2D !
            //On ne peut donc pas y avoir acces !
            public void setCote(double cote) {
                this.cote = cote;
            }

            @Override
            public double aire() {
                return cote * cote;
            }
        };


        System.out.println(petitCarre.aire());
        System.out.println(petitCarre.getClass());
    }
}
