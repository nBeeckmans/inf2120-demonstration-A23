package Arbre;

import java.util.ArrayList;

/**
 *
 * Classe d'objets repr�sentant un arbre binaire de recherche.
 * Les elements de l'arbre sont maintenus en ordre selon la
 * methode compareTo des Clef.  Il n'y a aucun algorithme de
 * reequilibrage.
 * Les elements ne sont present qu'une seule fois dans l'arbre.
 * C'est un ensemble.
 * @author Bruno
 *
 * @param <Clef>
 */
public class ArbreBinaire< Clef extends Comparable< Clef > > {
    /**
     * La classe interne Noeud est utilise pour construire les
     * elements des ArbreBinaire.  Les champs sont publique pour
     * permettre leurs utilisations sans get/set afin d'ameliorer
     * les performances.
     * @author Bruno
     *
     * @param <Clef>
     */
    protected class Noeud< Clef > {
        /**
         * Contient la clef d'un noeud.
         */
        public Clef _clef;
        /**
         * Les sous arbres de gauche et de droite.
         * Si une r�f�rence est � null, alors le sous arbre
         * est vide.
         * Le sous arbre gauche contient les clef plus petites
         * que la clef du noeud courrant et le sous arbre de droite
         * contient les clef plus grandes que la clef du noeud
         * courrant.
         */
        public Noeud< Clef > _gauche;
        public Noeud< Clef > _droite;

        /**
         * Constructeur pour un noeud.
         * Les arbre de gauche et droite sont vide.
         * @param clef
         */
        public Noeud( Clef clef ) {
            _clef = clef;
        }

        /**
         * Methode pour afficher un Noeud.  Elle construit la chaine
         * avec un parcours infixe.
         */
        @Override
        public String toString() {
            return
                    "( " +
                            ( ( null == _gauche )
                                    ? "vide"
                                    : _gauche.toString()
                            ) +
                            ", " +
                            _clef.toString() +
                            ", " +
                            ( ( null == _droite )
                                    ? "vide"
                                    : _droite.toString()
                            ) +
                            " )";
        }
    }

    /**
     * Contient la premier Noeud de l'arbre.
     * Si la racine est null, alors l'arbre est vide.
     */
    protected Noeud< Clef > _racine;

    /**
     * Construit un arbre Vide.
     */
    public ArbreBinaire() {
        _racine = null;
    }

    /**
     * Verifie si un arbre est vide.
     * @return true si l'arbre est vide, false sinon.
     */
    public boolean estVide() {
        return null == _racine;
    }

    /**
     * Cette methode recherche une clef dans l'arbre.  Elle
     * retourne une reference sur le noeud trouve et une
     * reference sur son parent.
     *
     * parent  courrant | conclusion
     * -----------------+--------------------------------------
     *  null    null    | l'arbre est vide.
     *  null    ! null  | le noeud trouve est la racine.
     *  ! null  null    | le noeud n'est pas dans l'arbre.
     *  ! null  ! null  | le noeud est trouve et n'est pas la
     *                  | racine.
     * @param clef La clef que le noeud recherche doit contenir.
     *   ne devrait pas etre null.
     * @return Une paire contenant les resultats :
     *   premiere : reference sur le Noeud parent.
     *   deuxieme : reference sur le Noeud trouve.
     */
    private Pair< Noeud< Clef >, Noeud< Clef > >
    rechercheNoeud( Clef clef ) {
        assert null != clef;

        Noeud< Clef > precedant = null;
        Noeud< Clef > courant = _racine;
        int direction;

        do {
            direction = null != courant
                    ? clef.compareTo( courant._clef )
                    : 0;
            // invariant : nous n'avons pas encore trouver le noeud contenant la clef.
            if( direction < 0 ) {
                precedant = courant;
                courant = courant._gauche;
            } else if( direction > 0 ) {
                precedant = courant;
                courant = courant._droite;
            }
        } while( null != courant
                &&
                0 != direction );

        return new Pair< Noeud< Clef >, Noeud< Clef > >( precedant, courant );
    }

    /**
     * supprime le noeud 'courrant' de l'arbre.  Si le noeud 'parent' n'est pas null, il doit
     * avoir le noeud 'courrant' comme enfant.  Sinon, le noeud courrant doit etre la racine.
     * @param parent Le parent du noeud a supprimer, si a null, alors la methode
     *   supprime la racine.
     * @param courant Le noeud a supprimer.  Ne doit pas etre null.
     */
    private void supprimerNoeud( Noeud< Clef > parent,
                                 Noeud< Clef > courant ) {
        assert null != courant;
        assert null == parent
                ? courant == _racine
                : ( parent._gauche == courant || parent._droite == courant );

        if( null == courant._gauche ) {
            // donc : 0 ou 1 enfant a droite.
            if( null == parent ) {
                // donc : suppression de la racine.
                _racine = courant._droite;
            } else {
                // donc : suppression d'un noeud qui n'est pas la racine.
                if( parent._droite == courant ) {
                    // donc : le noeud a supprimer est a droite.
                    parent._droite = courant._droite;
                } else {
                    // donc : le noeud a supprimer est a gauche.
                    parent._gauche = courant._droite;
                }
            }
        } else if( null == courant._droite ) {
            // donc : 1 enfant a gauche.
            if( null == parent ) {
                // donc : suppression de la racine.
                _racine = courant._gauche;
            } else {
                // donc : suppression d'un noeud qui n'est pas la racine.
                if( parent._gauche == courant ) {
                    // donc : le noeud a supprimer est a gauche.
                    parent._gauche = courant._gauche;
                } else {
                    // donc : le noeud a supprimer est a droite.
                    parent._droite = courant._gauche;
                }
            }
        } else {
            // donc : 2 enfants.

            // Trouver le noeud contenant la clef precedant la clef du noeud courrant.
            Noeud< Clef > precedant = courant._gauche;
            Noeud< Clef > parentPrecedant = courant;

            while( null != precedant._droite ) {
                // invariant : il existe une valeur plus grande.
                parentPrecedant = precedant;
                precedant = precedant._droite;
            }

            // Deplacer la clef du noeud precedant vers le noeud courrant.
            courant._clef = precedant._clef;

            // Supprimer le noeud qui contenait la clef precedante.
            if( parentPrecedant == courant ) {
                // Le Noeud a supprimer est directement l'enfant du noeud courrant.
                // donc : le precedant est a gauche de son parent.
                parentPrecedant._gauche = precedant._gauche;
            } else {
                // Le Noeud precedant n'est pas l'enfant direct du noeud courrant.<
                // donc : le precedant est a droite de son parent.
                parentPrecedant._droite = precedant._gauche;
            }
        }
    }


