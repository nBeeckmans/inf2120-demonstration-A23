package Extra.Copyable.Surface;

import java.util.ArrayList;
import java.util.Optional;

public class Principale {

    public static void main(String[] args){
        Facture f1 = new Facture();
        f1.ajouterProduit(new NonTaxable("test", 1));
        f1.ajouterProduit(new TaxeSimple("truc", 2));
        f1.ajouterProduit(new TaxeDouble("chose", 3));
        Facture f2 = f1.copier();

        f2.get(2).setPrix(99);
        System.out.println(f1.get(2));
    }

}
