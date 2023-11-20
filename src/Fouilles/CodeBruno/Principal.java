package Fouilles.CodeBruno;

import Extra.ClassesAnonymes.InterfaceFonctionnelle;

import java.util.Arrays;
import java.util.Random;

public class Principal {

    // SELECTION :

    /**
     * Methode statique pour trier un tableau.  Utilise le tri selection.
     * meilleur cas : $\mathcal{O}(n^2)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triSelection( E [] tab ) {
        triSelection( tab, 0, tab.length - 1 );
    }

    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri selection.
     * meilleur cas : $\mathcal{O}(n^2)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triSelection( E [] tab, int debut, int fin ) {
        for( int i = debut; i < fin; ++ i ) {
            int position = i;
            E minimum = tab[i];

            for( int j = i + 1; j <= fin; ++ j ) {
                if( tab[j].compareTo( minimum ) < 0 ) {
                    position = j;
                    minimum = tab[j];
                }
            }

            tab[position] = tab[i];
            tab[i] = minimum;
        }
    }

    // INSERTION :

    /**
     * Methode statique pour trier un tableau.  Utilise le tri insertion.
     * meilleur cas : $\mathcal{O}(n)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triInsertion( E [] tab ) {
        triInsertion( tab, 0, tab.length - 1 );
    }

    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri insertion.
     * meilleur cas : $\mathcal{O}(n)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triInsertion( E [] tab, int debut, int fin ) {
        for( int i = debut + 1; i <= fin; ++ i ) {
            int j = i - 1;
            E temp = tab[i];
            while( j >= debut && tab[j].compareTo(temp) > 0 ) {
                tab[j + 1] = tab[j];
                -- j;
            }
            tab[j + 1] = temp;
        }
    }

    // BULLE :

    /**
     * Methode statique pour trier un tableau.  Utilise le tri bulle.
     * meilleur cas : $\mathcal{O}(n)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triBulle( E [] tab ) {
        triBulle( tab, 0, tab.length - 1 );
    }

    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri bulle.
     * meilleur cas : $\mathcal{O}(n)$
     * cas moyen    : $\mathcal{O}(n^2)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triBulle( E [] tab, int debut, int fin ) {
        boolean estTrie = false;

        while( ! estTrie ) {
            estTrie = true;
            for( int i = debut; i < fin; ++ i ) {
                if( tab[i].compareTo( tab[i + 1] ) > 0 ) {
                    E temp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = temp;
                    estTrie = false;
                }
            }
            -- fin;
        }
    }

    // RAPIDE :

    /**
     * Methode statique pour trier un tableau.  Utilise le tri rapide.
     * meilleur cas : $\mathcal{O}(n \log n)$
     * cas moyen    : $\mathcal{O}(n \log n)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triRapide( E [] tab ) {
        triRapide( tab, 0, tab.length - 1 );
    }

    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri rapide.
     * meilleur cas : $\mathcal{O}(n \log n)$
     * cas moyen    : $\mathcal{O}(n \log n)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triRapide( E [] tab, int debut, int fin ) {
        if( debut < fin ) {
            E pivot = tab[ ( debut + fin ) / 2 ];
            int i = debut - 1;
            int j = fin + 1;

            while( i < j ) {
                do -- j; while( tab[j].compareTo( pivot ) > 0 );
                do ++ i; while( tab[i].compareTo( pivot ) < 0 );

                if( i < j ) {
                    E temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                }
            }

            triRapide( tab, debut, j );
            triRapide( tab, j + 1, fin );
        }
    }



    // PLUS RAPIDE :

    /**
     * Constante indiquant la taille en dessous de laquel l'algorithem de triPlusRapide
     * utilisera un tri different pour trier le tableau.
     */
    private static int BARRIERE = 5;

    /**
     * Methode statique pour trier un tableau.  Utilise le tri rapide ameliore.
     * Lorsque le tableau devient petit, un tri different est utilise.
     * La taille a laquel un tri different est utilise est indique par la constante
     * BARRIERE.
     * meilleur cas : $\mathcal{O}(n \log n)$
     * cas moyen    : $\mathcal{O}(n \log n)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     */
    public static < E extends Comparable< E > > void triPlusRapide( E [] tab) {
        triPlusRapide( tab, 0, tab.length - 1 );
    }