    /**
     * Cherche si une clef appartient a l'arbre binaire de recherche.
     * @param clef La clef recherche.  Ne devrait pas etre null.
     * @return
     */
    public boolean contient( Clef clef ) {
        assert null != clef;

        Pair< Noeud< Clef >, Noeud< Clef > > resultat = rechercheNoeud( clef );

        return null != resultat.deuxieme;
    }

    /**
     * Ajoute une clef dans l'arbre a condition qu'elle ne soit pas
     * deja presente.
     * @param clef La clef a ajouter.  Ne devrait pas etre null.
     */
    public void inserer( Clef clef ) {
        assert null != clef;

        if( null == _racine ) {
            // donc : l'arbre etait vide, ajouter le noeud a la racine.
            _racine = new Noeud< Clef >( clef );
        } else {
            // donc : l'arbre n'est pas vide, trouver ou inserer le noeud.
            Pair< Noeud< Clef >, Noeud< Clef > > resultat = rechercheNoeud( clef );

            if( null == resultat.deuxieme ) {
                // donc : la clef n'est pas presente dans l'arbre.
                // Trouver de quel cote du noeud parent nous devons inserer le noeud.
                int direction = clef.compareTo( resultat.premiere._clef );

                if( direction < 0 ) {
                    resultat.premiere._gauche = new Noeud< Clef >( clef );
                } else {
                    resultat.premiere._droite = new Noeud< Clef >( clef );
                }
            }
        }
    }

    /**
     * Enleve une clef de l'arbre a condition qu'elle soit presente.
     * @param clef La clef a supprimer de l'arbre.  clef ne devrait pas etre null.
     */
    public void supprimer( Clef clef ) {
        assert null != clef;

        // Trouver la clef a supprimer.
        Pair< Noeud< Clef >, Noeud< Clef > > resultat = rechercheNoeud( clef );

        if( null != resultat.deuxieme ) {
            // donc : la clef existe dans l'arbre, supprimer le noeud qui la contient.
            supprimerNoeud( resultat.premiere, resultat.deuxieme );
        }
    }

    /**
     * Transforme un arbre binaire de recherche en une representation infixe sous
     * forme d'une chaine de caracteres.
     */
    public String toString() {
        return ( null != _racine )
                ? _racine.toString()
                : "vide";
    }

    /**
     * Trouve la hauteur d'un noeud.
     */
    public int hauteurI(Clef noeud) {
        int hauteur = 0;
        Noeud<Clef> actuel = _racine;
        while ( actuel != null && noeud.compareTo(actuel._clef) != 0 ){
            if (noeud.compareTo(actuel._clef) > 0){
                actuel = actuel._droite;
                // est-ce que le else if est necessaire ?
            } else if (noeud.compareTo(actuel._clef) < 0){
                actuel = actuel._gauche;
            }
            hauteur++;
        }

        return actuel == null
            ? -1
            : hauteur;
    }

    /**
     * Trouve hauteur d'un noeud !
     */

    public int hauteurR(Clef clef){
        // ici, je cache la recurssion d'un point de vue de l'utilisateur.
        return recurssion(clef, _racine, 0);
    }

    private int recurssion(Clef clef, Noeud<Clef> actuel, int hauteur) {
        int retour = -1;
        if (actuel != null) {
            if (clef.compareTo(actuel._clef) == 0){
                retour = hauteur;
            } else {
                retour = clef.compareTo(actuel._clef) < 0
                        ? recurssion(clef,actuel._gauche, ++hauteur)
                        : recurssion(clef,actuel._droite, ++hauteur);
            }
        }
        return retour;
    }

    public void remplirOrdonne(ArrayList<Clef> liste){
        donnerClefsOrdonneesR(_racine, liste);
    }
    private void donnerClefsOrdonneesR(Noeud<Clef> actuel, ArrayList<Clef> liste) {
        if( actuel._gauche != null){
           donnerClefsOrdonneesR(actuel._gauche, liste);
        }
        liste.add(actuel._clef);
        if (actuel._droite != null ){
            donnerClefsOrdonneesR(actuel._droite, liste);
        }
    }
}
