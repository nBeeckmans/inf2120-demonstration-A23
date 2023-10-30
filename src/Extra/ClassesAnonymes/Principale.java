package Extra.ClassesAnonymes;

public class Principale {

    public static void main (String []args) {
        InterfaceFonctionnelle iF = new InterfaceFonctionnelle() {
            @Override
            public void methode() {
                System.out.println("test");
            }
        };

        iF.methode();
    }
}