    /**
     * Methode statique pour trier une sous section d'un tableau.  Utilise le tri rapide ameliore.
     * Lorsque le tableau devient petit, un tri different est utilise.
     * La taille a laquel un tri different est utilise est indique par la constante
     * BARRIERE.
     * meilleur cas : $\mathcal{O}(n \log n)$
     * cas moyen    : $\mathcal{O}(n \log n)$
     * pire cas     : $\mathcal{O}(n^2)$
     * @param tab
     *   Le tableau a trier.
     *   tab != null
     * @param debut
     *   Indice du premier element du sous tableau qui sera trie.
     *   0 <= debut < tab.length - 1
     * @param fin
     *   Indice du dernier element du sous tableau qui sera trie.
     *   0 < fin < tab.length
     *   debut <= fin
     */
    public static < E extends Comparable< E > > void triPlusRapide( E [] tab, int debut, int fin ) {
        if( debut < fin - BARRIERE ) {
            E pivot = tab[ ( debut + fin ) / 2 ];
            int i = debut - 1;
            int j = fin + 1;

            while( i < j ) {
                do -- j; while( tab[j].compareTo( pivot ) > 0 );
                do ++ i; while( tab[i].compareTo( pivot ) < 0 );

                if( i < j ) {
                    E temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                }
            }

            triPlusRapide( tab, debut, j );
            triPlusRapide( tab, j + 1, fin );
        } else if( debut < fin ) {
            triInsertion( tab, debut, fin );
        }
    }
    public static < E extends Comparable< E > > void triPlusRapide( E [] tab, int debut,
                                                                    int fin, TriConsumer<E> consumer) {
        if( debut < fin - BARRIERE ) {
            E pivot = tab[ ( debut + fin ) / 2 ];
            int i = debut - 1;
            int j = fin + 1;

            while( i < j ) {
                do -- j; while( tab[j].compareTo( pivot ) > 0 );
                do ++ i; while( tab[i].compareTo( pivot ) < 0 );

                if( i < j ) {
                    E temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                }
            }

            triPlusRapide( tab, debut, j );
            triPlusRapide( tab, j + 1, fin );
        } else if( debut < fin ) {
            consumer.accept( tab, debut, fin);
        }
    }

    // TESTS :
    /**
     * Methode de test de charge pour le triPlusRapide.
     * ( test de charge : avec beaucoup d'elements )
     * Cette methode affiche le temps d'execution du tri en nanoseconde.
     * Attention : la precision de cette valeur est garanti jusqu'au milliseconde.
     * La methode va aussi verifier si le tableau resultant est trie.
     * Un message d'erreur est affiche pour chaque case non trie.
     */
    public static void testCharge() {
        final int TAILLE = 1_000_00_000;
        // construire un grand tableau de valeur aleatoire :
        Integer [] tab5 = ( new Random( 0 ).ints( TAILLE ).boxed().toArray( Integer[]::new ) );

        // trier et afficher le temps d'execution.
        long tempDebut = System.nanoTime();
        triPlusRapide( tab5 );
        long tempsExecution = System.nanoTime() - tempDebut;
        System.out.println( ( tempsExecution / 1_000_000_000 ) + " sec " + ( ( tempsExecution / 1000000 ) % 1000 ) + " millis " + ( ( tempsExecution / 1000 ) % 1000 ) + " micros " + ( tempsExecution % 1000 ) + " nanos" );

        // Verifier s'il y a une erreur de trie :
        boolean estTrie = true;
        for( int i = 0; i < tab5.length - 1; ++ i ) {
            if( tab5[i].compareTo( tab5[i + 1] ) > 0 ) {
                estTrie = false;
                System.err.println( "Erreur : valeur a la case " + i + " plus grande que celle a la case " + ( i + 1 ) );
            }
        }
        if( estTrie ) {
            System.out.println( "Le triPlusRapide fonctionne correctement pour ce tableau." );
        }
    }
    public static <E extends Comparable<E> > void testCharge(final int TAILLE) {
        // construire un grand tableau de valeur aleatoire :
        Integer [] tab5 = ( new Random( 0 ).ints( TAILLE ).boxed().toArray( Integer[]::new ) );

        // trier et afficher le temps d'execution.
        long tempDebut = System.nanoTime();
        triPlusRapide( tab5);
        long tempsExecution = System.nanoTime() - tempDebut;
        System.out.println( ( tempsExecution / 1_000_000_000 ) + " sec " + ( ( tempsExecution / 1000000 ) % 1000 ) + " millis " + ( ( tempsExecution / 1000 ) % 1000 ) + " micros " + ( tempsExecution % 1000 ) + " nanos" );

        // Verifier s'il y a une erreur de trie :
        boolean estTrie = true;
        for( int i = 0; i < tab5.length - 1; ++ i ) {
            if( tab5[i].compareTo( tab5[i + 1] ) > 0 ) {
                estTrie = false;
                System.err.println( "Erreur : valeur a la case " + i + " plus grande que celle a la case " + ( i + 1 ) );
            }
        }
        if( estTrie ) {
            System.out.println( "Le triPlusRapide fonctionne correctement pour ce tableau." );
        }
    }

