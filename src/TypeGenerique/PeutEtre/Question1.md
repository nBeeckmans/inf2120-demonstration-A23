# Description des classes 
- Ces classes sont des contenants de generiques
- Elles heritent de PeutEtre qui est abstraite (qui represente l'existance incertaine de l'Objet de type T)
- Rien est la classe enfant de PeutEtre qui confirme l'inexistance de l'Objet
- QQChose est la classe enfant de PeutEtre qui confirme l'existance de l'Objet
- ARien est l'exception generee si on essaye d'accede a l'objet T de la classe Rien (Protege contre un null pointer exception)

__Exemple reel :__ 

Jeu dans lequel on regarde a chaque frame(image) si on a eu un user input (entree utilisateur, ex : clavier)
Notre methode doit retourner un objet, cependant, si ce qu'on retourne est vide (parce que l'utilisateur est parti prendre un cafe), on ne veut pas que les autres methodes essayent d'acceder au "user-input". 

__code simplifie:__ 
```java
public static void main(String[] args) {
        GameState gameState; 
        Frame frame; 
        while(true) {
            PeutEtre<UserInput> userInput = regarderInput(); 
            gameState.modifier(userInput); 
            frame.mettreAJour(gameState); 
        }   
}

...
public modifier(PeutEtre<UserInput> userInput) {
      if ( userInput.estQQChose()) {
          // faire quelque chose
      }    
}
```
__Pourquoi pas un NULL ?__ 

Dangereux, on a pas de methodes qui retourne une valeur vraie ou fausse indiquant la presence de l'objet. 
On peut reutiliser les methodes de presence et absence dans des algorithmes ! 

__Autre cas (que je connais)__:

C et Rust (qui n'a pas de NULL non plus) n'ont pas d'exceptions comme en Java, ainsi un object ou une structure de donnee. 
Avec un moyen de retourner l'absence d'objet est necessaire. 

