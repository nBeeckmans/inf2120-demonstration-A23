# Description des classes 
- Ces classes sont des contenants de generiques
- Elles heritent de PeutEtre qui est abstraite (qui represente l'existance incertaine de l'Objet T)
- Rien est la classe enfant de PeutEtre qui confirme l'inexistance de l'Objet
- QQChose est la classe enfant de PeutEtre qui confirme l'existance de l'Objet
- ARien est l'exception generee si on essaye d'accede a l'objet T de la classe Rien (Protege contre un null pointer exception)

Exemple reel : 

Jeu dans lequel on regarde a chaque frame(image) si on a eu un user input (entree utilisateur, ex : clavier)
Notre methode doit retourner un objet, cependant, si ce qu'on retourne est vide (parce que l'utilisateur est partie prendre un cafe), on ne veut pas que les autres methodes essayes d'acceder au "user-input". 

code simplifie: 
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
      if ( userInput.estQQChose) {
          // faire quelque chose
      }    
}
```
Pourquoi pas un null ? 

Dangereux, on a pas de methodes qui retourne une valeur vraie ou fausse indiquant la presence de l'objet. 
On peut reutiliser les methodes de presence et absence dans des algorithmes ! 