    public static < E extends Comparable< E > > void triPlusRapide( E [] tab, TriConsumer<E> consumer) {
        triPlusRapide( tab, 0, tab.length - 1, consumer);
    }
    public static <E extends Comparable<E> > void testCharge(final int TAILLE, TriConsumer<Integer> consumer) {
        // construire un grand tableau de valeur aleatoire :
        Integer [] tab5 = ( new Random( 0 ).ints( TAILLE ).boxed().toArray( Integer[]::new ) );

        // trier et afficher le temps d'execution.
        long tempDebut = System.nanoTime();
        triPlusRapide( tab5, consumer);
        long tempsExecution = System.nanoTime() - tempDebut;
        System.out.println( ( tempsExecution / 1_000_000_000 ) + " sec " + ( ( tempsExecution / 1000000 ) % 1000 ) + " millis " + ( ( tempsExecution / 1000 ) % 1000 ) + " micros " + ( tempsExecution % 1000 ) + " nanos" );

        // Verifier s'il y a une erreur de trie :
        boolean estTrie = true;
        for( int i = 0; i < tab5.length - 1; ++ i ) {
            if( tab5[i].compareTo( tab5[i + 1] ) > 0 ) {
                estTrie = false;
                System.err.println( "Erreur : valeur a la case " + i + " plus grande que celle a la case " + ( i + 1 ) );
            }
        }
        if( estTrie ) {
            System.out.println( "Le triPlusRapide fonctionne correctement pour ce tableau." );
        }
    }


    // MAIN :

    public static void main(String[] args) {
        System.out.println(" tests de bases ");
        testCharge(10_000);
        testCharge(100_000);
        testCharge(1_000_000);
        testCharge(10_000_000);

        testsBarrieresInsertion();
        testsBarrieresSelection();
        testsBarrieresBulle();
        testsAlgoJava();
    }

