# Gestionnaire d'Expressions Arithmétiques (Java & JavaFX)

## Présentation du projet
Ce projet implémente une application complète de gestion et de manipulation d'expressions arithmétiques binaires (ex: $r = 2 - 3 / (a * b) + 1$). Il a été développé à l'ENSIIE pour mettre en pratique les concepts de programmation orientée objet avancée et l'architecture logicielle.

Le dépôt est organisé en deux étapes clés :
1. **TP_expressions (Moteur de calcul) :** Développement des structures d'arbres binaires (Binary Expression Trees) et du parseur d'expressions infixes.
2. **TP_expressions(JavaFX) (Interface graphique) :** Intégration du moteur dans une application interactive utilisant l'architecture MVC (Modèle-Vue-Contrôleur).

## Détails Techniques

### Architecture et Modèle de Données
L'application utilise massivement les génériques Java (`<E extends Number>`) pour supporter différents types numériques (Integer, Float, Double). Les expressions sont modélisées par des interfaces structurantes :
* **ValueHolder** : Gère la présence et le calcul de la valeur numérique.
* **ParentHolder / Container** : Gèrent les relations hiérarchiques au sein de l'arbre d'expression.
* **Zippers / Arbres** : Les expressions terminales (constantes, variables) forment les feuilles, tandis que les opérateurs binaires constituent les nœuds.

### Algorithme de Parsing
Le parseur utilise l'algorithme des deux piles (Shunting-yard simplifié) pour transformer des chaînes de caractères infixes en structures arborescentes, en gérant les priorités d'opérateurs et les parenthèses.

### Interface JavaFX (MVC)
* **Modèle** : `ExpressionsModel` centralise la liste des expressions et les variables partagées.
* **Vue** : Définie via `ExpressionsFrame.fxml` avec des composants `TreeView` (structure de l'arbre) et `TableView` (valeurs en temps réel).
* **Contrôleur** : `Controller.java` assure la liaison via des propriétés observables et des listeners JavaFX.

## Protocole de lancement
Ce projet est configuré avec Maven pour être indépendant de l'IDE utilisé (Eclipse, VS Code, IntelliJ, ...).

### Prérequis
* Java JDK 21 ou supérieur.
* Maven 3.6 ou supérieur.

### Compilation et Exécution
- Ouvrez un terminal dans le dossier du projet final :
    cd "TP_expressions(JavaFX)"

- Nettoyez et installez les dépendances :
    mvn clean install

- Lancez l'interface graphique :
    mvn javafx:run

## Tests Unitaires
Pour vérifier la validité du moteur de calcul et du parseur :
    mvn test

## Fichiers de test
Des exemples d'expressions (chargement via le menu File > Open dans l'application JavaFX) sont disponibles dans le dossier assets/.
