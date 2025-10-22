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
- [ ] JavaDoc complète (classe + getters/setters)
- [X] Attributs privés + getters/setters publics
- [X] Constructeur complet (id, titre, contenu, thème, rang)
- [ ] Respecte le rôle de simple “donnée”
- [ ] Pas de logique de BD ni d’affichage
- [ ] UML conforme

### `ModelRappelDAO.java`
- [ ] JavaDoc complète
- [X] Contient les 5 opérations CRUD (`ajouter`, `modifier`, `supprimer`, `get`, `getAll`)
- [X] Utilise `DBManager` pour la connexion
- [X] Ferme les connexions (`try-with-resources`)
- [X] Gestion propre des exceptions SQL
- [X] Pas de message console, utilise `ErrorManager` ou exceptions personnalisées
- [ ] UML conforme

### `DBManager.java`
- [ ] JavaDoc présente
- [ ] Méthode `getConnection()` stable et testée
- [ ] Utilise le bon driver SQLite
- [ ] Aucune variable inutile / aucun code commenté
- [ ] UML conforme

### `ComparateurRang.java`
- [X] Implémente `Comparator<ModelRappel>`
- [X] Compare correctement les rappels selon leur `rang`
- [X] JavaDoc et commentaire sur la logique de tri
- [X] UML conforme

### `ErrorManager.java`
- [ ] Contient des méthodes statiques pour afficher les erreurs (`showError(...)`)
- [ ] Utilise `JOptionPane` (pas de `System.err`)
- [ ] JavaDoc complète
- [ ] UML conforme

---

## Vue (View)

### `VueMainFrame.java`
- [ ] JavaDoc complète
- [ ] Fenêtre principale (CardLayout ou équivalent)
- [ ] `setAlwaysOnTop(true)` configuré
- [ ] Ne contient pas de logique métier (purement graphique)
- [ ] Gère le changement de panel via une méthode `showPanel(String)`
- [ ] UML conforme (relation avec les panels + contrôleur)

### `VueListePanel.java`
- [ ] JavaDoc complète
- [ ] Affiche correctement la liste des rappels
- [ ] Boutons “Ajouter”, “Modifier”, “Supprimer” présents
- [ ] Listeners attachés via classes dédiées
- [ ] Design conforme à la charte graphique
- [ ] UML conforme

### `VueDetailPanel.java`
- [ ] JavaDoc complète
- [ ] Affiche titre, contenu, date, thème
- [ ] Bouton “Retour” présent et relié au listener
- [ ] Respect du thème visuel
- [ ] UML conforme

### `VueRappelAddPanel.java`
- [ ] JavaDoc complète
- [X] Champs (titre, contenu, thème, rang) fonctionnels
- [X] Boutons “Valider” et “Annuler” avec listeners séparés
- [X] `ListenerTheme` fonctionne et passe par le contrôleur
- [ ] UML conforme

### `VueRappelModifPanel.java`
- [ ] JavaDoc complète
- [X] Même structure que `VueRappelAddPanel`
- [X] Pré-remplissage des champs à partir d’un `ModelRappel`
- [X] Listener de validation appelle `ControleurRappel.modifierRappel()`
- [ ] UML conforme

---

## Listeners

### `ListenerBtn.java`
- [ ] JavaDoc complète
- [ ] Appelle uniquement des méthodes du contrôleur (aucune logique)
- [ ] Correctement attaché dans la vue correspondante
- [ ] UML conforme

### `ListenerAjoutBD.java`
- [X] JavaDoc complète
- [X] Appelle `ControleurRappel.ajouterRappel()`
- [X] Pas de logique BD directe
- [X] UML conforme

### `ListenerModifierRappel.java`
- [X] JavaDoc complète
- [X] Appelle `ControleurRappel.modifierRappel()`
- [X] Ne contient aucune logique de DAO
- [ ] UML conforme

### `ListenerModifieBD.java`
- [X] JavaDoc complète
- [X] Gère les modifications d’un rappel via le contrôleur
- [X] Vérifie la cohérence entre le modèle et la vue
- [ ] UML conforme

### `ListenerTheme.java`
- [X] JavaDoc complète
- [X] Appelle `ControleurRappel.changerTheme()` (pas de `setBackground()` direct)
- [X] Ne crée pas lui-même les `addActionListener`
- [ ] UML conforme

### `ListenerFermeture.java`
- [X] JavaDoc complète
- [X] Gère la fermeture propre de la fenêtre
- [ ] UML conforme

---

## Utilitaires

### `Utils.java`
- [ ] JavaDoc présente
- [ ] Contient uniquement des méthodes statiques réutilisables
- [ ] Pas de dépendance vers la vue
- [ ] Code clair, testé et utile
- [ ] UML conforme

---

## App / Point d’entrée

### `App.java`
- [ ] JavaDoc présente
- [X] Contient le `main()` du projet
- [X] Initialise le contrôleur et la vue (`new ControleurRappel(new VueMainFrame())`)
- [X] Lance correctement l’application
- [ ] Pas de logique métier
- [ ] UML conforme

---

## Validation finale (avant merge)

- [X] Tous les fichiers compilent sans warning  
- [ ] Tous les fichiers ont une JavaDoc complète  
- [ ] Tous les fichiers sont présents dans le diagramme UML  
- [ ] Aucun listener ne contient de logique métier  
- [X] Le code suit le schéma MVC  
- [ ] Le projet tourne sans erreur (`make run`)  

---

