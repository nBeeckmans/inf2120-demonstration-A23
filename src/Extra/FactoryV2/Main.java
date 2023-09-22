package Extra.FactoryV2;

public class Main {
    public static final int NOMBRE_A_GENERER = 10;
    public static final String NOM_GENERIQUE = "ABC";
    public static final double PRIX_GENERIQUE = 2.00;

    public static void main(String[] args) {
        Facture f1 = new Facture();
        for (int i = 0; i < NOMBRE_A_GENERER; i ++ ) {
            f1.ajouterProduit(usine(i));
        }
        System.out.println("prix total de la facture : " + f1.prixTotal());
    }

    private static Produit usine(int i) {
        return switch (i % 3) {
            case 0 -> new NonTaxable(NOM_GENERIQUE, PRIX_GENERIQUE);
            case 1 -> new TaxeSimple(NOM_GENERIQUE, PRIX_GENERIQUE);
            case 2 -> new TaxeDouble(NOM_GENERIQUE, PRIX_GENERIQUE);
            default -> null;
        };
    }
}