    public static void testsAlgoJava(){
        System.out.println(" tests de bases, barriere : 0 ");
        BARRIERE = 0;
        testCharge(10_000, Arrays::sort);
        testCharge(100_000, Arrays::sort);
        testCharge(1_000_000, Arrays::sort);
        testCharge(10_000_000, Arrays::sort);

        System.out.println(" tests de bases, barriere : 5 ");
        BARRIERE = 5;
        testCharge(10_000, Arrays::sort);
        testCharge(100_000, Arrays::sort);
        testCharge(1_000_000, Arrays::sort);
        testCharge(10_000_000, Arrays::sort);

        System.out.println(" tests de bases, barriere : 10 ");
        BARRIERE = 10;
        testCharge(10_000, Arrays::sort);
        testCharge(100_000, Arrays::sort);
        testCharge(1_000_000, Arrays::sort);
        testCharge(10_000_000, Arrays::sort);

        System.out.println(" tests de bases, barriere : 15 ");
        BARRIERE = 15;
        testCharge(10_000, Arrays::sort);
        testCharge(100_000, Arrays::sort);
        testCharge(1_000_000, Arrays::sort);
        testCharge(10_000_000, Arrays::sort);

        System.out.println(" tests de bases, barriere : 20 ");
        BARRIERE = 20;
        testCharge(10_000, Arrays::sort);
        testCharge(100_000, Arrays::sort);
        testCharge(1_000_000, Arrays::sort);
        testCharge(10_000_000, Arrays::sort);

        System.out.println(" tests de bases, barriere : 25 ");
        BARRIERE = 25;
        testCharge(10_000, Arrays::sort);
        testCharge(100_000, Arrays::sort);
        testCharge(1_000_000, Arrays::sort);
        testCharge(10_000_000, Arrays::sort);
    }
    public static void testsBarrieresSelection(){
        System.out.println(" tests de bases, barriere : 0 ");
        BARRIERE = 0;
        testCharge(10_000, Principal::triSelection);
        testCharge(100_000, Principal::triSelection);
        testCharge(1_000_000, Principal::triSelection);
        testCharge(10_000_000, Principal::triSelection);

        System.out.println(" tests de bases, barriere : 5 ");
        BARRIERE = 5;
        testCharge(10_000, Principal::triSelection);
        testCharge(100_000, Principal::triSelection);
        testCharge(1_000_000, Principal::triSelection);
        testCharge(10_000_000, Principal::triSelection);

        System.out.println(" tests de bases, barriere : 10 ");
        BARRIERE = 10;
        testCharge(10_000, Principal::triSelection);
        testCharge(100_000, Principal::triSelection);
        testCharge(1_000_000, Principal::triSelection);
        testCharge(10_000_000, Principal::triSelection);

        System.out.println(" tests de bases, barriere : 15 ");
        BARRIERE = 15;
        testCharge(10_000, Principal::triSelection);
        testCharge(100_000, Principal::triSelection);
        testCharge(1_000_000, Principal::triSelection);
        testCharge(10_000_000, Principal::triSelection);

        System.out.println(" tests de bases, barriere : 20 ");
        BARRIERE = 20;
        testCharge(10_000, Principal::triSelection);
        testCharge(100_000, Principal::triSelection);
        testCharge(1_000_000, Principal::triSelection);
        testCharge(10_000_000, Principal::triSelection);

        System.out.println(" tests de bases, barriere : 25 ");
        BARRIERE = 25;
        testCharge(10_000, Principal::triSelection);
        testCharge(100_000, Principal::triSelection);
        testCharge(1_000_000, Principal::triSelection);
        testCharge(10_000_000, Principal::triSelection);
    }
    public static void testsBarrieresBulle(){
        System.out.println(" tests de bases, barriere : 0 ");
        BARRIERE = 0;
        testCharge(10_000, Principal::triBulle);
        testCharge(100_000, Principal::triBulle);
        testCharge(1_000_000, Principal::triBulle);
        testCharge(10_000_000, Principal::triBulle);

        System.out.println(" tests de bases, barriere : 5 ");
        BARRIERE = 5;
        testCharge(10_000, Principal::triBulle);
        testCharge(100_000, Principal::triBulle);
        testCharge(1_000_000, Principal::triBulle);
        testCharge(10_000_000, Principal::triBulle);

        System.out.println(" tests de bases, barriere : 10 ");
        BARRIERE = 10;
        testCharge(10_000, Principal::triBulle);
        testCharge(100_000, Principal::triBulle);
        testCharge(1_000_000, Principal::triBulle);
        testCharge(10_000_000, Principal::triBulle);

        System.out.println(" tests de bases, barriere : 15 ");
        BARRIERE = 15;
        testCharge(10_000, Principal::triBulle);
        testCharge(100_000, Principal::triBulle);
        testCharge(1_000_000, Principal::triBulle);
        testCharge(10_000_000, Principal::triBulle);

        System.out.println(" tests de bases, barriere : 20 ");
        BARRIERE = 20;
        testCharge(10_000, Principal::triBulle);
        testCharge(100_000, Principal::triBulle);
        testCharge(1_000_000, Principal::triBulle);
        testCharge(10_000_000, Principal::triBulle);

        System.out.println(" tests de bases, barriere : 25 ");
        BARRIERE = 25;
        testCharge(10_000, Principal::triBulle);
        testCharge(100_000, Principal::triBulle);
        testCharge(1_000_000, Principal::triBulle);
        testCharge(10_000_000, Principal::triBulle);
    }
    public static void testsBarrieresInsertion(){
        // 0, 5, 10, 15, 20 et 25
        System.out.println(" tests de bases, barriere : 0 ");
        BARRIERE = 0;
        testCharge(10_000);
        testCharge(100_000);
        testCharge(1_000_000);
        testCharge(10_000_000);

        System.out.println(" tests de bases, barriere : 5 ");
        BARRIERE = 5;
        testCharge(10_000);
        testCharge(100_000);
        testCharge(1_000_000);
        testCharge(10_000_000);

        System.out.println(" tests de bases, barriere : 10 ");
        BARRIERE = 10;
        testCharge(10_000);
        testCharge(100_000);
        testCharge(1_000_000);
        testCharge(10_000_000);

        System.out.println(" tests de bases, barriere : 15 ");
        BARRIERE = 15;
        testCharge(10_000);
        testCharge(100_000);
        testCharge(1_000_000);
        testCharge(10_000_000);

        System.out.println(" tests de bases, barriere : 20 ");
        BARRIERE = 20;
        testCharge(10_000);
        testCharge(100_000);
        testCharge(1_000_000);
        testCharge(10_000_000);

        System.out.println(" tests de bases, barriere : 25 ");
        BARRIERE = 25;
        testCharge(10_000);
        testCharge(100_000);
        testCharge(1_000_000);
        testCharge(10_000_000);
    }

    public interface TriConsumer <E>{
        void accept(E [] tab, int debut, int fin);
    }
}
