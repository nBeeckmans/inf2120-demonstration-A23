package TDAfile;

import TDAfile.FileSimple;
import TDAfile.FileVide;

public class Main
{
    public static void main(String[] args) {
        testSimple();
        testDur();
    }

    public static void testSimple(){
        System.out.println("test file simple :");
        FileSimple<Integer> file = new FileSimple<>();

        System.out.println(file.taille());
        System.out.println(file.estVide());

        file.enfiler(1);
        file.enfiler(2);
        file.enfiler(3);
        file.enfiler(4);
        file.enfiler(5);

        System.out.println(file.taille());
        System.out.println(file.estVide());


        // on enleve 2 elements
        System.out.println("on enleve 2 elements");
        try {
            System.out.println(file.defiler());
            System.out.println(file.defiler());
        } catch (FileVide fv) {
            System.out.println("doit pas arriver");
        }

        System.out.println("taille : " + file.taille());

        System.out.println("on vide la file");
        try {
            while ( !file.estVide() ) {
                System.out.println(file.defiler());
            }
        } catch ( FileVide fv ){
            System.out.println("pardon ?");
        }
        System.out.println("--------------------------");
    }

    public static void testDur() {
        System.out.println("test file simple :");
        File<Integer> file = new File<>();
        System.out.println(file.taille());
        System.out.println(file.estVide());

        file.enfiler(1);
        file.enfiler(2);
        file.enfiler(3);
        file.enfiler(4);
        file.enfiler(5);

        System.out.println(file.taille());
        System.out.println(file.estVide());


        // on enleve 2 elements
        System.out.println("on enleve 2 elements");
        try {
            System.out.println(file.defiler());
            System.out.println(file.defiler());
        } catch (FileVide fv) {
            System.out.println("doit pas arriver");
        }

        System.out.println("taille : " + file.taille());

        System.out.println("on vide la file");
        try {
            while ( !file.estVide() ) {
                System.out.println(file.defiler());
            }
        } catch ( FileVide fv ){
            System.out.println("pardon ?");
        }

        System.out.println("--------------------------");
    }
}
