# Checkliste de Validation – Classes du Projet Papillon

> Cette checkliste permet de vérifier que chaque classe est propre, complète et conforme à l’UML avant le merge final sur la branche stable.

---

## Contrôleur

### `ControleurRappel.java`
- [X] JavaDoc complète (classe + méthodes publiques)
- [X] Respect du rôle du contrôleur (aucune logique graphique)
- [X] Appelle le modèle (DAO) et met à jour la vue via des méthodes dédiées
- [X] Gestion correcte des erreurs (try/catch + `ErrorManager` )
- [X] Aucun `System.out.println()` de debug
- [X] UML conforme (relations avec `ModelRappelDAO` et `VueMainFrame`)

---

## Modèle (Model)

### `ModelRappel.java`
- [X] JavaDoc complète (classe + getters/setters)
- [X] Attributs privés + getters/setters publics
- [X] Constructeur complet (id, titre, contenu, thème, rang)
- [X] Respecte le rôle de simple “donnée”
- [X] Pas de logique de BD ni d’affichage
- [X] UML conforme

### `ModelRappelDAO.java`
- [X] JavaDoc complète
- [X] Contient les 5 opérations CRUD (`ajouter`, `modifier`, `supprimer`, `get`, `getAll`)
- [X] Utilise `DBManager` pour la connexion
- [X] Ferme les connexions (`try-with-resources`)
- [X] Gestion propre des exceptions SQL
- [X] Pas de message console, utilise `ErrorManager` ou exceptions personnalisées
- [X] UML conforme

### `DBManager.java`
- [X] JavaDoc présente
- [X] Méthode `getConnection()` stable et testée
- [X] Utilise le bon driver SQLite
- [X] Aucune variable inutile / aucun code commenté
- [X] UML conforme

### `ComparateurRang.java`
- [X] Implémente `Comparator<ModelRappel>`
- [X] Compare correctement les rappels selon leur `rang`
- [X] JavaDoc et commentaire sur la logique de tri
- [X] UML conforme

### `ErrorManager.java`
- [X] Contient des méthodes statiques pour afficher les erreurs (`showError(...)`)
- [X] Utilise `JOptionPane` (pas de `System.err`)
- [X] JavaDoc complète
- [X] UML conforme

---

## Vue (View)

### `VueMainFrame.java`
- [X] JavaDoc complète
- [X] Fenêtre principale (CardLayout ou équivalent)
- [X] `setAlwaysOnTop(true)` configuré
- [X] Ne contient pas de logique métier (purement graphique)
- [X] Gère le changement de panel via une méthode `showPanel(String)`
- [X] UML conforme (relation avec les panels + contrôleur)

### `VueListePanel.java`
- [X] JavaDoc complète
- [X] Affiche correctement la liste des rappels
- [X] Boutons “Ajouter”, “Modifier”, “Supprimer” présents
- [X] Listeners attachés via classes dédiées
- [X] Design conforme à la charte graphique
- [X] UML conforme

### `VueDetailPanel.java`
- [X] JavaDoc complète
- [X] Affiche titre, contenu, date, thème
- [X] Bouton “Retour” présent et relié au listener
- [X] Respect du thème visuel
- [X] UML conforme

### `VueRappelAddPanel.java`
- [X] JavaDoc complète
- [X] Champs (titre, contenu, thème, rang) fonctionnels
- [X] Boutons “Valider” et “Annuler” avec listeners séparés
- [X] `ListenerTheme` fonctionne et passe par le contrôleur
- [X] UML conforme

### `VueRappelModifPanel.java`
- [X] JavaDoc complète
- [X] Même structure que `VueRappelAddPanel`
- [X] Pré-remplissage des champs à partir d’un `ModelRappel`
- [X] Listener de validation appelle `ControleurRappel.modifierRappel()`
- [X] UML conforme

---

## Listeners

### `ListenerBtn.java`
- [X] JavaDoc complète
- [X] Appelle uniquement des méthodes du contrôleur (aucune logique)
- [X] Correctement attaché dans la vue correspondante
- [X] UML conforme

### `ListenerAjoutBD.java`
- [X] JavaDoc complète
- [X] Appelle `ControleurRappel.ajouterRappel()`
- [X] Pas de logique BD directe
- [X] UML conforme

### `ListenerModifierRappel.java`
- [X] JavaDoc complète
- [X] Appelle `ControleurRappel.modifierRappel()`
- [X] Ne contient aucune logique de DAO
- [X] UML conforme

### `ListenerModifieBD.java`
- [X] JavaDoc complète
- [X] Gère les modifications d’un rappel via le contrôleur
- [X] Vérifie la cohérence entre le modèle et la vue
- [X] UML conforme

### `ListenerTheme.java`
- [X] JavaDoc complète
- [X] Appelle `ControleurRappel.changerTheme()` (pas de `setBackground()` direct)
- [X] Ne crée pas lui-même les `addActionListener`
- [X] UML conforme

### `ListenerFermeture.java`
- [X] JavaDoc complète
- [X] Gère la fermeture propre de la fenêtre
- [X] UML conforme

---

## Utilitaires

### `Utils.java`
- [X] JavaDoc présente
- [X] Contient uniquement des méthodes statiques réutilisables
- [X] Pas de dépendance vers la vue
- [X] Code clair, testé et utile
- [X] UML conforme

---

## App / Point d’entrée

### `App.java`
- [X] JavaDoc présente
- [X] Contient le `main()` du projet
- [X] Initialise le contrôleur et la vue (`new ControleurRappel(new VueMainFrame())`)
- [X] Lance correctement l’application
- [X] Pas de logique métier
- [X] UML conforme

---

## Validation finale (avant merge)

- [X] Tous les fichiers compilent sans warning  
- [X] Tous les fichiers ont une JavaDoc complète  
- [ ] Tous les fichiers sont présents dans le diagramme UML  
- [X] Aucun listener ne contient de logique métier  
- [X] Le code suit le schéma MVC  
- [X] Le projet tourne sans erreur (`make run`)  

---

